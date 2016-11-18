package kr.co.trappan.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import kr.co.trappan.Adapter.FollowingListAdapter;
import kr.co.trappan.Adapter.ListViewAdapter;
import kr.co.trappan.Adapter.SearchListAdapter;
import kr.co.trappan.Bean.Member;
import kr.co.trappan.Item.List_item;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-11-17.
 */

public class FollowingActivity extends AppCompatActivity {

    Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following_page);

        ArrayList<Member> items = new ArrayList<>();

        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.follwing_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Adapter = new FollowingListAdapter(this, items, R.layout.activity_following_page);
        recyclerView.setAdapter(Adapter);

        items.add(new Member("id","email","password","name","back_img"," ","intro"));

    }
}
