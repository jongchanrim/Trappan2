package kr.co.trappan.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.pkmmte.view.CircularImageView;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Adapter.ListViewAdapter;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.Item.List_item;
import kr.co.trappan.R;

import static android.app.Activity.RESULT_OK;


/**
 * Created by thfad_000 on 2016-10-04.
 */
public class TabFragment5 extends Fragment{

    Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ImageView back_img;
    private CircularImageView pro_img;

    private ImageButton f5_btn_backimg;
    private ImageButton f5_btn_proimg;

    private TextView user_name;
    private TextView user_profile;
    private TextView follower;
    private TextView following;
    private TextView tlike;
    private TextView stamp;
    private TextView rlike;
    private TextView comment;

    private static final int PICK_FROM_CAMERA = 0;
    private static final int PICK_FROM_ALBUM = 1;
    private static final int CROP_FROM_IMAGE = 2;

    private Uri mlmageCaptureUri_background;  //Uri 배경이미지 변수
    private Uri mlmageCaptureUri_profile;   //Uri 프로필이미지 변수

    private ImageView iv_UserPhoto;
    private int id_view;
    private String absoultePath;

    private int back_or_profile = 0;  //배경이미지와 프로필 이미지 선택 변수 (1로바뀌면 배경, 2로바뀌면 프로필)


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment5, container, false);
        context = getContext();

        CircularImageView circularImageView = (CircularImageView)view.findViewById(R.id.f5_proimg);
        circularImageView.setBorderWidth(10);
        circularImageView.setSelectorStrokeWidth(10);
        circularImageView.addShadow();
        back_img = (ImageView) view.findViewById(R.id.f5_backimg);
        pro_img = (CircularImageView) view.findViewById(R.id.f5_proimg);
        f5_btn_backimg = (ImageButton)view.findViewById(R.id.f5_btn_backimg);
        f5_btn_proimg = (ImageButton)view.findViewById(R.id.f5_btn_proimg);

        user_name=(TextView)view.findViewById(R.id.f5_username) ;
        user_profile=(TextView)view.findViewById(R.id.f5_profile);
        follower=(TextView)view.findViewById(R.id.f5_follower);
        following=(TextView)view.findViewById(R.id.f5_following);
        tlike=(TextView)view.findViewById(R.id.f5_tlike);
        stamp=(TextView)view.findViewById(R.id.f5_stamp);
        rlike=(TextView)view.findViewById(R.id.f5_rlike);
        comment=(TextView)view.findViewById(R.id.f5_comment);

        recyclerView = (RecyclerView) view.findViewById(R.id.mypage_scroll);
        RecyclerViewHeader header = (RecyclerViewHeader) view.findViewById(R.id.header5);
        recyclerView.setHasFixedSize(true);
        ArrayList<List_item> items = new ArrayList<>();
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new ListViewAdapter(getActivity() ,items ,R.layout.tabfragment5);
        recyclerView.setAdapter(Adapter);
        header.attachTo(recyclerView);

        //resizeCommentList(items.size());

        f5_btn_backimg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        doTakePhotoAction();
                    }
                };

                DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        back_or_profile = 1;
                        doTakeAlbumAction();
                    }
                };

                DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                };

                new AlertDialog.Builder(getActivity())
                        .setTitle("업로드 이미지 선택")
                        .setPositiveButton("카메라",cameraListener)
                        .setNeutralButton("갤러리",albumListener)
                        .setNegativeButton("취소",cancelListener)
                        .show();
            }
        });

        f5_btn_proimg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        doTakePhotoAction();
                    }
                };

                DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        back_or_profile = 2;
                        doTakeAlbumAction();
                    }
                };

                DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                };

                new AlertDialog.Builder(getActivity())
                        .setTitle("업로드 이미지 선택")
                        .setPositiveButton("카메라",cameraListener)
                        .setNeutralButton("갤러리",albumListener)
                        .setNegativeButton("취소",cancelListener)
                        .show();
            }
        });

        HttpClient.get("test", null, new JsonHttpResponseHandler() { // Profile
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {

                }catch (Exception e){

                }
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });

        HttpClient.get("test", null, new JsonHttpResponseHandler() { // List
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {

                }catch (Exception e){

                }
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });

        return view;
    }

    private void resizeCommentList(int item_size){
        ViewGroup.LayoutParams params = recyclerView.getLayoutParams();
        params.height = 350 * item_size;
        recyclerView.setLayoutParams(params);
    }

    public void doTakePhotoAction(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //임시로 사용할 파일의 경로를 생성
        String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";

        if(back_or_profile == 1) { //배경 이미지 Uri
            mlmageCaptureUri_background = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mlmageCaptureUri_background);
        }
        else if(back_or_profile == 2){
            mlmageCaptureUri_profile = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mlmageCaptureUri_profile);
        }
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
                if(back_or_profile == 1) {
                    mlmageCaptureUri_background = data.getData();
                    Log.d("SmartWeel", mlmageCaptureUri_background.getPath().toString());
                }
                else if(back_or_profile == 2){
                    mlmageCaptureUri_profile = data.getData();
                    Log.d("SmartWeel", mlmageCaptureUri_profile.getPath().toString());
                }
            }
            case PICK_FROM_CAMERA:
            {
                //이미지를 가져온 이후의 리사이즈할 이미지 크기 결정
                //이후에 이미지 크롭 어플리케이션 호출
                Intent intent = new Intent("com.android.camera.action.CROP");
                if(back_or_profile == 1) {
                    intent.setDataAndType(mlmageCaptureUri_background, "image/");
                }
                else if(back_or_profile == 2){
                    intent.setDataAndType(mlmageCaptureUri_profile, "image/");
                }

                //크롭할 이미지를 200*200으로 저장
                intent.putExtra("outputX",200);
                intent.putExtra("outputY",200);
                intent.putExtra("aspectX",1);
                intent.putExtra("aspectY",1);
                intent.putExtra("scale",true);
                intent.putExtra("return-data",false);
                startActivityForResult(intent, CROP_FROM_IMAGE);

                if(back_or_profile == 1) {
                    back_img.setImageURI(mlmageCaptureUri_background);
                    back_or_profile = 0;
                }
                else if(back_or_profile == 2){
                    pro_img.setImageURI(mlmageCaptureUri_profile);
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
                if(back_or_profile == 1) {
                    File f = new File(mlmageCaptureUri_background.getPath());
                    if(f.exists()){
                        f.delete();
                    }
                }
                else if(back_or_profile == 2){
                    File f = new File(mlmageCaptureUri_profile.getPath());
                    if(f.exists()){
                        f.delete();
                    }
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

//    public BitmapFactory.Options getBitmapSize(BitmapFactory.Options options){
//        int targetWidth = 0;
//        int targetHeight = 0;
//
//        if(options.outWidth > options.outHeight){
//            targetWidth = (int)(600 * 1.3);
//            targetHeight = 600;
//        }else{
//            targetWidth = 600;
//            targetHeight = (int)(600 * 1.3);
//        }
//
//        Boolean scaleByHeight = Math.abs(options.outHeight - targetHeight) >= Math.abs(options.outWidth - targetWidth);
//        if(options.outHeight * options.outWidth * 2 >= 16384){
//            double sampleSize = scaleByHeight
//                    ? options.outHeight / targetHeight
//                    : options.outWidth / targetWidth;
//            options.inSampleSize = (int) Math.pow(2d, Math.floor(Math.log(sampleSize)/Math.log(2d)));
//        }
//        options.inJustDecodeBounds = false;
//        options.inTempStorage = new byte[16*1024];
//
//        return options;
//    }
//
//    public static Bitmap loadBackgroundBitmap(Context context, String imgFilePath) {
//        File file = new File(imgFilePath);
//        if (file.exists() == false) {
//            return null;
//        }
//
//        // 폰의 화면 사이즈를 구한다.
//        Display display = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
//        int displayWidth = display.getWidth();
//        int displayHeight = display.getHeight();
//
//        // 읽어들일 이미지의 사이즈를 구한다.
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inPreferredConfig = Bitmap.Config.RGB_565;
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(imgFilePath, options);
//
//        // 화면 사이즈에 가장 근접하는 이미지의 스케일 팩터를 구한다.
//        // 스케일 팩터는 이미지 손실을 최소화하기 위해 짝수로 한다.
//        float widthScale = options.outWidth / displayWidth;
//        float heightScale = options.outHeight / displayHeight;
//        float scale = widthScale > heightScale ? widthScale : heightScale;
//
//        if (scale >= 8)
//            options.inSampleSize = 8;
//        else if (scale >= 6)
//            options.inSampleSize = 6;
//        else if (scale >= 4)
//            options.inSampleSize = 4;
//        else if (scale >= 2)
//            options.inSampleSize = 2;
//        else
//            options.inSampleSize = 1;
//        options.inJustDecodeBounds = false;
//
//        return BitmapFactory.decodeFile(imgFilePath, options);
//    }

}
