package kr.co.trappan.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

import kr.co.trappan.Adapter.FollowerListAdapter;
import kr.co.trappan.Adapter.FollowingListAdapter;
import kr.co.trappan.Bean.Member;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-11-18.
 */

public class FollowerActivity extends AppCompatActivity {

    Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower_page);

        ArrayList<Member> items = new ArrayList<>();

        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.follower_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Adapter = new FollowerListAdapter(this, items, R.layout.activity_follower_page);
        recyclerView.setAdapter(Adapter);

        items.add(new Member("id", "email", "password", "name", "back_img", " ", "intro"));
        items.add(new Member("id", "email", "password", "name", "back_img", " ", "intro"));
        items.add(new Member("id", "email", "password", "name", "back_img", " ", "intro"));

        //뒤로가기 버튼
        ImageButton review_backbutton = (ImageButton)findViewById(R.id.follower_backbutton);
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