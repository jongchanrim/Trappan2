package kr.co.trappan.Fragment;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
public class TabFragment5 extends Fragment{

    Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView resizeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment5, container, false);

        resizeList = (RecyclerView) view.findViewById(R.id.mypage_scroll);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//                new AlertDialog.Builder(this)
//                        .setTitle("사진 업로드")
//                        .setMessage("사진을 업로드해라\n\nTEXT")
//                        .setNeutralButton("닫기",new Dialog)
            }
        });


        context = getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.mypage_scroll);
        recyclerView.setHasFixedSize(true);

        ArrayList<List_item> items = new ArrayList<>();

        items.add(new List_item(R.drawable.gangwon,"후기","1","테스트1"));
        items.add(new List_item(R.drawable.gangwon,"후기","2","테스트2"));
        items.add(new List_item(R.drawable.gangwon,"후기","3","테스트3"));
        items.add(new List_item(R.drawable.gangwon,"후기","4","테스트4"));
        items.add(new List_item(R.drawable.gangwon,"후기","5","테스트5"));
        items.add(new List_item(R.drawable.gangwon,"후기","6","테스트6"));
        items.add(new List_item(R.drawable.gangwon,"후기","7","테스트7"));
        items.add(new List_item(R.drawable.gangwon,"후기","8","테스트8"));
        items.add(new List_item(R.drawable.gangwon,"후기","9","테스트9"));
        items.add(new List_item(R.drawable.gangwon,"후기","10","테스트10"));

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new ListViewAdapter(getActivity() ,items ,R.layout.tabfragment5);
        recyclerView.setAdapter(Adapter);

        resizeCommentList(items.size());

        return view;
    }

    private void resizeCommentList(int item_size){
        ViewGroup.LayoutParams params = resizeList.getLayoutParams();
        params.height = 350 * item_size;
        resizeList.setLayoutParams(params);
    }

}
