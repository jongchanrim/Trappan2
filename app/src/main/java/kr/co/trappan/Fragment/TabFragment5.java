package kr.co.trappan.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidquery.AQuery;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.pkmmte.view.CircularImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Activity.CommentActivity;
import kr.co.trappan.Activity.DetailInformationActivity;
import kr.co.trappan.Activity.FollowerActivity;
import kr.co.trappan.Activity.FollowingActivity;
import kr.co.trappan.Activity.LikeActivity;
import kr.co.trappan.Activity.My_CommentActivity;
import kr.co.trappan.Activity.ReviewPageActivity;
import kr.co.trappan.Activity.SearchActivity;
import kr.co.trappan.Adapter.ListViewAdapter;
import kr.co.trappan.Adapter.ReviewListAdapter;
import kr.co.trappan.Bean.Review;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.Item.List_item;
import kr.co.trappan.Item.RecyclerViewOnItemClickListener;
import kr.co.trappan.R;

import static android.R.attr.data;
import static android.R.attr.defaultWidth;
import static android.R.attr.icon;
import static android.app.Activity.RESULT_OK;


/**
 * Created by thfad_000 on 2016-10-04.
 */
public class TabFragment5 extends Fragment{
    static final String TAG = SearchActivity.class.getSimpleName();
    Context context;
    private RecyclerView recyclerView;
    private ReviewListAdapter Adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Review> items = new ArrayList<>();
    private ImageView back_img;
    private CircularImageView pro_img;

    private ImageButton f5_btn_backimg;
    private ImageButton f5_btn_proimg;

    private LinearLayout f5_btn_follower;
    private LinearLayout f5_btn_following;
    private LinearLayout f5_btn_tlike;
    private LinearLayout f5_btn_stamp;
    private LinearLayout f5_btn_rlike;
    private LinearLayout f5_btn_comment;


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
    Bitmap proimg;
    Bitmap backimg;
    BitmapFactory.Options options;



