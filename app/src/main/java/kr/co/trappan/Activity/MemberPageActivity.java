package kr.co.trappan.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.pkmmte.view.CircularImageView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import kr.co.trappan.Adapter.ListViewAdapter;
import kr.co.trappan.Item.List_item;
import kr.co.trappan.R;

import static android.app.Activity.RESULT_OK;

public class MemberPageActivity extends AppCompatActivity {

    Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView resizeList;

    private ImageView mybackimage;
    private CircularImageView circularImageView;

    private ImageButton mybackedit;
    private ImageButton myprofileedit;

    private static final int PICK_FROM_CAMERA = 0;
    private static final int PICK_FROM_ALBUM = 1;
    private static final int CROP_FROM_IMAGE = 2;

    private Uri mlmageCaptureUri;
    private ImageView iv_UserPhoto;
    private int id_view;
    private String absoultePath;

    private int back_or_profile = 0;  //배경이미지와 프로필 이미지 선택 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_page);

        resizeList = (RecyclerView) findViewById(R.id.mypage_scroll);

        mybackimage = (ImageView) findViewById(R.id.mybackimage);
        circularImageView = (CircularImageView) findViewById(R.id.CircularImageView);

        CircularImageView circularImageView = (CircularImageView)findViewById(R.id.CircularImageView);
        circularImageView.setBorderWidth(10);
        circularImageView.setSelectorStrokeWidth(10);
        circularImageView.addShadow();


        //context = getContext();
        recyclerView = (RecyclerView) findViewById(R.id.mypage_scroll);
        recyclerView.setHasFixedSize(true);

        ArrayList<List_item> items = new ArrayList<>();


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new ListViewAdapter(this ,items ,R.layout.tabfragment5);
        recyclerView.setAdapter(Adapter);

        resizeCommentList(items.size());
    }

    private void resizeCommentList(int item_size){
        ViewGroup.LayoutParams params = resizeList.getLayoutParams();
        params.height = 350 * item_size;
        resizeList.setLayoutParams(params);
    }

    public void doTakePhotoAction(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //임시로 사용할 파일의 경로를 생성
        String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        mlmageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mlmageCaptureUri);
        startActivityForResult(intent, PICK_FROM_CAMERA);
    }

    //앨범에서 이미지 가져오기
    public void doTakeAlbumAction(){
        //앨범 호출
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != RESULT_OK)
            return;

        switch(requestCode){
            case PICK_FROM_ALBUM:
            {
                //이후의 처리가 카메라와 같으므로 일단 break없이 진행
                //실제코드에서는 좀더 합리적인 방법 선택
                mlmageCaptureUri = data.getData();
                Log.d("SmartWeel", mlmageCaptureUri.getPath().toString());
            }
            case PICK_FROM_CAMERA:
            {
                //이미지를 가져온 이후의 리사이즈할 이미지 크기 결정
                //이후에 이미지 크롭 어플리케이션 호출
                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(mlmageCaptureUri, "image/");

                //크롭할 이미지를 200*200으로 저장
                intent.putExtra("outputX",200);
                intent.putExtra("outputY",200);
                intent.putExtra("aspectX",1);
                intent.putExtra("aspectY",1);
                intent.putExtra("scale",true);
                intent.putExtra("return-data",false);
                startActivityForResult(intent, CROP_FROM_IMAGE);

                if(back_or_profile == 1) {
                    mybackimage.setImageURI(mlmageCaptureUri);
                    back_or_profile = 0;
                }
                else if(back_or_profile == 2){
                    circularImageView.setImageURI(mlmageCaptureUri);
                    back_or_profile = 0;
                }

                break;
            }
            case CROP_FROM_IMAGE:
            {
                //크롭이 된 이후의 이미지 넘겨받기
                //이미지 뷰에 이미지를 보여준다거나 부가적인 작업 이후에
                //임시파일 삭제
                if(resultCode != RESULT_OK){
                    return;
                }
                final Bundle extras = data.getExtras();

                //CROP된 이미지를 저장하기 위한 FILE경로
                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath()+
                        "/SmartWheel/"+ System.currentTimeMillis()+".jpg";
                if(extras != null){
                    Bitmap photo = extras.getParcelable("data"); //CROP된 BITMAP
                    iv_UserPhoto.setImageBitmap(photo); //레이아웃의 이미지칸에 CROP된 BITMAP을 보여줌

                    storeCropImage(photo, filePath); //CROP된 이미지를 외부저장소, 앨범에 저장

                    absoultePath = filePath;
                    break;
                }
                //임시파일삭제
                File f = new File(mlmageCaptureUri.getPath());
                if(f.exists()){
                    f.delete();
                }
            }

        }
    }

    private void storeCropImage(Bitmap bitmap, String filePath){
        //SmartWheel 폴더를 생성하여 이미지를 저장하는 방식이다.
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath()+ "/SmartWeel";
        File directory_SmartWheel = new File(dirPath);

        if(!directory_SmartWheel.exists())//SmartWheel 디렉토리에 폴더가없다면
            directory_SmartWheel.mkdir();

        File copyFile = new File(filePath);
        BufferedOutputStream out = null;

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        // Calculate image's size by maintain the image's aspect ratio

        try{
            copyFile.createNewFile();
            out = new BufferedOutputStream(new FileOutputStream(copyFile));
            //bitmap = Bitmap.createScaledBitmap(bitmap, (width=5000), (height=height*1000/width), true);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,out);

            //sendBroadcast를 통해 Crop된 사진을 앨범에 보이도록 갱신한다.
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(copyFile)));

            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
