package kr.co.trappan.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

import kr.co.trappan.Adapter.HorizontalListAdapter;

import kr.co.trappan.Item.Horizontal_item;
import kr.co.trappan.R;



/**
 * Created by thfad_000 on 2016-10-04.
 */
public class TabFragment2 extends Fragment{

    Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment2, container, false);

        context = getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.horizontalView);
        recyclerView.setHasFixedSize(true);


        ArrayList<Horizontal_item> items = new ArrayList<>();

        items.add(new Horizontal_item(R.drawable.gangwon,"강원"));
        items.add(new Horizontal_item(R.drawable.gangwon,"경기"));
        items.add(new Horizontal_item(R.drawable.gangwon,"경상"));
        items.add(new Horizontal_item(R.drawable.gangwon,"전라"));
        items.add(new Horizontal_item(R.drawable.gangwon,"충청"));

        layoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new HorizontalListAdapter(getActivity() ,items ,R.layout.tabfragment2);
        recyclerView.setAdapter(Adapter);

        return view;
    }
}