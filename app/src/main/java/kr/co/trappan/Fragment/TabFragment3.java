package kr.co.trappan.Fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.trappan.Adapter.SearchListAdapter;
import kr.co.trappan.Item.SearchLists_item;
import kr.co.trappan.R;
/**
 * Created by thfad_000 on 2016-10-04.
 */
public class TabFragment3 extends Fragment {

    private Thread splashThread;

    Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    Button[] areaButton;

    int[] selectedItems;
    int[] unSelectedIcon = {R.drawable.seoul_1,
            R.drawable.incheon_2,
            R.drawable.daegu_4,
            R.drawable.daejeon_3,
            R.drawable.gwangju_5,
            R.drawable.pusan_6,
            R.drawable.ulsan_7,
            R.drawable.sejong_8,
            R.drawable.gyeonggi_31,
            R.drawable.gangwon_32,
            R.drawable.chungbuk_33,
            R.drawable.chungnam_34,
            R.drawable.jeonnam_38,
            R.drawable.jeonbuk_37,
            R.drawable.gyeongbuk_35,
            R.drawable.gyeongnam_36,
            R.drawable.jeju_39,
    };

    int[] selectedIcon = {R.drawable.seoul_1_c,
            R.drawable.incheon_2_c,
            R.drawable.daegu_4_c,
            R.drawable.daejeon_3_c,
            R.drawable.gwangju_5_c,
            R.drawable.pusan_6_c,
            R.drawable.ulsan_7_c,
            R.drawable.sejong_8_c,
            R.drawable.gyeonggi_31_c,
            R.drawable.gangwon_32,
            R.drawable.chungbuk_33_c,
            R.drawable.chungnam_34_c,
            R.drawable.jeonbuk_37_c,
            R.drawable.jeonnam_38_c,
            R.drawable.gyeongbuk_35_c,
            R.drawable.gyeongbuk_35_c,
            R.drawable.jeju_39_c,};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment3, container, false);


        // 리스트 뷰
        ArrayList<SearchLists_item> items = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.recmmand_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new SearchListAdapter(getActivity(), items, R.layout.tabfragment3);
        recyclerView.setAdapter(Adapter);


        // horizontal 스크롤뷰 버튼
        areaButton = new Button[17];
        areaButton[0] = (Button) view.findViewById(R.id.search_seoul_button);
        areaButton[1] = (Button) view.findViewById(R.id.search_incheon_button);
        areaButton[2] = (Button) view.findViewById(R.id.search_daegu_button);
        areaButton[3] = (Button) view.findViewById(R.id.search_daejeon_button);
        areaButton[4] = (Button) view.findViewById(R.id.search_gwangju_button);
        areaButton[5] = (Button) view.findViewById(R.id.search_pusan_button);
        areaButton[6] = (Button) view.findViewById(R.id.search_ulsan_button);
        areaButton[7] = (Button) view.findViewById(R.id.search_sejong_button);
        areaButton[8] = (Button) view.findViewById(R.id.search_gyeonggi_button);
        areaButton[9] = (Button) view.findViewById(R.id.search_gangwon_button);
        areaButton[10] = (Button) view.findViewById(R.id.search_chungbuk_button);
        areaButton[11] = (Button) view.findViewById(R.id.search_chungnam_button);
        areaButton[12] = (Button) view.findViewById(R.id.search_gyeongbuk_button);
        areaButton[13] = (Button) view.findViewById(R.id.search_gyeongnam_button);
        areaButton[14] = (Button) view.findViewById(R.id.search_jeonbuk_button);
        areaButton[15] = (Button) view.findViewById(R.id.search_jeonnam_button);
        areaButton[16] = (Button) view.findViewById(R.id.search_jeju_button);

        selectedItems = new int[17];
        for (int i = 0; i < selectedItems.length; i++) {
            selectedItems[i] = 0;
        }

        final TextView recommandName = (TextView) view.findViewById(R.id.recommand_regionName);

        // 서울 클릭
        areaButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[0]);

                recommandName.setText("서울 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[0] = 1;
            }
        });
        // 인천 클릭
        areaButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[1]);

                recommandName.setText("인천 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[1] = 1;
            }
        });
        // 대전 클릭
        areaButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[2]);

                recommandName.setText("대전 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[0] = 1;
            }
        });
        // 대구 클릭
        areaButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[3]);

                recommandName.setText("대구 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[3] = 1;
            }
        });
        // 광주 클릭
        areaButton[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[4]);

                recommandName.setText("광주 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[4] = 1;
            }
        });
        // 부산 클릭
        areaButton[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[5]);

                recommandName.setText("부산 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[5] = 1;
            }
        });
        // 울산 클릭
        areaButton[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[6]);

                recommandName.setText("울산 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[6] = 1;
            }
        });
        // 세종 클릭
        areaButton[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[7]);

                recommandName.setText("세종 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[7] = 1;
            }
        });
        // 경기 클릭
        areaButton[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[8]);

                recommandName.setText("경기 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[8] = 1;
            }
        });
        // 강원 클릭
        areaButton[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[9]);

                recommandName.setText("강원 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[9] = 1;
            }
        });
        // 충북 클릭
        areaButton[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[10]);

                recommandName.setText("충북 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[10] = 1;
            }
        });
        // 충남 클릭
        areaButton[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[11]);

                recommandName.setText("충남 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[11] = 1;
            }
        });
        // 경북 클릭
        areaButton[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[12]);

                recommandName.setText("경북 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[12] = 1;
            }
        });
        // 경남 클릭
        areaButton[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[13]);

                recommandName.setText("경남 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[13] = 1;
            }
        });
        // 전북 클릭
        areaButton[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[14]);

                recommandName.setText("전북 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[14] = 1;
            }
        });
        // 전남 클릭
        areaButton[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[0]);

                recommandName.setText("전남 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[15] = 1;
            }
        });
        // 제주 클릭
        areaButton[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[16]);

                recommandName.setText("제주 추천 여행지");

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[16] = 1;
            }
        });

                return view;
    }
}