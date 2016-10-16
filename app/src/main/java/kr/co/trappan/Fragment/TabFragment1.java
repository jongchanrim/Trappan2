package kr.co.trappan.Fragment;

/**
 * Created by thfad_000 on 2016-10-04.
 */
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;


import kr.co.trappan.Adapter.RecyclerAdapter;
import kr.co.trappan.Item.Recycler_item;
import kr.co.trappan.R;

import java.util.ArrayList;
import java.util.List;
import com.loopj.android.http.*;

import org.json.JSONArray;


public class TabFragment1 extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    private SwipeRefreshLayout swipeList;

    private static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tabfragment1, container, false);

        // recyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        // Recycler item 리스트 생성
        List<Recycler_item> items = new ArrayList<>();
        Recycler_item[] item = new Recycler_item[5];
        //            Recycler_item(image, string);
        item[0] = new Recycler_item(R.drawable.a, "이곳은 어떤 곳인가");
        item[1] = new Recycler_item(R.drawable.b, "#2");
        item[2] = new Recycler_item(R.drawable.c, "#3");
        item[3] = new Recycler_item(R.drawable.d, "#4");
        item[4] = new Recycler_item(R.drawable.e, "#5");

        for (int i = 0; i < 5; i++) items.add(item[i]);

        recyclerView.setAdapter(new RecyclerAdapter(getActivity(), items, R.layout.tabfragment1));

        //refresh list
        swipeList = (SwipeRefreshLayout) view.findViewById(R.id.refreshView);
        swipeList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // 새로고침 하는 section

                //fetchListAsync(0);
                swipeList.setRefreshing(false);
            }
        });

        // Configure the refreshing colors
        swipeList.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        return view;
    }


    // Refresh Listener에서 업데이트 된 데이터 받아오는 부분
/*
 public void fetchListAsync(int page) {

        // Send the network request to fetch the updated data
        // `client` here is an instance of Android Async HTTP

        client.getHomeTimeline(0, new JsonHttpResponseHandler() {
            public void onSuccess(JSONArray json) {

                // Remember to CLEAR OUT old items before appending in the new ones

                recyclerAdapter.clear();

                // ...the data has come back, add new items to your adapter...

                recyclerAdapter.addAll(...);

                // Now we call setRefreshing(false) to signal refresh has finished

                swipeList.setRefreshing(false);
            }

            public void onFailure(Throwable e) {
                Log.d("DEBUG", "Fetch timeline error: " + e.toString());
            }
        });
    }

    */




}
