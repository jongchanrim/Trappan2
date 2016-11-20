package kr.co.trappan.Fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.co.trappan.Adapter.ListViewAdapter;
import kr.co.trappan.Item.List_item;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-10-04.
 */
public class TabFragment4 extends Fragment{

    Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment4, container, false);

        context = getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.notice_list);
        recyclerView.setHasFixedSize(true);

        ArrayList<List_item> items = new ArrayList<>();

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new ListViewAdapter(getActivity() ,items ,R.layout.tabfragment4);
        recyclerView.setAdapter(Adapter);

        return view;

    }
}