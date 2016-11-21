package kr.co.trappan.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.trappan.Activity.DetailInformationActivity;
import kr.co.trappan.Activity.SearchActivity;


import kr.co.trappan.Adapter.SearchFragmentAdapter;
import kr.co.trappan.Item.RecyclerViewOnItemClickListener;
import kr.co.trappan.Item.SearchFragmentItem;
import kr.co.trappan.R;


/**
 * Created by thfad_000 on 2016-10-04.
 */
public class TabFragment2 extends Fragment {

    EditText f2_keyword;
     ImageView f2_btn_keyword;

    Context context;
    RecyclerView recyclerViewArea;
    RecyclerView recyclerViewType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tabfragment2, container, false);

        f2_btn_keyword = (ImageView) view.findViewById(R.id.f2_btn_keyword);
        f2_keyword = (EditText) view.findViewById(R.id.f2_keyword);

        f2_btn_keyword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                intent.putExtra("case", "keyword");
                intent.putExtra("keyword", f2_keyword.getText().toString());
                v.getContext().startActivity(intent);

            }
        });


        final View view_detail = view.findViewById(R.id.region_detail);
        final View view_seoul = view.findViewById(R.id.region_detail_seoul);
        final View view_incheon = view.findViewById(R.id.region_detail_incheon);
        final View view_daejeon = view.findViewById(R.id.region_detail_daegeon);
        final View view_daegu = view.findViewById(R.id.region_detail_daegu);
        final View view_gwangju = view.findViewById(R.id.region_detail_gwangju);
        final View view_pusan = view.findViewById(R.id.region_detail_pusan);
        final View view_ulsan = view.findViewById(R.id.region_detail_ulsan);
        final View view_sejong = view.findViewById(R.id.region_detail_sejong);
        final View view_gyeonggi = view.findViewById(R.id.region_detail_gyeonggi);
        final View view_gangwon = view.findViewById(R.id.region_detail_gangwon);
        final View view_chungbuk = view.findViewById(R.id.region_detail_chungbook);
        final View view_chungnam = view.findViewById(R.id.region_detail_chungnam);
        final View view_gyeongbuk = view.findViewById(R.id.region_detail_gyeongbook);
        final View view_gyeongnam = view.findViewById(R.id.region_detail_gyeongnam);
        final View view_jeonbuk = view.findViewById(R.id.region_detail_junbook);
        final View view_jeonnam = view.findViewById(R.id.region_detail_junnam);
        final View view_jeju = view.findViewById(R.id.region_detail_jeju);

        context = getContext();
        recyclerViewArea = (RecyclerView) view.findViewById(R.id.search_area);
        recyclerViewArea.setHasFixedSize(true);

        ArrayList<SearchFragmentItem> items = new ArrayList<>();

        items.add(new SearchFragmentItem(R.drawable.seoul_1_c));
        items.add(new SearchFragmentItem(R.drawable.incheon_2_c));
        items.add(new SearchFragmentItem(R.drawable.daejeon_3_c));
        items.add(new SearchFragmentItem(R.drawable.daegu_4_c));
        items.add(new SearchFragmentItem(R.drawable.gwangju_5_c));
        items.add(new SearchFragmentItem(R.drawable.pusan_6_c));
        items.add(new SearchFragmentItem(R.drawable.ulsan_7_c));
        items.add(new SearchFragmentItem(R.drawable.sejong_8_c));
        items.add(new SearchFragmentItem(R.drawable.gyeonggi_31_c));
        items.add(new SearchFragmentItem(R.drawable.gangwon_32_c));
        items.add(new SearchFragmentItem(R.drawable.chungbuk_33_c));
        items.add(new SearchFragmentItem(R.drawable.chungnam_34_c));
        items.add(new SearchFragmentItem(R.drawable.gyeongbuk_35_c));
        items.add(new SearchFragmentItem(R.drawable.gyeongnam_36_c));
        items.add(new SearchFragmentItem(R.drawable.jeonbuk_37_c));
        items.add(new SearchFragmentItem(R.drawable.jeonnam_38_c));
        items.add(new SearchFragmentItem(R.drawable.jeju_39_c));

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerViewArea.setLayoutManager(layoutManager);

        SearchFragmentAdapter Adapter = new SearchFragmentAdapter(items);
        recyclerViewArea.setAdapter(Adapter);

        recyclerViewType = (RecyclerView) view.findViewById(R.id.search_theme);
        recyclerViewType.setHasFixedSize(true);

        StaggeredGridLayoutManager layoutManager2 = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerViewType.setLayoutManager(layoutManager2);
        ArrayList<SearchFragmentItem> items2 = new ArrayList<>();

        items2.add(new SearchFragmentItem(R.drawable.theme_a0101_s));
        items2.add(new SearchFragmentItem(R.drawable.theme_a0201_s));
        items2.add(new SearchFragmentItem(R.drawable.theme_a0202_s));
        items2.add(new SearchFragmentItem(R.drawable.theme_a0203_s));
        items2.add(new SearchFragmentItem(R.drawable.theme_a0205_s));
        items2.add(new SearchFragmentItem(R.drawable.theme_a0206_s));
        items2.add(new SearchFragmentItem(R.drawable.theme_a0207_s));
        SearchFragmentAdapter Adapter2 = new SearchFragmentAdapter(items2);
        recyclerViewType.setAdapter(Adapter2);


        recyclerViewArea.addOnItemTouchListener(new
                RecyclerViewOnItemClickListener(getActivity(), recyclerViewArea,
                new RecyclerViewOnItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        switch (position){
                            case 0:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.VISIBLE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 1:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.VISIBLE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 2:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.VISIBLE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 3:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.VISIBLE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 4:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.VISIBLE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 5:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.VISIBLE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 6:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.VISIBLE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 7:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.VISIBLE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 8:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.VISIBLE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 9:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.VISIBLE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 10:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.VISIBLE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 11:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.VISIBLE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;case 12:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.VISIBLE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;case 13:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.VISIBLE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;case 14:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.VISIBLE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 15:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.VISIBLE);
                                view_jeju.setVisibility(View.GONE);
                            }
                            break;
                            case 16:{
                                view_detail.setVisibility(View.VISIBLE);
                                view_seoul.setVisibility(View.GONE);
                                view_incheon.setVisibility(View.GONE);
                                view_daejeon.setVisibility(View.GONE);
                                view_daegu.setVisibility(View.GONE);
                                view_gwangju.setVisibility(View.GONE);
                                view_pusan.setVisibility(View.GONE);
                                view_ulsan.setVisibility(View.GONE);
                                view_sejong.setVisibility(View.GONE);
                                view_gyeonggi.setVisibility(View.GONE);
                                view_gangwon.setVisibility(View.GONE);
                                view_chungbuk.setVisibility(View.GONE);
                                view_chungnam.setVisibility(View.GONE);
                                view_gyeongbuk.setVisibility(View.GONE);
                                view_gyeongnam.setVisibility(View.GONE);
                                view_jeonbuk.setVisibility(View.GONE);
                                view_jeonnam.setVisibility(View.GONE);
                                view_jeju.setVisibility(View.VISIBLE);
                            }
                            break;
                        }

                    }

                    @Override
                    public void onItemLongClick(View v, int position) {


                    }
                }

        ));

                    recyclerViewType.addOnItemTouchListener(new
                    RecyclerViewOnItemClickListener(getActivity(), recyclerViewArea,
                    new RecyclerViewOnItemClickListener.OnItemClickListener() {

                        @Override
                        public void onItemClick(View v, int position) {
                            Intent intent = new Intent(v.getContext(), SearchActivity.class);
                            intent.putExtra("case", "type");
                            switch(position){
                                case 0: {
                                    intent.putExtra("type", "A0101");
                                    break;
                                }
                                case 1: {
                                    intent.putExtra("type", "A0201");
                                    break;
                                }
                                case 2: {
                                    intent.putExtra("type", "A0202");
                                    break;
                                }
                                case 3: {
                                    intent.putExtra("type", "A0203");
                                    break;
                                }
                                case 4: {
                                    intent.putExtra("type", "A0205");
                                    break;
                                }
                                case 5: {
                                    intent.putExtra("type", "A0206");
                                    break;
                                }
                                case 6: {
                                    intent.putExtra("type", "A0207");
                                    break;
                                }
                            }
                            v.getContext().startActivity(intent);
                        }
                        @Override
                    public void onItemLongClick(View v, int position) {

                    }
                }));