    private int back_or_profile = 0;  //배경이미지와 프로필 이미지 선택 변수 (1로바뀌면 배경, 2로바뀌면 프로필)
    AQuery aq;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment5, container, false);
        context = getContext();
        aq = new AQuery(view);
        options = new BitmapFactory.Options();options = new BitmapFactory.Options();
        options.inSampleSize = 4;

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

        f5_btn_follower = (LinearLayout)view.findViewById(R.id.f5_btn_follower);
          f5_btn_following = (LinearLayout)view.findViewById(R.id.f5_btn_following);
          f5_btn_tlike = (LinearLayout)view.findViewById(R.id.f5_btn_tlike);
          f5_btn_stamp = (LinearLayout)view.findViewById(R.id.f5_btn_stamp);
          f5_btn_rlike= (LinearLayout)view.findViewById(R.id.f5_btn_rlike);
          f5_btn_comment= (LinearLayout)view.findViewById(R.id.f5_btn_comment);;

        recyclerView = (RecyclerView) view.findViewById(R.id.mypage_scroll);
        RecyclerViewHeader header = (RecyclerViewHeader) view.findViewById(R.id.header5);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new ReviewListAdapter(getActivity(),items);
        recyclerView.setAdapter(Adapter);
        header.attachTo(recyclerView);

        HttpClient.get("detailmypage", null, new JsonHttpResponseHandler() { // Profile
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {

                    user_name.setText(response.getString("name"));
                    user_profile.setText(response.getString("intro"));
                    follower.setText(response.getString("count_following"));
                    following.setText(response.getString("count_follower"));
                    tlike.setText(response.getString("count_tlike"));
                    stamp.setText(response.getString("count_stamp"));
                    rlike.setText(response.getString("count_rlike"));
                    comment.setText(response.getString("count_comment"));

                    try {
                        if(response.getString("pro_img")!=null){
                        //    aq.id(pro_img).image(response.getString("pro_img"));
                        }

                        aq.id(back_img).image(response.getString("back_img"));
                    }catch (Exception e){

                    }

                }catch (Exception e){

                }
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });

        HttpClient.get("mreviewlist", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                try {

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = response.getJSONObject(i);
                        Review item = new Review();
                        item.setId(obj.getString("id"));
                        item.setImg_1(obj.getString("img_1"));
                        item.setReview_id(obj.getInt("review_id"));
                        item.setReview_title(obj.getString("review_title"));
                        item.setReview_content(obj.getString("review_content"));
                        items.add(item);
                    }

                    Adapter.notifyDataSetChanged();
                    //pd.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });


        f5_btn_backimg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        back_or_profile = 1;
                        showFileChooser();
                        //doTakeAlbumAction();
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
                        .setNeutralButton("갤러리",albumListener)
                        .setNegativeButton("취소",cancelListener)
                        .show();
            }
        });

        f5_btn_proimg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        back_or_profile = 2;
                        showFileChooser();
                        //doTakeAlbumAction();
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
                        .setNeutralButton("갤러리",albumListener)
                        .setNegativeButton("취소",cancelListener)
                        .show();
            }
        });

        f5_btn_follower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FollowerActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        f5_btn_following.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext(), FollowingActivity.class);
                startActivity(intent);
            }

        });
        f5_btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext(), My_CommentActivity.class);
                startActivity(intent);
            }
        });
        f5_btn_rlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext(), LikeActivity.class);
                startActivity(intent);

            }
        });

        f5_btn_stamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        f5_btn_tlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext(), SearchActivity.class);
                startActivity(intent);
                intent.putExtra("case","tlike");
            }
        });


        recyclerView.addOnItemTouchListener(new

                RecyclerViewOnItemClickListener(getActivity(), recyclerView,
                new RecyclerViewOnItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {

                        Intent intent = new Intent(getActivity(), ReviewPageActivity.class);
                        intent.putExtra("review_id", items.get(position).getReview_id());
                        intent.putExtra("id", items.get(position).getId());
                        startActivity(intent); // 다음 화면으로 넘어간다.
                    }

                    @Override
                    public void onItemLongClick(View v, int position) {
                    }
                }

        ));



        return view;
    }


    public void doTakePhotoAction(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Log.d(TAG, "doTakePhotoAction");
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

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    //앨범에서 이미지 가져오기
    public void doTakeAlbumAction(){
        //앨범 호출
        Log.d(TAG, "doTakeAlbumAction");
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult");

        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            Log.d(TAG, filePath.toString());
            try {
                //Getting the Bitmap from Gallery
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePath);
                bitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, true);
                final ProgressDialog loading = ProgressDialog.show(getActivity(),"Uploading...","Please wait...",false,false);
                //Setting the Bitmap to ImageView
                loading.show();
                if (back_or_profile == 1) {
                    String image = getStringImage(bitmap);
                    RequestParams params = new RequestParams();
                    params.put("back_img", image);
                    Log.d(TAG, "back_or_profile");

                    HttpClient.post("updatebackimg", params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            super.onSuccess(statusCode, headers, response);
                            try {
                                String url = response.getString("back_img");
                                Log.d(TAG, url);
                                if (url != null) {
                                    aq=null;
                                    aq=new AQuery(getView());
                                    //aq.id(back_img).dataChanged();
                                    Log.d("dddd",""+response.getString("back_img"));
                                    aq.id(back_img).image(response.getString("back_img"),false,false);
                                }
                            } catch (JSONException e) {
                                loading.dismiss();
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            super.onFailure(statusCode, headers, throwable, errorResponse);
                            Log.d(TAG, "실패");
                            loading.dismiss();
                        }
                    });
                } else if (back_or_profile == 2) {
                    String image = getStringImage(bitmap);
                    RequestParams params = new RequestParams();
                    params.put("pro_img", image);
                    JSONArray arr = new JSONArray("{sdfsdf}");
                    HttpClient.post("updateproimg", params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            super.onSuccess(statusCode, headers, response);
                            try {
                                if (response.getString("pro_img") != null) {
                                    try {
                                        URL url = new URL(response.getString("pro_img"));
                                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                                        connection.setDoInput(true);
                                        connection.connect();
                                        InputStream input = connection.getInputStream();
                                        Bitmap myBitmap = BitmapFactory.decodeStream(input);
                                        pro_img.setImageBitmap(myBitmap);
                                        loading.dismiss();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        loading.dismiss();
                                    }

                                }
                            } catch (JSONException e) {

                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            super.onFailure(statusCode, headers, throwable, errorResponse);
                            loading.dismiss();
                        }
                    });
                }
            } catch (Exception e) {

            }
        }
    }

 /*   @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult");
        if(resultCode != RESULT_OK)
            return;

        switch(requestCode){
            case PICK_FROM_ALBUM:
            {
                //이후의 처리가 카메라와 같으므로 일단 break없이 진행
                //실제코드에서는 좀더 합리적인 방법 선택
                if(back_or_profile == 1) {

                    try {
                        mlmageCaptureUri_background = data.getData();
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), mlmageCaptureUri_background);
                        Log.d("PICK_FROM_ALBUM", mlmageCaptureUri_background.getPath().toString());
                        String image = getStringImage(bitmap);
                        RequestParams params = new RequestParams();
                        params.put("back_img", image);

                        HttpClient.get("updatebackimg", params, new JsonHttpResponseHandler(){
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                super.onSuccess(statusCode, headers, response);
                                try {
                                    if (response.getString("back_img") != null) {
                                        aq.id(back_img).image(response.getString("back_img"));
                                    }
                                }catch (JSONException e){

                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                                super.onFailure(statusCode, headers, throwable, errorResponse);
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else if(back_or_profile == 2){

                    Log.d("PICK_FROM_ALBUM", mlmageCaptureUri_profile.getPath().toString());
                    try {
                        mlmageCaptureUri_profile = data.getData();
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), mlmageCaptureUri_background);
                        Log.d("PICK_FROM_ALBUM", mlmageCaptureUri_background.getPath().toString());
                        String image = getStringImage(bitmap);
                        RequestParams params = new RequestParams();
                        params.put("pro_img", image);

                        HttpClient.get("updateproimg", params, new JsonHttpResponseHandler(){
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                super.onSuccess(statusCode, headers, response);
                                try {
                                    if (response.getString("pro_img") != null) {
                                        aq.id(back_img).image(response.getString("pro_img"));
                                    }
                                }catch (JSONException e){

                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                                super.onFailure(statusCode, headers, throwable, errorResponse);
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
//            case PICK_FROM_CAMERA:
//            {
//
//                if(back_or_profile == 1) {
//                    Log.d("PICK_FROM_CAMERA", " back_img.setImageURI(mlmageCaptureUri_background);");
//
//                    back_or_profile = 0;
//                }
//                else if(back_or_profile == 2){
//                    Log.d("PICK_FROM_CAMERA", "pro_img.setImageURI(mlmageCaptureUri_profile);");
//                    pro_img.setImageURI(mlmageCaptureUri_profile);
//                    back_or_profile = 0;
//                }
//                break;
//            }

        }

    }

    */

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }


    private int PICK_IMAGE_REQUEST = 1;
    private String UPLOAD_URL ="http://52.78.184.207:8080/TreppanServer/Trappan?cmd=updatebackimg";


   /* private void uploadImage(){
        //Showing the progress dialog
        final ProgressDialog loading = ProgressDialog.show(getActivity(),"Uploading...","Please wait...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Disimissing the progress dialog
                        loading.dismiss();
                        Log.d("sdf",  "ss");
                        try {
                            JSONObject obj = new JSONObject(s);
                            if (obj.getString("back_img") != null) {
                                aq.id(back_img).image(obj.getString("back_img"));
                                Log.d("sdf",  obj.getString("back_img"));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Showing toast message of the response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        loading.dismiss();
                        Log.d("sdf", "error");
                        //Showing toast
                    }
                }){


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Converting Bitmap to String
                String image = getStringImage(backimg);

                //Getting Image Name

                //Creating parameters
                Map<String,String> params = new Hashtable<String, String>();

                //Adding parameters
                params.put("back_img", image);
                Log.d("sdf",  image);

                //returning parameters
                return params;
            }
        };
        //Creating a Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }
*/
}
