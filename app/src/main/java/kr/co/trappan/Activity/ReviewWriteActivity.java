package kr.co.trappan.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.R;

public class ReviewWriteActivity extends AppCompatActivity {

    Context context;

    private static final int PICK_FROM_CAMERA = 0;
    private static final int PICK_FROM_ALBUM = 1;
    private static final int CROP_FROM_IMAGE = 2;

    /**************완료 버튼 눌렀을 때 서버로 보낼 변수들**************/
    private Uri mlmageCaptureUri_img1;  //Uri 업로드이미지1 변수
    private Uri mlmageCaptureUri_img2;  //Uri 업로드이미지2 변수
    private Uri mlmageCaptureUri_img3;  //Uri 업로드이미지3 변수
    private Uri mlmageCaptureUri_img4;  //Uri 업로드이미지4 변수
    private Uri mlmageCaptureUri_img5;  //Uri 업로드이미지5 변수
    private Uri mlmageCaptureUri_img6;  //Uri 업로드이미지6 변수
    private String review_title;        //리뷰 제목 변수
    private String review_content;      //리뷰 내용 변수
    /******************************************************************/

    private ImageView iv_UserPhoto;
    private String absoultePath;

    private ImageView review_img1;
    private ImageView review_img2;
    private ImageView review_img3;
    private ImageView review_img4;
    private ImageView review_img5;
    private ImageView review_img6;

    private EditText review_title_edittext;
    private EditText review_content_edittext;

    private ImageButton review_backbutton;
    private Button review_completebutton;
    private Button review_imageupload_button;
///////////////////
    private int imagenumber = 0; //업로드이미지 위치에 순서대로 보여주기 위한 변수
    private String contentid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        contentid = intent.getExtras().getString("contentid");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_write);

        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);

        review_img1 = (ImageView) findViewById(R.id.review_img1);
        review_img2 = (ImageView) findViewById(R.id.review_img2);
        review_img3 = (ImageView) findViewById(R.id.review_img3);
        review_img4 = (ImageView) findViewById(R.id.review_img4);
        review_img5 = (ImageView) findViewById(R.id.review_img5);
        review_img6 = (ImageView) findViewById(R.id.review_img6);

        review_title_edittext = (EditText) findViewById(R.id.review_title);
        review_content_edittext =(EditText) findViewById(R.id.review_content);

        /*사이즈 조절하기 위한 함수들*/
        LayoutParams params1 = (LayoutParams) review_img1.getLayoutParams();
        LayoutParams params2 = (LayoutParams) review_img2.getLayoutParams();
        LayoutParams params3 = (LayoutParams) review_img3.getLayoutParams();
        LayoutParams params4 = (LayoutParams) review_img4.getLayoutParams();
        LayoutParams params5 = (LayoutParams) review_img5.getLayoutParams();
        LayoutParams params6 = (LayoutParams) review_img6.getLayoutParams();

        params1.width = metrics.widthPixels/3;
        params1.height = metrics.heightPixels/6;
        params2.width = metrics.widthPixels/3;
        params2.height = metrics.heightPixels/6;
        params3.width = metrics.widthPixels/3;
        params3.height = metrics.heightPixels/6;
        params4.width = metrics.widthPixels/3;
        params4.height = metrics.heightPixels/6;
        params5.width = metrics.widthPixels/3;
        params5.height = metrics.heightPixels/6;
        params6.width = metrics.widthPixels/3;
        params6.height = metrics.heightPixels/6;

        review_img1.setLayoutParams(params1);
        review_img2.setLayoutParams(params2);
        review_img3.setLayoutParams(params3);
        review_img4.setLayoutParams(params4);
        review_img5.setLayoutParams(params5);
        review_img6.setLayoutParams(params6);
        /*여기까지 사이즈 조절 함수*/

        View.OnClickListener Click = new View.OnClickListener(){
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
                        imagenumber++;
                        if(imagenumber <= 6) {
                            doTakeAlbumAction();
                        }
                        else{
                            Toast.makeText(ReviewWriteActivity.this, "사진 6장 초과", Toast.LENGTH_SHORT).show();
                        }
                    }
                };

                DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                };

                new AlertDialog.Builder(ReviewWriteActivity.this)
                        .setTitle("업로드 이미지 선택")
                        .setPositiveButton("카메라",cameraListener)
                        .setNeutralButton("갤러리",albumListener)
                        .setNegativeButton("취소",cancelListener)
                        .show();
            }
        };

        //뒤로가기 버튼
        review_backbutton = (ImageButton)findViewById(R.id.review_backbutton);
        review_backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewWriteActivity.this, DetailInformationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //완료 버튼
        review_completebutton = (Button)findViewById(R.id.review_completebutton);
        review_completebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // File myFile = new File("/path/to/file.png");
