package kr.co.trappan.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.trappan.Activity.SearchActivity;
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

    public static View view_detail;
    public static View view_seoul;
    public static View view_gyeonggi;
    public static View view_pusan;
    public static View view_incheon;
    public static View view_daegu;

    public static TextView region_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment2, container, false);

        context = getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.horizontalView);
        recyclerView.setHasFixedSize(true);

        ArrayList<Horizontal_item> items = new ArrayList<>();

        items.add(new Horizontal_item(R.drawable.gangwon,"서울"));
        items.add(new Horizontal_item(R.drawable.gangwon,"경기"));
        items.add(new Horizontal_item(R.drawable.gangwon,"부산"));
        items.add(new Horizontal_item(R.drawable.gangwon,"대구"));
        items.add(new Horizontal_item(R.drawable.gangwon,"인천"));
        items.add(new Horizontal_item(R.drawable.gangwon,"강원"));
        items.add(new Horizontal_item(R.drawable.gangwon,"제주"));
        items.add(new Horizontal_item(R.drawable.gangwon,"세종"));
        items.add(new Horizontal_item(R.drawable.gangwon,"울산"));
        items.add(new Horizontal_item(R.drawable.gangwon,"대전"));
        items.add(new Horizontal_item(R.drawable.gangwon,"광주"));
        items.add(new Horizontal_item(R.drawable.gangwon,"경남"));
        items.add(new Horizontal_item(R.drawable.gangwon,"경북"));
        items.add(new Horizontal_item(R.drawable.gangwon,"충남"));
        items.add(new Horizontal_item(R.drawable.gangwon,"충북"));
        items.add(new Horizontal_item(R.drawable.gangwon,"전남"));
        items.add(new Horizontal_item(R.drawable.gangwon,"전북"));

        layoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new HorizontalListAdapter(getActivity() ,items ,R.layout.tabfragment2);
        recyclerView.setAdapter(Adapter);
