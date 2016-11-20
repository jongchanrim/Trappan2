package kr.co.trappan.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import kr.co.trappan.Activity.SearchActivity;


import kr.co.trappan.R;


/**
 * Created by thfad_000 on 2016-10-04.
 */
public class TabFragment2 extends Fragment {

    Context context;
    Button[] areaButton;
    Button[] themeButton;

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

    int[] theme_selectedItems;
    int[] theme_unSelectedIcon = {
            R.drawable.theme_a0101,
            R.drawable.theme_a0201,
            R.drawable.theme_a0202,
            R.drawable.theme_a0203,
            R.drawable.theme_a0205,
            R.drawable.theme_a0206,
            R.drawable.theme_a0207,
    };

    int[] theme_selectedIcon = {
            R.drawable.theme_a0101_s,
            R.drawable.theme_a0201_s,
            R.drawable.theme_a0202_s,
            R.drawable.theme_a0203_s,
            R.drawable.theme_a0205_s,
            R.drawable.theme_a0206_s,
            R.drawable.theme_a0207_s,};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.testfragment, container, false);
/*
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

        themeButton = new Button[7];
        themeButton[0] = (Button) view.findViewById(R.id.search_nature_button);
        themeButton[1] = (Button) view.findViewById(R.id.search_history_button);
        themeButton[2] = (Button) view.findViewById(R.id.search_rest_button);
        themeButton[3] = (Button) view.findViewById(R.id.search_activity_button);
        themeButton[4] = (Button) view.findViewById(R.id.search_building_button);
        themeButton[5] = (Button) view.findViewById(R.id.search_culture_button);
        themeButton[6] = (Button) view.findViewById(R.id.search_festival_button);


        selectedItems = new int[17];
        for (int i = 0; i < selectedItems.length; i++) {
            selectedItems[i] = 0;
        }

        theme_selectedItems = new int[7];
        for (int i = 0; i < theme_selectedItems.length; i++) {
            theme_selectedItems[i] = 0;
        }

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

        // 서울 클릭
        areaButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[0]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }

                selectedItems[0] = 1;
            }
        });
        //인천 클릭
        areaButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[1]);
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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);

                        selectedItems[i] = 0;

                    }
                }
                selectedItems[1] = 1;

            }
        });

        // 대전
        areaButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(selectedIcon[2]);
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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);

                        selectedItems[i] = 0;

                    }
                }
                selectedItems[2] = 1;
            }
        });

        //대구
        areaButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(selectedIcon[3]);
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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);

                        selectedItems[i] = 0;

                    }
                }
                selectedItems[3] = 1;
            }
        });

        //광주
        areaButton[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[4]);
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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;

                    }
                }
                selectedItems[4] = 1;
            }
        });
        // 부산
        areaButton[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[5]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;

                    }
                }
                selectedItems[5] = 1;
            }
        });
        // 울산
        areaButton[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[6]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;

                    }
                }
                selectedItems[6] = 1;
            }


        });
        // 세종
        areaButton[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[6]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;
                    }
                }
                selectedItems[7] = 1;
            }

        });

        // 경기
        areaButton[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[8]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;

                    }
                }
                selectedItems[8] = 1;
            }


        });
        // 강원
        areaButton[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[9]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;

                    }
                }
                selectedItems[9] = 1;
            }
        });

        // 충북
        areaButton[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[10]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;

                    }
                }
                selectedItems[10] = 1;
            }
        });

        // 충남
        areaButton[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[11]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;

                    }
                }
                selectedItems[11] = 1;
            }
        });

        // 경북
        areaButton[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[12]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;

                    }
                }
                selectedItems[12] = 1;
            }
        });

        // 세종
        areaButton[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[13]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;

                    }
                }
                selectedItems[13] = 1;
            }
        });

        // 전북
        areaButton[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[14]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] = 0;

                    }
                }
                selectedItems[14] = 1;
            }

        });
        // 전남
        areaButton[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[15]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);

                        selectedItems[i] = 0;

                    }
                }
                selectedItems[15] = 1;
            }

        });
        // 제주
        areaButton[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(selectedIcon[16]);

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

                for (int i = 0; i < 17; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);

                        selectedItems[i] = 0;


                    }
                }
                selectedItems[16] = 1;
            }
        });

        // 자연
        themeButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(theme_selectedIcon[0]);
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                intent.putExtra("type", getResources().getResourceEntryName(v.getId()));
                //     intent.putExtra("sigungucode", v.getText());
                v.getContext().startActivity(intent);

                for (int i = 0; i < 8; i++) {
                    if (theme_selectedItems[i] == 1) {
                        themeButton[i].setBackgroundResource(theme_unSelectedIcon[i]);
                        theme_selectedItems[i] = 0;
                    }
                }

                theme_selectedItems[0] = 1;
            }

        });

        // 역사
        themeButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(theme_selectedIcon[1]);
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                intent.putExtra("type", getResources().getResourceEntryName(v.getId()));
                //     intent.putExtra("sigungucode", v.getText());
                v.getContext().startActivity(intent);

                for (int i = 0; i < 8; i++) {
                    if (theme_selectedItems[i] == 1) {
                        themeButton[i].setBackgroundResource(theme_unSelectedIcon[i]);
                        theme_selectedItems[i] = 0;
                    }
                }

                theme_selectedItems[1] = 1;
            }

        });
        //휴양
        themeButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(theme_selectedIcon[2]);
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                intent.putExtra("type", getResources().getResourceEntryName(v.getId()));
                //     intent.putExtra("sigungucode", v.getText());
                v.getContext().startActivity(intent);

                for (int i = 0; i < 8; i++) {
                    if (theme_selectedItems[i] == 1) {
                        themeButton[i].setBackgroundResource(theme_unSelectedIcon[i]);
                        theme_selectedItems[i] = 0;
                    }
                }

                theme_selectedItems[2] = 1;
            }

        });

        // 체험
        themeButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(theme_selectedIcon[3]);
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                intent.putExtra("type", getResources().getResourceEntryName(v.getId()));
                //     intent.putExtra("sigungucode", v.getText());
                v.getContext().startActivity(intent);

                for (int i = 0; i < 8; i++) {
                    if (theme_selectedItems[i] == 1) {
                        themeButton[i].setBackgroundResource(theme_unSelectedIcon[i]);
                        theme_selectedItems[i] = 0;
                    }
                }

                theme_selectedItems[3] = 1;
            }

        });

        // 건축
        themeButton[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(theme_selectedIcon[4]);
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                intent.putExtra("type", getResources().getResourceEntryName(v.getId()));
                //     intent.putExtra("sigungucode", v.getText());
                v.getContext().startActivity(intent);

                for (int i = 0; i < 8; i++) {
                    if (theme_selectedItems[i] == 1) {
                        themeButton[i].setBackgroundResource(theme_unSelectedIcon[i]);
                        theme_selectedItems[i] = 0;
                    }
                }

                theme_selectedItems[4] = 1;
            }

        });
        //문화
        themeButton[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(theme_selectedIcon[5]);
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                intent.putExtra("type", getResources().getResourceEntryName(v.getId()));
                //     intent.putExtra("sigungucode", v.getText());
                v.getContext().startActivity(intent);

                for (int i = 0; i < 8; i++) {
                    if (theme_selectedItems[i] == 1) {
                        themeButton[i].setBackgroundResource(theme_unSelectedIcon[i]);
                        theme_selectedItems[i] = 0;
                    }
                }

                theme_selectedItems[5] = 1;
            }

        });
        // 축제
        themeButton[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundResource(theme_selectedIcon[6]);
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                intent.putExtra("type", getResources().getResourceEntryName(v.getId()));
                //     intent.putExtra("sigungucode", v.getText());
                v.getContext().startActivity(intent);

                for (int i = 0; i < 8; i++) {
                    if (theme_selectedItems[i] == 1) {
                        themeButton[i].setBackgroundResource(theme_unSelectedIcon[i]);
                        theme_selectedItems[i] = 0;
                    }
                }

                theme_selectedItems[6] = 1;
            }

        });


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
*/
        return view;
    }

    // 버튼 클릭 리스너
    public Button.OnClickListener mClickListener = new View.OnClickListener() {

        public void onClick(View v) {

            Button b = (Button) v;
            //  b.setBackgroundColor();
            Intent intent = new Intent(v.getContext(), SearchActivity.class);
            intent.putExtra("areacode", getResources().getResourceEntryName(b.getId()));
            intent.putExtra("sigungucode", b.getText());
            v.getContext().startActivity(intent);

        }
    };
}