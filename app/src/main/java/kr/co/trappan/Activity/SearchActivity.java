package kr.co.trappan.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.trappan.Adapter.ListViewAdapter;
import kr.co.trappan.Adapter.SearchListAdapter;
import kr.co.trappan.Item.List_item;
import kr.co.trappan.Item.SearchList_item;
import kr.co.trappan.R;

import static java.security.AccessController.getContext;

/**
 * Created by thfad_000 on 2016-11-11.
 */

public class SearchActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.search_list);
        recyclerView.setHasFixedSize(true);

        ArrayList<SearchList_item> items = new ArrayList<>();

        items.add(new SearchList_item("지역","이름","별점","좋아요","도장"));
        items.add(new SearchList_item("지역","이름","별점","좋아요.","도장"));
        items.add(new SearchList_item("지역","이름","별점","좋아요.","도장"));
        items.add(new SearchList_item("지역","이름","별점","좋아요.","도장"));
        items.add(new SearchList_item("지역","이름","별점","좋아요.","도장"));


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SearchListAdapter(this,items ,R.layout.search);
        recyclerView.setAdapter(adapter);


        //인텐트 값 가져오기
        Intent intent = getIntent();
        String regionName = intent.getStringExtra("title");

        TextView region = (TextView)findViewById(R.id.search_name);
        region.setText(regionName);


    }
}
