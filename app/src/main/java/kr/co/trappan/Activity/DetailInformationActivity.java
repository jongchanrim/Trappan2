package kr.co.trappan.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
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
import kr.co.trappan.Item.CustomProgressDialog;
import kr.co.trappan.Item.RecyclerViewOnItemClickListener;
import kr.co.trappan.R;

public class DetailInformationActivity extends AppCompatActivity implements  OnMapReadyCallback{


    private GoogleMap googleMap;


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

    String star_rate = "";
    ArrayList<Review> items = new ArrayList<>();

    String contentid;
    AQuery aq;


    Double myrate = 0.0;
    int myrateflag;
    String mystamp;
    int mystampflag;
    String mytlike;
    int mytlikeflag;
    static final String TAG = DetailInformationActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_information);



        final ScrollView scroll = (ScrollView) findViewById(R.id.scroll);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Intent intent = getIntent();
        contentid = intent.getExtras().getString("contentid");

        main_image = (ImageView) findViewById(R.id.detail_main_image);
        title = (TextView) findViewById(R.id.detail_title);
        btn_want = (ImageView) findViewById(R.id.detail_btn_want);
        detailWant = (TextView) findViewById(R.id.detail_want);
        btn_stamp = (ImageView) findViewById(R.id.detail_btn_stamp);
        detailStamp = (TextView) findViewById(R.id.detail_stamp);
        btn_rate = (ImageView) findViewById(R.id.detail_btn_rate);
        overview = (TextView) findViewById(R.id.detail_overview);
        btn_more = (TextView) findViewById(R.id.btn_more);
        detailRateAvg = (TextView) findViewById(R.id.detail_rate_average);

        detailRate = (TextView) findViewById(R.id.detail_rate);
        detailBtnType = (ImageView) findViewById(R.id.detail_btn_type);
        detailType = (TextView) findViewById(R.id.detail_type);
        detailAddr = (TextView) findViewById(R.id.detail_addr);
        deTailbtnReco = (ImageView) findViewById(R.id.detail_btn_reco);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_button);
        aq = new AQuery(this);
        item = new Tour();
        RequestParams params = new RequestParams();
        params.put("contentid", contentid);

        HttpClient.get("detailinfo", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.d(TAG, "httpOK: " + response.toString());
                try {
                    item.setAddr1(response.getString("addr1"));
                    item.setAreacode(response.getString("areacode"));
                    item.setCat2(response.getString("cat2"));
                    item.setContentid(response.getString("contentid"));
                    item.setFirstimage(response.getString("firstimage"));
                    item.setLike(response.getInt("tlike"));
                    item.setMapx(response.getString("mapx"));
                    item.setMapy(response.getString("mapy"));
                    item.setMlevel(response.getString("mlevel"));
                    item.setOverview(response.getString("overview"));
                    item.setRate(response.getDouble("rate"));
                    item.setSigungucode(response.getString("sigungucode"));
                    item.setStamp(response.getInt("stamp"));
                    item.setTitle(response.getString("title"));

                    Log.d(TAG, "getStamp: " + item.getFirstimage());
                    Log.d(TAG, "getTitle: " + item.getTitle());


                    myrate = response.getDouble("myrate");
                    mystamp = response.getString("mystamp");
                    mytlike = response.getString("mytlike");

                    Log.d(TAG, "mytlike: " + mytlike);
                    Log.d(TAG, "mystamp: " + mystamp);

                    if (myrate == 0) {
                        btn_rate.setBackgroundResource(R.drawable.detail_icon_03_01);
                        myrateflag = 0;
                    } else {
                        btn_rate.setBackgroundResource(R.drawable.detail_icon_03_02);
                        myrateflag = 1;


                    }

                    if (mystamp.equals("0")) {
                        btn_stamp.setBackgroundResource(R.drawable.detail_icon_02_01);
                        mystampflag = 0;
                    } else {
                        btn_stamp.setBackgroundResource(R.drawable.detail_icon_02_02);
                        mystampflag = 1;
                    }

                    if (mytlike.equals("0")) {
                        btn_want.setBackgroundResource(R.drawable.detail_icon_01_01);
                        mytlikeflag = 0;
                    } else {
                        btn_want.setBackgroundResource(R.drawable.detail_icon_01_02);
                        mytlikeflag = 1;
                    }


                    //이미지 세팅
                    aq.id(main_image).image(item.getFirstimage());
                    main_image.setColorFilter(Color.parseColor("#DADADA"), PorterDuff.Mode.MULTIPLY);

                    //평균 평점
                    detailRateAvg.setText(Double.toString(item.getRate()));

                    //타이틀 세팅
                    title.setText(item.getTitle());
                    //주소
                    detailAddr.setText(item.getAddr1());//볼드로 해야됨
                    //좋아요
                    detailWant.setText(Integer.toString(item.getLike()));
                    //스탬프
                    detailStamp.setText(Integer.toString(item.getStamp()));

                    //타입
                    switch (item.getCat2()) {
                        case "A0101": {
                            detailBtnType.setImageResource(R.drawable.detail_icon_04_a0101);
                            detailType.setText("자연");
                            break;
                        }
                        case "A0201": {
                            detailBtnType.setImageResource(R.drawable.detail_icon_04_a0201);
                            detailType.setText("역사");
                            break;
                        }
                        case "A0202": {
                            detailBtnType.setImageResource(R.drawable.detail_icon_04_a0202);
                            detailType.setText("휴양");
                            break;
                        }
                        case "A0203": {
                            detailBtnType.setImageResource(R.drawable.detail_icon_04_a0203);
                            detailType.setText("체험");
                            break;
                        }
                        case "A0205": {
                            detailBtnType.setImageResource(R.drawable.detail_icon_04_a0205);
                            detailType.setText("건축");
                            break;
                        }
                        case "A0206": {
                            detailBtnType.setImageResource(R.drawable.detail_icon_04_a0206);
                            detailType.setText("문화시설");
                            break;
                        }
                        case "A0207": {
                            detailBtnType.setImageResource(R.drawable.detail_icon_04_a0207);
                            detailType.setText("축제");
                            break;
                        }
                    }
                    //////////////////////////////////map//////////////////////////////////////////////////////

                    CameraUpdate update = CameraUpdateFactory.newLatLng(new LatLng(item.getMapy(),item.getMapx()));
                    googleMap.moveCamera(update);
                    CameraUpdate zoom = CameraUpdateFactory.zoomTo(14);
                    googleMap.animateCamera(zoom);

                    googleMap.getUiSettings().setZoomControlsEnabled(false);
                    googleMap.getUiSettings().setZoomGesturesEnabled(false);
                    googleMap.getUiSettings().setScrollGesturesEnabled(false);
                    googleMap.getUiSettings().setAllGesturesEnabled(false);

                    MarkerOptions markerOptions = new MarkerOptions()
                            // 마커 위치
                            .position(new LatLng(item.getMapy(),item.getMapx()))
                            .title(item.getTitle());

                    googleMap.addMarker(markerOptions).showInfoWindow();
                    //////////////////////////////////map//////////////////////////////////////////////////////

                    //설명 세팅
                    if (item.getOverview().length() < 100) {
                        overview.setText(item.getOverview());
                        btn_more.setVisibility(View.INVISIBLE);
                    } else {
                        overview.setText(item.getOverview().substring(0, 100) + "...");
                    }
                    btn_more.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (btn_more.getText().toString() == "더보기") {
                                btn_more.setText("접기");
                                overview.setText(item.getOverview());
                            } else {
                                overview.setText(item.getOverview().substring(0, 100) + "...");
                                btn_more.setText("더보기");
                            }
                        }
                    });

                } catch (JSONException e) {

                }

                ViewGroup myViewGroup = (ViewGroup) findViewById(R.id.activity_detail_information);
                myViewGroup.invalidate();


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.detail_information_list);
        recyclerView.setHasFixedSize(true);

        RecyclerViewHeader header = (RecyclerViewHeader) findViewById(R.id.header);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setNestedScrollingEnabled(false);


        Adapter = new ReviewListAdapter(this, items);
        recyclerView.setAdapter(Adapter);
        header.attachTo(recyclerView);

        HttpClient.get("reviewlist", params, new JsonHttpResponseHandler() {
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
                if (mytlikeflag == 0) {
                    btn_want.setBackgroundResource(R.drawable.detail_icon_01_02);
                    RequestParams params = new RequestParams();
                    params.put("contentid", contentid);
                    HttpClient.get("addtourlike", params, new JsonHttpResponseHandler() {
                                @Override
                                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                    super.onSuccess(statusCode, headers, response);
                                    detailWant.setText(Integer.toString(item.getLike() + 1));
                                    mytlikeflag = 1;
                                }
                            }

                    );
                } else {
                    btn_want.setBackgroundResource(R.drawable.detail_icon_01_01);
                    RequestParams params = new RequestParams();
                    params.put("contentid", contentid);
                    HttpClient.get("removetourlike", params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            super.onSuccess(statusCode, headers, response);
                            detailWant.setText(Integer.toString(item.getLike() - 1));
                            mytlikeflag = 0;
                        }
                    });
                }

            }
        });
        btn_stamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mystampflag == 0) {
                    btn_stamp.setBackgroundResource(R.drawable.detail_icon_02_02);
                    RequestParams params = new RequestParams();
                    params.put("contentid", contentid);
                    HttpClient.get("addstamp", params, new JsonHttpResponseHandler() {
                                @Override
                                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                    super.onSuccess(statusCode, headers, response);
                                    detailStamp.setText(Integer.toString(item.getStamp() + 1));
                                    mystampflag = 1;
                                }
                            }

                    );
                }

            }
        });
        btn_rate.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            ratingDialog = new Dialog(DetailInformationActivity.this);
                                            ratingDialog.setContentView(R.layout.rating_dialog);
                                            ratingDialog.setCancelable(true);
                                            ratingBar = (RatingBar) ratingDialog.findViewById(R.id.ratingBar);
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
                                                                                    Log.d("rate", star_rate);
                                                                                    btn_rate.setBackgroundResource(R.drawable.detail_icon_03_02);
                                                                                    RequestParams params = new RequestParams();
                                                                                    params.put("rate", star_rate);
                                                                                    if (myrateflag == 0) {
                                                                                        HttpClient.get("addrate", params, new JsonHttpResponseHandler() {
                                                                                                    @Override
                                                                                                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                                                                                        super.onSuccess(statusCode, headers, response);
                                                                                                        detailRate.setText(star_rate);
                                                                                                        myrateflag = 1;
                                                                                                    }
                                                                                                }

                                                                                        );
                                                                                    } else {
                                                                                        if (myrateflag == 1) {
                                                                                            HttpClient.get("updaterate", params, new JsonHttpResponseHandler() {
                                                                                                        @Override
                                                                                                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                                                                                            super.onSuccess(statusCode, headers, response);
                                                                                                            detailRate.setText(star_rate);
                                                                                                        }
                                                                                                    }

                                                                                            );
                                                                                        }

                                                                                    }
                                                                                    ratingDialog.dismiss();
                                                                                }
                                                                            }
                                            );

                                            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()

                                                                                   {
                                                                                       @Override
                                                                                       public void onRatingChanged(RatingBar ratingBar, float rating,
                                                                                                                   boolean fromUser) {
                                                                                           star_rate = "" + rating;
                                                                                       }
                                                                                   }

                                            );
                                            //now that the dialog is set up, it's time to show it
                                            ratingDialog.show();

                                        }
                                    }

        );

        floatingActionButton.setOnClickListener(new View.OnClickListener()

                                                {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent intent = new Intent(DetailInformationActivity.this, ReviewWriteActivity.class);
                                                        intent.putExtra("contentid", contentid);
                                                        startActivity(intent);
                                                    }
                                                }

        );

        recyclerView.addOnItemTouchListener(new

                RecyclerViewOnItemClickListener(DetailInformationActivity.this, recyclerView,
                new RecyclerViewOnItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {

                        Intent intent = new Intent(DetailInformationActivity.this, ReviewPageActivity.class);
                        intent.putExtra("review_id", items.get(position).getReview_id());
                        intent.putExtra("id", items.get(position).getId());
                        startActivity(intent); // 다음 화면으로 넘어간다.
                    }

                    @Override
                    public void onItemLongClick(View v, int position) {
                    }
                }

        ));
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        googleMap = map;

    }
}

