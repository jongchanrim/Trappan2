package kr.co.trappan.Activity;

import android.content.Intent;
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

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Adapter.ReviewPagerAdapter;
import kr.co.trappan.Bean.Review;
import kr.co.trappan.Bean.Tour;
import kr.co.trappan.Connector.HttpClient;
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

    String reviewid;
    Review review_item;
    AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_page);

        Intent intent = getIntent();
        reviewid = intent.getExtras().getString("reviewid");

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


        ReviewPagerAdapter adapter=new ReviewPagerAdapter(getLayoutInflater());
        viewPager.setAdapter(adapter);

        RequestParams params = new RequestParams();
        params.put("reviewid", reviewid);
        HttpClient.get("test", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    review_item = new Review(response.getString("user_image"),
                            response.getString("id"),
                            response.getString("c_date"),
                            response.getString("review_content"),
                            response.getString("review_title")
                    );



                    //이미지 세팅
                    aq.id(user_image).image(review_item.getUser_image());

                    user_id.setText(review_item.getId());
                    review_date.setText(review_item.getC_date());
                    review_title.setText(review_item.getReview_title());
                    review_content.setText(review_item.getReview_content());




                }catch (JSONException e){

                }

            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                super.onFailure(statusCode, headers, throwable, response);

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

            }
        });
        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