/*
        recyclerView_theme = (RecyclerView) view.findViewById(R.id.horizontalView_theme);
//        recyclerView_theme.setHasFixedSize(true);

        ArrayList<HorizontalTheme_item> items_Theme = new ArrayList<>();

        items_Theme.add(new HorizontalTheme_item(R.drawable.gangwon,"자연"));
        items_Theme.add(new HorizontalTheme_item(R.drawable.gangwon,"역사"));
        items_Theme.add(new HorizontalTheme_item(R.drawable.gangwon,"체험"));
        items_Theme.add(new HorizontalTheme_item(R.drawable.gangwon,"휴양"));
        items_Theme.add(new HorizontalTheme_item(R.drawable.gangwon,"산업"));
        items_Theme.add(new HorizontalTheme_item(R.drawable.gangwon,"건축/조형물"));
        items_Theme.add(new HorizontalTheme_item(R.drawable.gangwon,"문화시설"));
        items_Theme.add(new HorizontalTheme_item(R.drawable.gangwon,"축제"));

        layoutManager_theme = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView_theme.setLayoutManager(layoutManager_theme);
        Adapter_theme = new HorizontalThemeListAdapter(getActivity() ,items_Theme ,R.layout.tabfragment2);
        recyclerView_theme.setAdapter(Adapter_theme);
*/
        view_detail = view.findViewById(R.id.region_detail);
        view_seoul = view.findViewById(R.id.region_detail_seoul);
        view_gyeonggi = view.findViewById(R.id.region_detail_gyeonggi);
        view_pusan = view.findViewById(R.id.region_detail_pusan);
        view_daegu = view.findViewById(R.id.region_detail_daegu);
        view_incheon = view.findViewById(R.id.region_detail_incheon);

        region_name = (TextView) view.findViewById(R.id.region_name);

        view.findViewById(R.id.button1).setOnClickListener(mClickListener);
        view.findViewById(R.id.button2).setOnClickListener(mClickListener);
        view.findViewById(R.id.button3).setOnClickListener(mClickListener);
        view.findViewById(R.id.button4).setOnClickListener(mClickListener);
        view.findViewById(R.id.button5).setOnClickListener(mClickListener);
        view.findViewById(R.id.button6).setOnClickListener(mClickListener);
        view.findViewById(R.id.button7).setOnClickListener(mClickListener);
        view.findViewById(R.id.button8).setOnClickListener(mClickListener);
        view.findViewById(R.id.button9).setOnClickListener(mClickListener);
        view.findViewById(R.id.button10).setOnClickListener(mClickListener);
        view.findViewById(R.id.button11).setOnClickListener(mClickListener);
        view.findViewById(R.id.button12).setOnClickListener(mClickListener);
        view.findViewById(R.id.button13).setOnClickListener(mClickListener);
        view.findViewById(R.id.button14).setOnClickListener(mClickListener);
        view.findViewById(R.id.button15).setOnClickListener(mClickListener);
        view.findViewById(R.id.button16).setOnClickListener(mClickListener);
        view.findViewById(R.id.button17).setOnClickListener(mClickListener);
        view.findViewById(R.id.button18).setOnClickListener(mClickListener);
        view.findViewById(R.id.button19).setOnClickListener(mClickListener);
        view.findViewById(R.id.button20).setOnClickListener(mClickListener);
        view.findViewById(R.id.button21).setOnClickListener(mClickListener);
        view.findViewById(R.id.button22).setOnClickListener(mClickListener);
        view.findViewById(R.id.button23).setOnClickListener(mClickListener);
        view.findViewById(R.id.button24).setOnClickListener(mClickListener);
        view.findViewById(R.id.button25).setOnClickListener(mClickListener);
        view.findViewById(R.id.button26).setOnClickListener(mClickListener);
        view.findViewById(R.id.button27).setOnClickListener(mClickListener);
        view.findViewById(R.id.button28).setOnClickListener(mClickListener);
        view.findViewById(R.id.button29).setOnClickListener(mClickListener);
        view.findViewById(R.id.button30).setOnClickListener(mClickListener);
        view.findViewById(R.id.button31).setOnClickListener(mClickListener);
        view.findViewById(R.id.button32).setOnClickListener(mClickListener);
        view.findViewById(R.id.button33).setOnClickListener(mClickListener);
        view.findViewById(R.id.button34).setOnClickListener(mClickListener);
        view.findViewById(R.id.button35).setOnClickListener(mClickListener);
        view.findViewById(R.id.button36).setOnClickListener(mClickListener);
        view.findViewById(R.id.button37).setOnClickListener(mClickListener);
        view.findViewById(R.id.button38).setOnClickListener(mClickListener);
        view.findViewById(R.id.button39).setOnClickListener(mClickListener);
        view.findViewById(R.id.button40).setOnClickListener(mClickListener);
        view.findViewById(R.id.button41).setOnClickListener(mClickListener);
        view.findViewById(R.id.button42).setOnClickListener(mClickListener);
        view.findViewById(R.id.button43).setOnClickListener(mClickListener);
        view.findViewById(R.id.button44).setOnClickListener(mClickListener);
        view.findViewById(R.id.button45).setOnClickListener(mClickListener);
        view.findViewById(R.id.button46).setOnClickListener(mClickListener);
        view.findViewById(R.id.button47).setOnClickListener(mClickListener);
        view.findViewById(R.id.button48).setOnClickListener(mClickListener);
        view.findViewById(R.id.button49).setOnClickListener(mClickListener);
        view.findViewById(R.id.button50).setOnClickListener(mClickListener);
        view.findViewById(R.id.button51).setOnClickListener(mClickListener);
        view.findViewById(R.id.button52).setOnClickListener(mClickListener);
        view.findViewById(R.id.button53).setOnClickListener(mClickListener);
        view.findViewById(R.id.button54).setOnClickListener(mClickListener);
        view.findViewById(R.id.button55).setOnClickListener(mClickListener);
        view.findViewById(R.id.button56).setOnClickListener(mClickListener);
        view.findViewById(R.id.button57).setOnClickListener(mClickListener);
        view.findViewById(R.id.button58).setOnClickListener(mClickListener);
        view.findViewById(R.id.button59).setOnClickListener(mClickListener);
        view.findViewById(R.id.button60).setOnClickListener(mClickListener);
        view.findViewById(R.id.button61).setOnClickListener(mClickListener);
        view.findViewById(R.id.button62).setOnClickListener(mClickListener);
        view.findViewById(R.id.button63).setOnClickListener(mClickListener);
       // view.findViewById(R.id.button64).setOnClickListener(mClickListener);
       // view.findViewById(R.id.button65).setOnClickListener(mClickListener);


        return view;
    }

    // 버튼 클릭 리스너
    public Button.OnClickListener mClickListener = new View.OnClickListener(){
        public void onClick(View v){

            Button b = (Button) v;
          //  b.setBackgroundColor();
            Intent intent = new Intent(v.getContext(), SearchActivity.class);
            intent.putExtra("region_name",region_name.getText());
            intent.putExtra("region_detail", b.getText());
            Toast.makeText(context,b.getText(), Toast.LENGTH_SHORT).show();
            v.getContext().startActivity(intent);

        }
    };
}