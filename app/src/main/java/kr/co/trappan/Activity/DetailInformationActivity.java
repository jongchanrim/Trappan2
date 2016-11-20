package kr.co.trappan.Activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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
import kr.co.trappan.Item.RecyclerViewOnItemClickListener;
import kr.co.trappan.Item.SearchLists_item;
import kr.co.trappan.R;

public class DetailInformationActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener, OnMapReadyCallback {

    /*************************************************구글맵***********************************************/
    static final LatLng SEOUL = new LatLng(37.56, 126.97);
    LatLng LOCATION;
    private static final String mapTAG = "@@@";
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private static final int REQUEST_CODE_LOCATION = 2000;//임의의 정수로 정의
    private GoogleMap googleMap;
    /******************************************************************************************************/

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
    private RecyclerViewHeader header;

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
        btn_more.setText("더보기");
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

                    if (mytlike .equals("0")) {
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
                            if (btn_more.getText() == "더보기") {
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

                ViewGroup myViewGroup = (ViewGroup) findViewById (R.id.activity_detail_information);
                myViewGroup.invalidate();


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.detail_information_list);
        recyclerView.setHasFixedSize(true);

        header = (RecyclerViewHeader) findViewById(R.id.header);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

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


        /*******************************************************************구글맵*****************************************************************/
        //권한검사
        if (ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //Marshmallow이상이면 코드에서 권한요청이 필요
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_CODE_LOCATION);
            }
        }
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        /*****************************************************************************************************************************************/
    }


    //    @Override
//    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
    public void test() {
        if (myrate == 0.0) {
            btn_rate.setBackgroundResource(R.drawable.detail_icon_03_01);
            myrateflag = 0;
        } else {
            btn_rate.setBackgroundResource(R.drawable.detail_icon_03_02);
            myrateflag = 1;


        }

        if (mystamp == null) {
            btn_stamp.setBackgroundResource(R.drawable.detail_icon_02_01);
            mystampflag = 0;
        } else {
            btn_stamp.setBackgroundResource(R.drawable.detail_icon_02_02);
            mystampflag = 1;
        }

        if (mytlike == null) {
            btn_want.setBackgroundResource(R.drawable.detail_icon_01_01);
            mytlikeflag = 0;
        } else {
            btn_want.setBackgroundResource(R.drawable.detail_icon_01_02);
            mytlikeflag = 1;
        }


        //이미지 세팅
        aq.id(main_image).image(item.getFirstimage());

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


        //설명 세팅
        if (item.getOverview().length() < 30) {
            overview.setText(item.getOverview());
            btn_more.setVisibility(View.INVISIBLE);
        } else {
            overview.setText(item.getOverview().substring(0, 30) + "...");
        }
        btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn_more.getText() == "더보기") {
                    btn_more.setText("접기");
                    overview.setText(item.getOverview());
                    header.attachTo(recyclerView);
                } else {
                    overview.setText(item.getOverview().substring(0, 30) + "...");
                    btn_more.setText("더보기");
                    header.attachTo(recyclerView);
                }
            }
        });
    }

    /*************************************************************구글맵*************************************************************/
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {

                    LocationAvailability locationAvailability = LocationServices.FusedLocationApi.getLocationAvailability(mGoogleApiClient);
                    if (locationAvailability.isLocationAvailable()) {
                        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
                    } else {

                        Marker seoul = googleMap.addMarker(new MarkerOptions().position(SEOUL).title("Seoul"));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 15));
                        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

                        Toast.makeText(this,"Location Unavialable",Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }

    /*
     * Runs when a GoogleApiClient object successfully connects.
     */
    @Override
    public void onConnected(@Nullable Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(3000);
        mLocationRequest.setFastestInterval(1500);


        if (ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            // Gets the best and most recent location currently available, which may be null
            // in rare cases when a location is not available.
            LocationAvailability locationAvailability = LocationServices.FusedLocationApi.getLocationAvailability(mGoogleApiClient);
            if (locationAvailability.isLocationAvailable()) {
                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
            } else {
                Marker seoul = googleMap.addMarker(new MarkerOptions().position(SEOUL).title("Seoul"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 15));
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

                Toast.makeText(this, "Location Unavialable", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onConnectionSuspended(int cause) {
        // The connection to Google Play services was lost for some reason. We call connect() to
        // attempt to re-establish the connection.
        Log.i(mapTAG, "Connection suspended");
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // Refer to the javadoc for ConnectionResult to see what error codes might be returned in
        // onConnectionFailed.
        Log.i(mapTAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        LatLng CURRENT_LOCATION = new LatLng(location.getLatitude(), location.getLongitude());
        LOCATION = new LatLng(item.getMapx(), item.getMapy());
        googleMap.clear();
        Marker loca = googleMap.addMarker(new MarkerOptions().position(CURRENT_LOCATION).title("Here"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CURRENT_LOCATION, 15));
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;

        Marker seoul = googleMap.addMarker(new MarkerOptions().position(SEOUL).title("Seoul"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 15));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    }
    /**************************************************************************************************************/
}
