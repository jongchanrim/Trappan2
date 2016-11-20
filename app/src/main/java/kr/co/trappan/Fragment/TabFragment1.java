package kr.co.trappan.Fragment;

/**
 * Created by thfad_000 on 2016-10-04.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Activity.DetailInformationActivity;
import kr.co.trappan.Activity.MainActivity;
import kr.co.trappan.Activity.ReviewPageActivity;
import kr.co.trappan.Adapter.Horizontal_Pager_Adapter;
import kr.co.trappan.Bean.Tour;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.R;


public class TabFragment1 extends Fragment {

    private ImageView week_review_img;
    private TextView week_review_areaname;
    private TextView week_review_main_title;
    private TextView week_review_title;

    private ImageView week_tour_img;
    private TextView week_tour_areaname;
    private TextView week_tour_main_title;

    private ImageView month_review_img;
    private TextView month_review_areaname;
    private TextView month_review_main_title;
    private TextView month_review_title;

    private ImageView month_tour_img;
    private TextView month_tour_areaname;
    private TextView month_tour_main_title;

    private ViewPager horizontal_viewpager;
    private ImageView ball[]=new ImageView[5];
    ArrayList<String> list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment1, container, false);

        week_review_img=(ImageView)view.findViewById(R.id.week_review_img) ;
        week_review_areaname=(TextView) view.findViewById(R.id.week_review_areaname);
        week_review_main_title=(TextView) view.findViewById(R.id.week_review_main_title);
        week_review_title=(TextView) view.findViewById(R.id.week_review_title);

        week_tour_img=(ImageView)view.findViewById(R.id.week_tour_img);
        week_tour_areaname=(TextView) view.findViewById(R.id.week_tour_areaname);
        week_tour_main_title=(TextView) view.findViewById(R.id.week_tour_main_title);

        month_review_img=(ImageView)view.findViewById(R.id.month_review_img);
        month_review_areaname=(TextView) view.findViewById(R.id.month_review_areaname);
        month_review_main_title=(TextView) view.findViewById(R.id.month_review_main_title);
        month_review_title=(TextView) view.findViewById(R.id.month_review_title);

        month_tour_img=(ImageView)view.findViewById(R.id.month_tour_img);
        month_tour_areaname=(TextView) view.findViewById(R.id.month_tour_areaname);
        month_tour_main_title=(TextView) view.findViewById(R.id.month_tour_main_title);

        ball[0]=(ImageView) view.findViewById(R.id.ball_1);
        ball[1]=(ImageView) view.findViewById(R.id.ball_2);
        ball[2]=(ImageView) view.findViewById(R.id.ball_3);
        ball[3]=(ImageView) view.findViewById(R.id.ball_4);
        ball[4]=(ImageView) view.findViewById(R.id.ball_5);

        HttpClient.get("test", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    //list.add(response.getString());----리스트 초기화 //이미지넣어줄때 "\\"해주어야함 ㅇㅇㅇ
                }catch (Exception e){

                }

            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });
        horizontal_viewpager=(ViewPager)view.findViewById(R.id.horizontal_viewpager);
        Horizontal_Pager_Adapter adapter=new Horizontal_Pager_Adapter(getLayoutInflater(savedInstanceState),list);
        horizontal_viewpager.setAdapter(adapter);

        horizontal_viewpager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            public void onPageSelected(int position) {
                Log.i("po" ,"page selected " + position);
                for(int i=0;i<5;i++){
                    if(position==i)
                        ball[i].setBackgroundResource(R.drawable.pager_02);
                    else
                        ball[i].setBackgroundResource(R.drawable.pager_01);
                }
            }
        });

        week_review_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),DetailInformationActivity.class);
                intent.putExtra("contentid","23");
                startActivity(intent);
            }
        });
        week_tour_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),ReviewPageActivity.class);
                intent.putExtra("review_id","23");
                startActivity(intent);
            }
        });

        return view;
    }


}


