package kr.co.trappan.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Adapter.ReviewListAdapter;
import kr.co.trappan.Bean.Review;
import kr.co.trappan.Bean.Tour;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.Item.SearchLists_item;
import kr.co.trappan.R;

public class DetailInformationActivity extends AppCompatActivity {

    private ImageView main_image;
    private TextView title;
    private ImageView btn_want, btn_stamp, btn_rate;
    private TextView detailRateAvg;
    private TextView detailWant;
    private TextView detailRate;
    private ImageView detailBtnType;
    private TextView detailType;
    private TextView detailAddr;
    private TextView detailStamp;
    private ImageView deTailbtnReco;

    private RecyclerView recyclerView;
    private ReviewListAdapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Dialog ratingDialog;
    private RatingBar ratingBar;

    private FloatingActionButton floatingActionButton;

    private TextView overview;
    private TextView btn_more;
    Tour item;

    String star_rate="";
    ArrayList<Review> items = new ArrayList<>();

    String contentid;
    AQuery aq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_information);

        RequestParams params = new RequestParams();
        Intent intent = getIntent();
        contentid = intent.getExtras().getString("contentid");
        params.put("contentid", contentid);
        main_image=(ImageView)findViewById(R.id.detail_image);
        title =(TextView)findViewById(R.id.detail_title);
        btn_want =(ImageView)findViewById(R.id.detail_btn_want);
        detailWant = (TextView)findViewById(R.id.detail_want);
        btn_stamp =(ImageView)findViewById(R.id.detail_btn_stamp);
        detailStamp = (TextView)findViewById(R.id.detail_stamp);
        btn_rate =(ImageView)findViewById(R.id.detail_btn_rate);
        overview =(TextView)findViewById(R.id.detail_overview);
        btn_more=(TextView)findViewById(R.id.btn_more);
        detailRateAvg = (TextView)findViewById(R.id.detail_rate_average);

        detailRate = (TextView)findViewById(R.id.detail_rate);
        detailBtnType = (ImageView) findViewById(R.id.detail_btn_type);
        detailType = (TextView)findViewById(R.id.detail_type);
        detailAddr = (TextView) findViewById(R.id.detail_addr);
        deTailbtnReco = (ImageView) findViewById(R.id.detail_btn_reco);

        floatingActionButton=(FloatingActionButton)findViewById(R.id.floating_button);
        aq = new AQuery(this);

        HttpClient.get("detailinfo", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    item = new Tour(response.getString("addr1"),
                            response.getString("addr2"),
                            response.getString("areacode"),
                            response.getString("cat2"),
                            response.getString("contentid"),
                            response.getString("contenttypeid"),
                            response.getString("firstimage"),
                            response.getInt("like"),
                            response.getString("mapx"),
                            response.getString("mapy"),
                            response.getString("mlevel"),
                            response.getString("overview"),
                            response.getInt("rate"),
                            response.getString("sigungucode"),
                            response.getInt("stamp"),
                            response.getString("title")
                    );



                    //이미지 세팅
                    aq.id(main_image).image(item.getFirstimage());

                    //평균 평점
                    detailRateAvg.setText(item.getRate());

                    //타이틀 세팅
                    title.setText(item.getTitle());
                    //주소
                    detailAddr.setText(item.getAddr1());//볼드로 해야됨
                    //좋아요
                    detailWant.setText(item.getLike());
                    //스탬프
                    detailStamp.setText(item.getStamp());

                    //타입
                    switch (item.getCat2()){
                        case "A0101":{ detailBtnType.setImageResource(R.drawable.detail_icon_04_a0101);
                            detailType.setText("자연");
                            break;}
                        case "A0201":{ detailBtnType.setImageResource(R.drawable.detail_icon_04_a0201);
                            detailType.setText("역사");
                            break;}
                        case "A0202":{ detailBtnType.setImageResource(R.drawable.detail_icon_04_a0202);
                            detailType.setText("휴양");
                            break;}
                        case "A0203":{ detailBtnType.setImageResource(R.drawable.detail_icon_04_a0203);
                            detailType.setText("체험");
                            break;}
                        case "A0205":{ detailBtnType.setImageResource(R.drawable.detail_icon_04_a0205);
                            detailType.setText("건축");
                            break;}
                        case "A0206":{ detailBtnType.setImageResource(R.drawable.detail_icon_04_a0206);
                            detailType.setText("문화시설");
                            break;}
                        case "A0207":{ detailBtnType.setImageResource(R.drawable.detail_icon_04_a0207);
                            detailType.setText("축제");
                            break;}
                    }


                    //설명 세팅
                    if(item.getOverview().length()<30) {
                        overview.setText(item.getOverview());
                        btn_more.setVisibility(View.INVISIBLE);
                    } else{
                        overview.setText(item.getOverview().substring(0,30)+"...");
                    }
                    btn_more.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(btn_more.getText().toString()=="더보기"){
                                btn_more.setText("접기");
                                overview.setText(item.getOverview());
                            }else{
                                overview.setText(item.getOverview().substring(0,30)+"...");
                                btn_more.setText("더보기");
                            }
                        }
                    });


                }catch (JSONException e){

                }

            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });



        recyclerView=(RecyclerView)findViewById(R.id.detail_information_list);
        recyclerView.setHasFixedSize(true);

        RecyclerViewHeader header = (RecyclerViewHeader) findViewById(R.id.header);



        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Adapter = new ReviewListAdapter(this ,items);
        recyclerView.setAdapter(Adapter);
        header.attachTo(recyclerView);

        HttpClient.get("test", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                try {

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = response.getJSONObject(i);
                        Review item=new Review();
                        item.setId(obj.getString("id"));
                        item.setImg_1(obj.getString("img_1"));
                        item.setReview_title(obj.getString("review_title"));
                        item.setReview_content(obj.getString("review_content"));
                        items.add(item);
                    }
                    Adapter.setItems(items);
                    Adapter.notifyDataSetChanged();
                    //pd.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });



        btn_want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_want.setBackgroundResource(R.drawable.detail_icon_01_02);
            }
        });
        btn_stamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_stamp.setBackgroundResource(R.drawable.detail_icon_02_02);
            }
        });
        btn_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingDialog=new Dialog(DetailInformationActivity.this);
                ratingDialog.setContentView(R.layout.rating_dialog);
                ratingDialog.setCancelable(true);
                ratingBar = (RatingBar)ratingDialog.findViewById(R.id.ratingBar);
                ratingBar.setRating(0);

                Drawable progress = ratingBar.getProgressDrawable();
                DrawableCompat.setTint(progress, Color.LTGRAY);

                LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
                stars.getDrawable(2).setColorFilter(Color.parseColor("#f8b62b"), PorterDuff.Mode.SRC_ATOP);

                TextView text = (TextView) ratingDialog.findViewById(R.id.rating_text);
                text.setText("별점주기");

                Button updateButton = (Button) ratingDialog.findViewById(R.id.btn_check);
                updateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("rate",star_rate);
                        btn_rate.setBackgroundResource(R.drawable.detail_icon_03_02);
                        ratingDialog.dismiss();
                    }
                });

                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        star_rate=""+rating;
                    }
                });
                //now that the dialog is set up, it's time to show it
                ratingDialog.show();

            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailInformationActivity.this,ReviewWriteActivity.class);
                intent.putExtra("contentid","22");
                startActivity(intent);
            }
        });

    }


}
