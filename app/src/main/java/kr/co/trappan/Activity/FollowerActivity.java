package kr.co.trappan.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Adapter.FollowerListAdapter;
import kr.co.trappan.Adapter.FollowingListAdapter;
import kr.co.trappan.Bean.Member;
import kr.co.trappan.Bean.Review;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.Item.CustomProgressDialog;
import kr.co.trappan.Item.RecyclerViewOnItemClickListener;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-11-18.
 */

public class FollowerActivity extends AppCompatActivity {

    Context context;
    private RecyclerView recyclerView;
    private FollowerListAdapter Adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Member> items = new ArrayList<>();
    private CustomProgressDialog pd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower_page);
        pd = new CustomProgressDialog(FollowerActivity.this);
        pd .getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        pd.show();

        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.follower_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Adapter = new FollowerListAdapter(this, items, R.layout.activity_follower_page);
        recyclerView.setAdapter(Adapter);

        HttpClient.get("followerlist", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                try {

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = response.getJSONObject(i);
                        Member item = new Member();
                        item.setId(obj.getString("id"));
                        item.setPro_img(obj.getString("pro_img"));
                        item.setIntro(obj.getString("intro"));
                        item.setIsfollow(obj.getString("isfollow"));
                        items.add(item);
                    }
                    Adapter.setItems(items);
                    Adapter.notifyDataSetChanged();
                    pd.dismiss();

                    //pd.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
                    super.onFailure(statusCode, headers, throwable, response);
                    pd.dismiss();

                }
            });

        recyclerView.addOnItemTouchListener(new

                RecyclerViewOnItemClickListener(FollowerActivity.this, recyclerView,
                new RecyclerViewOnItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {

                        Intent intent = new Intent(FollowerActivity.this, MemberPageActivity.class);
                        intent.putExtra("user_id", items.get(position).getId());
                        startActivity(intent); // 다음 화면으로 넘어간다.
                    }

                    @Override
                    public void onItemLongClick(View v, int position) {

                    }
                }

        ));


        //뒤로가기 버튼
        ImageView review_backbutton = (ImageView)findViewById(R.id.follower_backbutton);
        review_backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

     /*   Button follow_button = (Button) findViewById(R.id.follower_button);

        follow_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //   Button b = (Button) v;
                //    v.setBackgroundResource(R.drawable.following);

            }

        });*/

    }

}