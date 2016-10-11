package kr.co.trappan.Fragment;

/**
 * Created by thfad_000 on 2016-10-04.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import kr.co.trappan.Adapter.RecyclerAdapter;
import kr.co.trappan.Item.Recycler_item;
import kr.co.trappan.R;

import java.util.ArrayList;
import java.util.List;


public class TabFragment1 extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tabfragment1, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        //ImageView img = (ImageView)getActivity().findViewById(R.id.image);


        // 카드 리스트
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

        return view;
    }

}
