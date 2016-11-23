package kr.co.trappan.Activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Adapter.ReviewPagerAdapter;
import kr.co.trappan.Bean.Comment;
import kr.co.trappan.Bean.Follow;
import kr.co.trappan.Bean.Member;
import kr.co.trappan.Bean.Review;
import kr.co.trappan.Bean.ReviewLike;
import kr.co.trappan.Bean.Tour;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.Item.CustomProgressDialog;
import kr.co.trappan.R;

public class ReviewPageActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private LinearLayout btn_back;
    private ImageView user_image;
    private TextView user_id;
    private ImageView btn_follow;
    private TextView review_date;
    private TextView review_area_name;
    private TextView review_tour_title;
    private TextView review_title;
    private TextView review_content;
    private TextView num_like;
    private TextView num_comment;
    private Button btn_like;
    private Button btn_comment;

    int rlikeflag;
    int reviewid;
    String id;
    Review review;
    Member member;
    Comment comment;
    ReviewLike reviewLike;
    Tour tour;
    Follow follow;
    AQuery aq;
    String a=null;
    private CustomProgressDialog pd;

    ArrayList<String> pager_image_list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_page);
        Intent intent = getIntent();
        reviewid = intent.getExtras().getInt("review_id");
        id = intent.getExtras().getString("id");
        pd = new CustomProgressDialog(ReviewPageActivity.this);
        pd .getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        pd.show();
        aq=new AQuery(this);

        viewPager=(ViewPager)findViewById(R.id.review_viewpager);

        btn_back=(LinearLayout) findViewById(R.id.btn_back);
        user_image=(ImageView)findViewById(R.id.user_image);
        user_id=(TextView)findViewById(R.id.user_id);
        btn_follow=(ImageView)findViewById(R.id.btn_follow);
        review_date=(TextView)findViewById(R.id.review_date);
        review_area_name=(TextView)findViewById(R.id.review_area_name);
        review_tour_title=(TextView)findViewById(R.id.review_tour_title);
        review_title=(TextView)findViewById(R.id.review_title);
        review_content=(TextView)findViewById(R.id.review_content);
        num_like=(TextView)findViewById(R.id.num_like);
        num_comment=(TextView)findViewById(R.id.num_comment);
        btn_like=(Button)findViewById(R.id.review_like_button);
        btn_comment=(Button)findViewById(R.id.review_comment_button);
        final ReviewPagerAdapter adapter=new ReviewPagerAdapter(getLayoutInflater(),pager_image_list);
        viewPager.setAdapter(adapter);
        RequestParams params = new RequestParams();
        params.put("review_id", reviewid);
        params.put("id", id);
        HttpClient.get("detailreview", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {

                    review.setC_date(response.getString("c_date"));
                    review.setReview_title(response.getString("review_title"));
                    review.setReview_content(response.getString("review_content"));
                    review.setImg_1(response.getString("img_1"));
                    review.setImg_2(response.getString("img_2"));
                    review.setImg_3(response.getString("img_3"));
                    review.setImg_4(response.getString("img_4"));
                    review.setImg_5(response.getString("img_5"));
                    review.setImg_6(response.getString("img_6"));

                    member=new Member();
                    member.setPro_img(response.getString("id"));
                    member.setId(response.getString("pro_img"));

                    comment=new Comment();
                    comment.setComment_count(response.getInt("comment_count"));

                    reviewLike=new ReviewLike();
                    reviewLike.setLike_count(response.getInt("like_count"));

                    tour=new Tour();
                    tour.setTitle(response.getString("title"));
                    tour.setAreaName(response.getString("areaName"));

                    if(response.getInt("islike")==0){
                        rlikeflag = 0;
                    }else{
                        rlikeflag =1;
                    }

                    //이미지 세팅

                    review_date.setText(review.getC_date());
                    review_title.setText(review.getReview_title());
                    review_content.setText(review.getReview_content());

                    aq.id(user_image).image(member.getPro_img());
                    user_id.setText(member.getId());

                    num_comment.setText(comment.getComment_count());

                    num_like.setText(reviewLike.getLike_count());

                    review_title.setText(review.getReview_title());
                    review_content.setText(review.getReview_content());

                    if(review.getImg_1()!=null)
                        pager_image_list.add(review.getImg_1());
                    if(review.getImg_2()!=null)
                        pager_image_list.add(review.getImg_2());
                    if(review.getImg_3()!=null)
                        pager_image_list.add(review.getImg_3());
                    if(review.getImg_4()!=null)
                        pager_image_list.add(review.getImg_4());
                    if(review.getImg_5()!=null)
                        pager_image_list.add(review.getImg_5());
                    if(review.getImg_6()!=null)
                        pager_image_list.add(review.getImg_6());

                    if(response.getInt("is_rlike") == 0){
                        btn_like.setBackgroundResource(R.drawable.like);
                    }else{
                        btn_like.setBackgroundResource(R.drawable.like_s);
                    }
                    pd.dismiss();



                    adapter.notifyDataSetChanged();

                }catch (JSONException e){

                }






            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                super.onFailure(statusCode, headers, throwable, response);
                pd.dismiss();
            }
        });



        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params = new RequestParams();
                params.put("review_id", reviewid);
                HttpClient.get("addreviewlike", params, new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        super.onSuccess(statusCode, headers, response);
                        btn_like.setBackgroundResource(R.drawable.like_s);
                    }
                });

            }
        });
        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewPageActivity.this, CommentActivity.class);
                intent.putExtra("review_id", reviewid);
                startActivity(intent);
            }
        });
    }
}
