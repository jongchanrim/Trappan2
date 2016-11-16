package kr.co.trappan.Fragment;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.trappan.Activity.SearchActivity;
import kr.co.trappan.Adapter.HorizontalListAdapter;


import kr.co.trappan.Item.Horizontal_item;
import kr.co.trappan.Item.RecyclerViewOnItemClickListener;
import kr.co.trappan.R;


/**
 * Created by thfad_000 on 2016-10-04.
 */
public class TabFragment2 extends Fragment {

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
    public static View view_daejeon;
    public static View view_gwangju;
    public static View view_ulsan;

    public static TextView region_name;
    public static TextView region_code;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment2, container, false);

        context = getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.horizontalView);
        recyclerView.setHasFixedSize(true);

        ArrayList<Horizontal_item> items = new ArrayList<>();

        items.add(new Horizontal_item(R.drawable.seoul_1, "서울", "1"));
        items.add(new Horizontal_item(R.drawable.incheon_2, "인천", "2"));
        items.add(new Horizontal_item(R.drawable.daejeon_3, "대전", "3"));
        items.add(new Horizontal_item(R.drawable.daegu_4, "대구", "4"));
        items.add(new Horizontal_item(R.drawable.gwangju_5, "광주", "5"));
        items.add(new Horizontal_item(R.drawable.pusan_6, "부산", "6"));
        items.add(new Horizontal_item(R.drawable.ulsan_7, "울산", "7"));
        items.add(new Horizontal_item(R.drawable.sejong_8, "세종", "8"));
        items.add(new Horizontal_item(R.drawable.gyeonggi_31, "경기", "31"));
        items.add(new Horizontal_item(R.drawable.gangwon_32, "강원", "32"));
        items.add(new Horizontal_item(R.drawable.chungbuk_33, "충북", "33"));
        items.add(new Horizontal_item(R.drawable.chungnam_34, "충남", "34"));
        items.add(new Horizontal_item(R.drawable.gyeongbuk_35, "경북", "35"));
        items.add(new Horizontal_item(R.drawable.gyeongnam_36, "경남", "36"));
        items.add(new Horizontal_item(R.drawable.jeonbuk_37, "전북", "37"));
        items.add(new Horizontal_item(R.drawable.jeonnam_38, "전남", "38"));
        items.add(new Horizontal_item(R.drawable.jeju_39, "제주", "39"));


        layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new HorizontalListAdapter(getActivity(), items, R.layout.tabfragment2);
        recyclerView.setAdapter(Adapter);

        recyclerView.addOnItemTouchListener(new RecyclerViewOnItemClickListener(getActivity(), recyclerView,
                new RecyclerViewOnItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        if(view_detail.getVisibility() == View.VISIBLE){
                            if(view_seoul.getVisibility() == View.VISIBLE) {
                                ImageView t = (ImageView) recyclerView.getChildAt(0).findViewById(R.id.search_imageVIew);
                                t.setImageResource(R.drawable.seoul_1);
                                view_seoul.setVisibility(View.GONE);
                            }
                            if(view_gyeonggi.getVisibility() == View.VISIBLE) {
                                ImageView t = (ImageView) recyclerView.getChildAt(0).findViewById(R.id.search_imageVIew);
                                t.setImageResource(R.drawable.gyeonggi_31);
                                view_gyeonggi.setVisibility(View.GONE);
                            }
                            if(view_pusan.getVisibility() == View.VISIBLE) {
                                ImageView t = (ImageView) recyclerView.getChildAt(0).findViewById(R.id.search_imageVIew);
                                t.setImageResource(R.drawable.pusan_6);
                                view_pusan.setVisibility(View.GONE);
                            }
                            if(view_daegu.getVisibility() == View.VISIBLE) {
                                ImageView t = (ImageView) recyclerView.getChildAt(0).findViewById(R.id.search_imageVIew);
                                t.setImageResource(R.drawable.daegu_4);
                                view_daegu.setVisibility(View.GONE);
                            }
                            if(view_incheon.getVisibility() == View.VISIBLE) {
                                ImageView t = (ImageView) recyclerView.getChildAt(0).findViewById(R.id.search_imageVIew);
                                t.setImageResource(R.drawable.incheon_2);
                                view_incheon.setVisibility(View.GONE);
                            }

                        }

                        ImageView iv = (ImageView) v.findViewById(R.id.search_imageVIew);
                        if (position == 0) {

                            view_detail.setVisibility(View.VISIBLE);
                            view_seoul.setVisibility(View.VISIBLE);
                            iv.setImageResource(R.drawable.seoul_1_c);



                        } else if (position == 1) {

                            view_detail.setVisibility(View.VISIBLE);
                            view_gyeonggi.setVisibility(View.VISIBLE);
                            iv.setImageResource(R.drawable.gyeonggi_31_c);
                        } else if (position == 2) {

                            view_detail.setVisibility(View.VISIBLE);
                            view_pusan.setVisibility(View.VISIBLE);
                            iv.setImageResource(R.drawable.pusan_6_c);
                        } else if (position == 3) {

                            view_detail.setVisibility(View.VISIBLE);
                            view_daegu.setVisibility(View.VISIBLE);
                            iv.setImageResource(R.drawable.daegu_4_c);

                        } else if (position == 4) {

                            view_detail.setVisibility(View.VISIBLE);
                            view_incheon.setVisibility(View.VISIBLE);
                            iv.setImageResource(R.drawable.incheon_2_c);
                        }

                    }

                    @Override
                    public void onItemLongClick(View v, int position) {
                    }
                }
        ));

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
        view_incheon = view.findViewById(R.id.region_detail_incheon);
        view_daejeon = view.findViewById(R.id.region_detail_daegeon);
        view_daegu = view.findViewById(R.id.region_detail_daegu);
        view_gwangju = view.findViewById(R.id.region_detail_gwangju);
        view_pusan = view.findViewById(R.id.region_detail_pusan);
        view_gyeonggi = view.findViewById(R.id.region_detail_gyeonggi);
        view_ulsan = view.findViewById(R.id.region_detail_ulsan);

        region_name = (TextView) view.findViewById(R.id.region_name);
        region_code = (TextView) view.findViewById(R.id.region_code);


        // 버튼 리스너

        // 서울
        view.findViewById(R.id.tag_01).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_01).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_02).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_03).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_04).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_05).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_06).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_07).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_08).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_09).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_10).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_11).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_12).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_13).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_14).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_15).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_16).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_17).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_18).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_19).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_20).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_21).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_22).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_23).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_24).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_01_25).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button27).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button28).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button29).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button30).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button31).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button32).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button33).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button34).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button35).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button36).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button37).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button38).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button39).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button40).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button41).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button42).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button43).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button44).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button45).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button46).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button47).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button48).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button49).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button50).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button51).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button52).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button53).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button54).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button55).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button56).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button57).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button58).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button59).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button60).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button61).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button62).setOnClickListener(mClickListener);
//        view.findViewById(R.id.button63).setOnClickListener(mClickListener);
        // view.findViewById(R.id.button64).setOnClickListener(mClickListener);
        // view.findViewById(R.id.button65).setOnClickListener(mClickListener);

        return view;
    }

    // 버튼 클릭 리스너
    public Button.OnClickListener mClickListener = new View.OnClickListener() {

        public void onClick(View v) {

            Button b = (Button) v;
            //  b.setBackgroundColor();
            Intent intent = new Intent(v.getContext(), SearchActivity.class);
            intent.putExtra("areacode", region_name.getText());
            intent.putExtra("sigungucode", b.getText());
            Toast.makeText(context, b.getText(), Toast.LENGTH_SHORT).show();
            v.getContext().startActivity(intent);

        }
    };
}