package kr.co.trappan.Fragment;

/**
 * Created by thfad_000 on 2016-10-04.
 */
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import kr.co.trappan.Activity.MainActivity;
import kr.co.trappan.Adapter.Horizontal_Pager_Adapter;
import kr.co.trappan.Adapter.RecyclerAdapter;
import kr.co.trappan.Item.Recycler_item;
import kr.co.trappan.R;

import java.util.ArrayList;
import java.util.List;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.loopj.android.http.*;

import org.json.JSONArray;


public class TabFragment1 extends Fragment {


   private ViewPager horizontal_viewpager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment1, container, false);

        horizontal_viewpager=(ViewPager)view.findViewById(R.id.horizontal_viewpager);
        Horizontal_Pager_Adapter adapter=new Horizontal_Pager_Adapter(getLayoutInflater(savedInstanceState));
        horizontal_viewpager.setAdapter(adapter);

        return view;
    }
}


