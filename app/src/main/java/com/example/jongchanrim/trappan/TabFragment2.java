package com.example.jongchanrim.trappan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;




/**
 * Created by thfad_000 on 2016-10-04.
 */
public class TabFragment2 extends Fragment{
/*
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment2, container, false);

       // ImageView back_img = (ImageView)getActivity().findViewById(R.id.backView);
      //  back_img.setImageDrawable(R.drawable.f);

      //  ImageView profile_img = (ImageView)getActivity().findViewById(R.id.profileView);
     //   profile_img.setImageDrawable(R.drawable.g);

    //    TextView name_text = (TextView)getActivity().findViewById(R.id.nameText);
    //    name_text.setText("전효주");

     //   TextView profile_text = (TextView)getActivity().findViewById(R.id.profileText);
     //   profile_text.setText("자기 소개글을 남겨주세요.");

        // 카드뷰 출력 부분
/*
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_profile);
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

        recyclerView.setAdapter(new RecyclerAdapter(getActivity(), items, R.layout.tabfragment2));
*/
        return view;
    }
}