//        // 축제
//        themeButton[6].setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                v.setBackgroundResource(theme_selectedIcon[6]);
//                Intent intent = new Intent(v.getContext(), SearchActivity.class);
//                intent.putExtra("type", getResources().getResourceEntryName(v.getId()));
//                //     intent.putExtra("sigungucode", v.getText());
//                v.getContext().startActivity(intent);
//
//                for (int i = 0; i < 8; i++) {
//                    if (theme_selectedItems[i] == 1) {
//                        themeButton[i].setBackgroundResource(theme_unSelectedIcon[i]);
//                        theme_selectedItems[i] = 0;
//                    }
//                }
//
//                theme_selectedItems[6] = 1;
//            }
//
//        });


        // 버튼 리스너

        // 서울
        view.findViewById(R.id.tag_1_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_5).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_6).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_7).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_8).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_9).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_10).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_11).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_12).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_13).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_14).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_15).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_16).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_17).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_18).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_19).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_20).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_21).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_22).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_23).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_24).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_1_25).

                setOnClickListener(mClickListener);
        // 인천
        view.findViewById(R.id.tag_2_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_2_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_2_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_2_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_2_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_2_5).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_2_6).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_2_7).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_2_8).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_2_9).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_2_10).

                setOnClickListener(mClickListener);
        // 대전
        view.findViewById(R.id.tag_3_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_3_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_3_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_3_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_3_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_3_5).

                setOnClickListener(mClickListener);
        //대구
        view.findViewById(R.id.tag_4_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_4_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_4_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_4_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_4_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_4_5).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_4_6).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_4_7).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_4_8).

                setOnClickListener(mClickListener);
        //광주
        view.findViewById(R.id.tag_5_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_5_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_5_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_5_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_5_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_5_5).

                setOnClickListener(mClickListener);
        //부산
        view.findViewById(R.id.tag_6_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_5).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_6).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_7).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_8).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_9).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_10).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_11).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_12).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_13).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_14).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_15).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_6_16).

                setOnClickListener(mClickListener);
        //울산
        view.findViewById(R.id.tag_7_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_7_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_7_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_7_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_7_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_7_5).

                setOnClickListener(mClickListener);
        //세종
        view.findViewById(R.id.tag_8_1).

                setOnClickListener(mClickListener);
        //경기
        view.findViewById(R.id.tag_31_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_5).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_6).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_7).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_8).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_9).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_10).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_11).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_12).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_13).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_14).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_15).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_16).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_17).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_18).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_19).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_20).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_21).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_22).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_23).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_24).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_25).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_26).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_27).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_28).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_29).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_30).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_31_31).

                setOnClickListener(mClickListener);
        //강원
        view.findViewById(R.id.tag_32_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_5).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_6).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_7).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_8).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_9).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_10).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_11).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_12).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_13).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_14).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_15).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_16).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_17).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_32_18).

                setOnClickListener(mClickListener);
        //충북
        view.findViewById(R.id.tag_33_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_33_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_33_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_33_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_33_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_33_5).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_33_6).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_33_7).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_33_8).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_33_9).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_33_10).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_33_11).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_33_12).

                setOnClickListener(mClickListener);

        //충남
        view.findViewById(R.id.tag_34_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_5).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_6).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_7).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_8).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_9).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_11).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_12).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_13).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_14).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_15).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_34_16).

                setOnClickListener(mClickListener);
        //경북
        view.findViewById(R.id.tag_35_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_5).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_6).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_7).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_8).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_9).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_10).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_11).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_12).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_13).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_14).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_15).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_16).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_17).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_18).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_19).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_20).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_21).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_22).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_35_23).

                setOnClickListener(mClickListener);
        //경남
        view.findViewById(R.id.tag_36_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_5).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_6).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_7).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_8).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_9).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_10).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_12).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_13).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_14).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_15).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_16).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_17).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_18).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_19).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_20).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_36_21).

                setOnClickListener(mClickListener);
        //전북
        view.findViewById(R.id.tag_37_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_5).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_6).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_7).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_8).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_9).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_10).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_11).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_12).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_13).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_37_14).

                setOnClickListener(mClickListener);
        //전남

        view.findViewById(R.id.tag_38_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_4).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_5).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_6).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_7).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_8).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_9).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_10).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_11).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_12).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_13).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_16).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_17).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_18).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_19).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_20).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_21).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_22).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_23).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_38_24).

                setOnClickListener(mClickListener);

        //제주
        view.findViewById(R.id.tag_39_0).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_39_1).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_39_2).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_39_3).

                setOnClickListener(mClickListener);

        view.findViewById(R.id.tag_39_4).

                setOnClickListener(mClickListener);

        return view;
    }

    // 버튼 클릭 리스너
    public Button.OnClickListener mClickListener = new View.OnClickListener() {

        public void onClick(View v) {

            Button b = (Button) v;
            //  b.setBackgroundColor();
            Intent intent = new Intent(v.getContext(), SearchActivity.class);
            intent.putExtra("case", "area");
            String[] s = getResources().getResourceEntryName(b.getId()).split("_");
            intent.putExtra("areacode", s[1]);
            intent.putExtra("sigungucode", s[2]);
            v.getContext().startActivity(intent);

        }
    };
}