package kr.co.trappan.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.TextView;

import com.androidquery.AQuery;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.pkmmte.view.CircularImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Adapter.ListViewAdapter;
import kr.co.trappan.Adapter.ReviewListAdapter;
import kr.co.trappan.Bean.Review;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.Item.CustomProgressDialog;
import kr.co.trappan.Item.List_item;
import kr.co.trappan.R;

import static android.app.Activity.RESULT_OK;

public class MemberPageActivity extends AppCompatActivity {

    Context context;
    private RecyclerView recyclerView;
    private ReviewListAdapter Adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Review> items = new ArrayList<>();
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
    private CustomProgressDialog pd;
    private int back_or_profile = 0;  //배경이미지와 프로필 이미지 선택 변수 (1로바뀌면 배경, 2로바뀌면 프로필)
    AQuery aq;

    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent  = getIntent();
        user_id  =intent.getExtras().getString("user_id");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_page);
        aq = new AQuery(this);
        CircularImageView circularImageView = (CircularImageView)this.findViewById(R.id.f5_proimg);
        circularImageView.setBorderWidth(10);
        circularImageView.setSelectorStrokeWidth(10);
        circularImageView.addShadow();
        back_img = (ImageView) this.findViewById(R.id.f5_backimg);
        pro_img = (CircularImageView) this.findViewById(R.id.f5_proimg);
        f5_btn_backimg = (ImageButton)this.findViewById(R.id.f5_btn_backimg);
        f5_btn_proimg = (ImageButton)this.findViewById(R.id.f5_btn_proimg);

        pd = new CustomProgressDialog(MemberPageActivity.this);
        pd .getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        pd.show();

        user_name=(TextView)this.findViewById(R.id.f5_username) ;
        user_profile=(TextView)this.findViewById(R.id.f5_profile);
        follower=(TextView)this.findViewById(R.id.f5_follower);
        following=(TextView)this.findViewById(R.id.f5_following);
        tlike=(TextView)this.findViewById(R.id.f5_tlike);
        stamp=(TextView)this.findViewById(R.id.f5_stamp);
        rlike=(TextView)this.findViewById(R.id.f5_rlike);
        comment=(TextView)this.findViewById(R.id.f5_comment);

        recyclerView = (RecyclerView) this.findViewById(R.id.mypage_scroll);
        RecyclerViewHeader header = (RecyclerViewHeader) this.findViewById(R.id.header5);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new ReviewListAdapter(this,items);
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
                        aq.id(pro_img).image(response.getString("pro_img"));
                        aq.id(back_img).image(response.getString("back_img"));
                    }catch (Exception e){

                    }

                }catch (Exception e){

                }
                pd.dismiss();

            }


            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                super.onFailure(statusCode, headers, throwable, response);
                pd.dismiss();

            }
        });

        HttpClient.get("reviewlist", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                try {

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = response.getJSONObject(i);
                        Review item = new Review();
                        item.setId(obj.getString("id"));
                        item.setImg_1(obj.getString("img_1"));
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




        follower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FollowerActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        following.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MemberPageActivity.this, FollowingActivity.class);
                startActivity(intent);
            }

        });
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MemberPageActivity.this, My_CommentActivity.class);
                startActivity(intent);
            }
        });
        rlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MemberPageActivity.this, LikeActivity.class);
                startActivity(intent);

            }
        });

        /*
        스템프 액티비티도 넣어야함
        */



    }



}
