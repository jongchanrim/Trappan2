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
import android.widget.RelativeLayout;


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

    private ViewPager horizontal_viewpager;
    private RelativeLayout item1,item2,item3;

    ArrayList<String> list=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment1, container, false);

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

        item1=(RelativeLayout)view.findViewById(R.id.item1);
        item2=(RelativeLayout)view.findViewById(R.id.item2);
        item3=(RelativeLayout)view.findViewById(R.id.item3);

        item1.setBackgroundResource(R.drawable.a);
        item2.setBackgroundResource(R.drawable.a);
        item3.setBackgroundResource(R.drawable.a);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),DetailInformationActivity.class);
                intent.putExtra("contentid","23");
                startActivity(intent);
            }
        });
        item2.setOnClickListener(new View.OnClickListener() {
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


