package kr.co.trappan.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.pkmmte.view.CircularImageView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import kr.co.trappan.Adapter.ListViewAdapter;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment5, container, false);

        resizeList = (RecyclerView) view.findViewById(R.id.mypage_scroll);
        RecyclerViewHeader header = (RecyclerViewHeader) view.findViewById(R.id.header5);

        mybackimage = (ImageView) view.findViewById(R.id.mybackimage);
        circularImageView = (CircularImageView) view.findViewById(R.id.CircularImageView);

        mybackedit = (ImageButton)view.findViewById(R.id.mybackedit);
        mybackedit.setOnClickListener(new View.OnClickListener(){
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

        myprofileedit = (ImageButton)view.findViewById(R.id.myprofileedit);
        myprofileedit.setOnClickListener(new View.OnClickListener(){
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

        CircularImageView circularImageView = (CircularImageView)view.findViewById(R.id.CircularImageView);
        circularImageView.setBorderWidth(10);
        circularImageView.setSelectorStrokeWidth(10);
        circularImageView.addShadow();


        context = getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.mypage_scroll);
        recyclerView.setHasFixedSize(true);

        ArrayList<List_item> items = new ArrayList<>();

        items.add(new List_item(R.drawable.gangwon,"후기","1","테스트1"));
        items.add(new List_item(R.drawable.gangwon,"후기","2","테스트2"));
        items.add(new List_item(R.drawable.gangwon,"후기","3","테스트3"));
        items.add(new List_item(R.drawable.gangwon,"후기","4","테스트4"));
        items.add(new List_item(R.drawable.gangwon,"후기","5","테스트5"));
        items.add(new List_item(R.drawable.gangwon,"후기","6","테스트6"));
        items.add(new List_item(R.drawable.gangwon,"후기","7","테스트7"));
        items.add(new List_item(R.drawable.gangwon,"후기","8","테스트8"));
        items.add(new List_item(R.drawable.gangwon,"후기","9","테스트9"));
        items.add(new List_item(R.drawable.gangwon,"후기","10","테스트10"));

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new ListViewAdapter(getActivity() ,items ,R.layout.tabfragment5);
        recyclerView.setAdapter(Adapter);
        header.attachTo(recyclerView);

        //resizeCommentList(items.size());

        return view;
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