//                RequestParams params = new RequestParams();
//                try {
//                    //params.put("profile_picture", myFile);
//                } catch(FileNotFoundException e) {
//
//                }
//                HttpClient.get("addreaview", params, new JsonHttpResponseHandler() {
//                            @Override
//                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                                super.onSuccess(statusCode, headers, response);
//                                Intent intent = new Intent(ReviewWriteActivity.this, DetailInformationActivity.class);
//                                startActivity(intent);
//                                finish();
//                            }
//                        }
//
//                );
                review_title = review_title_edittext.getText().toString();
                review_content = review_content_edittext.getText().toString();
                Toast.makeText(ReviewWriteActivity.this, "완료", Toast.LENGTH_SHORT).show();
            }
        });
        review_imageupload_button = (Button)findViewById(R.id.review_imageupload_button);
        review_imageupload_button.setOnClickListener(Click);

    }

    public void doTakePhotoAction(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //임시로 사용할 파일의 경로를 생성
        String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        if(imagenumber == 1) {
            mlmageCaptureUri_img1 = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));
        }
        else if(imagenumber == 2){
            mlmageCaptureUri_img2 = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));
        }
        else if(imagenumber == 3){
            mlmageCaptureUri_img3 = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));
        }
        else if(imagenumber == 4){
            mlmageCaptureUri_img4 = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));
        }
        else if(imagenumber == 5){
            mlmageCaptureUri_img5 = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));
        }
        else if(imagenumber == 6){
            mlmageCaptureUri_img6 = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));
        }
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
                //이후의 처리가 카메라와 가으므로 일단 break없이 진행
                //실제코드에서는 좀더 합리적인 방법 선택
                if(imagenumber == 1) {
                    mlmageCaptureUri_img1 = data.getData();
                    Log.d("SmartWeel", mlmageCaptureUri_img1.getPath().toString());
                }
                else if(imagenumber == 2){
                    mlmageCaptureUri_img2 = data.getData();
                    Log.d("SmartWeel", mlmageCaptureUri_img2.getPath().toString());
                }
                else if(imagenumber == 3){
                    mlmageCaptureUri_img3 = data.getData();
                    Log.d("SmartWeel", mlmageCaptureUri_img3.getPath().toString());
                }
                else if(imagenumber == 4){
                    mlmageCaptureUri_img4 = data.getData();
                    Log.d("SmartWeel", mlmageCaptureUri_img4.getPath().toString());
                }
                else if(imagenumber == 5){
                    mlmageCaptureUri_img5 = data.getData();
                    Log.d("SmartWeel", mlmageCaptureUri_img5.getPath().toString());
                }
                else if(imagenumber == 6){
                    mlmageCaptureUri_img6 = data.getData();
                    Log.d("SmartWeel", mlmageCaptureUri_img6.getPath().toString());
                }
            }
            case PICK_FROM_CAMERA:
            {
                //이미지를 가져온 이후의 리사이즈할 이미지 크기 결정
                //이후에 이미지 크롭 어플리케이션 호출
                Intent intent = new Intent("com.android.camera.action.CROP");
                if(imagenumber == 1) {
                    intent.setDataAndType(mlmageCaptureUri_img1, "image/");
                }
                else if(imagenumber == 2){
                    intent.setDataAndType(mlmageCaptureUri_img2, "image/");
                }
                else if(imagenumber == 3){
                    intent.setDataAndType(mlmageCaptureUri_img3, "image/");
                }
                else if(imagenumber == 4){
                    intent.setDataAndType(mlmageCaptureUri_img4, "image/");
                }
                else if(imagenumber == 5){
                    intent.setDataAndType(mlmageCaptureUri_img5, "image/");
                }
                else if(imagenumber == 6){
                    intent.setDataAndType(mlmageCaptureUri_img6, "image/");
                }

                //크롭할 이미지를 200*200으로 저장
                intent.putExtra("outputX",200);
                intent.putExtra("outputY",200);
                intent.putExtra("aspectX",1);
                intent.putExtra("aspectY",1);
                intent.putExtra("scale",true);
                intent.putExtra("return-data",false);
                startActivityForResult(intent, CROP_FROM_IMAGE);

                if(imagenumber == 1) {
                    review_img1.setImageURI(mlmageCaptureUri_img1);
                }
                else if(imagenumber == 2){
                    review_img2.setImageURI(mlmageCaptureUri_img2);
                }
                else if(imagenumber == 3){
                    review_img3.setImageURI(mlmageCaptureUri_img3);
                }
                else if(imagenumber == 4){
                    review_img4.setImageURI(mlmageCaptureUri_img4);
                }
                else if(imagenumber == 5){
                    review_img5.setImageURI(mlmageCaptureUri_img5);
                }
                else if(imagenumber == 6){
                    review_img6.setImageURI(mlmageCaptureUri_img6);
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
                    Bitmap photo = extras.getParcelable("data");//CROP된 BITMAP
                    iv_UserPhoto.setImageBitmap(photo); //레이아웃의 이미지칸에 CROP된 BITMAP을 보여줌

                    storeCropImage(photo, filePath);//CROP된 이미지를 외부저장소, 앨범에 저장

                    absoultePath = filePath;
                    break;
                }
                //임시파일삭제
                if(imagenumber == 1) {
                    File f = new File(mlmageCaptureUri_img1.getPath());
                    if (f.exists()) {
                        f.delete();
                    }
                }
                else if(imagenumber == 2){
                    File f = new File(mlmageCaptureUri_img2.getPath());
                    if (f.exists()) {
                        f.delete();
                    }
                }
                else if(imagenumber == 3){
                    File f = new File(mlmageCaptureUri_img3.getPath());
                    if (f.exists()) {
                        f.delete();
                    }
                }
                else if(imagenumber == 4){
                    File f = new File(mlmageCaptureUri_img4.getPath());
                    if (f.exists()) {
                        f.delete();
                    }
                }
                else if(imagenumber == 5){
                    File f = new File(mlmageCaptureUri_img5.getPath());
                    if (f.exists()) {
                        f.delete();
                    }
                }
                else if(imagenumber == 6){
                    File f = new File(mlmageCaptureUri_img6.getPath());
                    if (f.exists()) {
                        f.delete();
                    }
                }


            }
        }
    }

    private void storeCropImage(Bitmap bitmap, String filePath){
        //SmartWheel 폴더를 생성하여 이미지를 저장하는 방식이다.
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath()+
                "/SmartWeel";
        File directory_SmartWheel = new File(dirPath);

        if(!directory_SmartWheel.exists())//SmartWheel 디렉토리에 폴더가없다면
            directory_SmartWheel.mkdir();

        File copyFile = new File(filePath);
        BufferedOutputStream out = null;

        try{
            copyFile.createNewFile();
            out = new BufferedOutputStream(new FileOutputStream(copyFile));
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
