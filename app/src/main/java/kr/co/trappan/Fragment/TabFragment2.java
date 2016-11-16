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

    int[] selectedItems;
    int[] unSelectedIcon = {R.drawable.seoul_1,
                          R.drawable.incheon_2,
                          R.drawable.daegu_4,
                          R.drawable.daejeon_3,
                          R.drawable.gwangju_5,
                          R.drawable.pusan_6,
                          R.drawable.ulsan_7,
                          R.drawable.sejong_8};

    int[] selectedIcon = {R.drawable.seoul_1_c,
            R.drawable.incheon_2_c,
            R.drawable.daegu_4_c,
            R.drawable.daejeon_3_c,
            R.drawable.gwangju_5_c,
            R.drawable.pusan_6_c,
            R.drawable.ulsan_7_c,
            R.drawable.sejong_8_c};


    public static View view_detail;
    public static View view_seoul;
    public static View view_pusan;
    public static View view_incheon;
    public static View view_daegu;
    public static View view_daejeon;
    public static View view_gwangju;
    public static View view_ulsan;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment2, container, false);
        areaButton = new Button[17];
        areaButton[0] = (Button) view.findViewById(R.id.search_seoul_button);
        areaButton[1] = (Button) view.findViewById(R.id.search_incheon_button);
        areaButton[2] = (Button) view.findViewById(R.id.search_daegu_button);
        areaButton[3] = (Button) view.findViewById(R.id.search_daejeon_button);
        areaButton[4] = (Button) view.findViewById(R.id.search_gwangju_button);
        areaButton[5] = (Button) view.findViewById(R.id.search_pusan_button);
        areaButton[6] = (Button) view.findViewById(R.id.search_ulsan_button);
        areaButton[7] = (Button) view.findViewById(R.id.search_sejong_button);

        selectedItems = new int[17];
        for(int i = 0; i < selectedItems.length; i++){
            selectedItems[i] = 0;
        }

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
                for (int i = 0; i < 8; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] =0;
                    }
                }
                selectedItems[0] = 1;
            }
        });

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
                for (int i = 0; i < 8; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] =0;
                    }
                }
                selectedItems[1] = 1;

            }
        });

        areaButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(selectedIcon[2]);
                view_detail.setVisibility(View.VISIBLE);
                view_seoul.setVisibility(View.GONE);
                view_incheon.setVisibility(View.GONE);
                view_daejeon.setVisibility(View.GONE);
                view_daegu.setVisibility(View.VISIBLE);
                view_gwangju.setVisibility(View.GONE);
                view_pusan.setVisibility(View.GONE);
                view_ulsan.setVisibility(View.GONE);
                for (int i = 0; i < 8; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] =0;
                    }
                }
                selectedItems[2] = 1;
            }
        });

        areaButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(selectedIcon[3]);
                view_detail.setVisibility(View.VISIBLE);
                view_seoul.setVisibility(View.GONE);
                view_incheon.setVisibility(View.GONE);
                view_daejeon.setVisibility(View.VISIBLE);
                view_daegu.setVisibility(View.GONE);
                view_gwangju.setVisibility(View.GONE);
                view_pusan.setVisibility(View.GONE);
                view_ulsan.setVisibility(View.GONE);
                for (int i = 0; i < 8; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] =0;
                    }
                }
                selectedItems[3] = 1;
            }
        });

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
                for (int i = 0; i < 8; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] =0;
                    }
                }
                selectedItems[4] = 1;
            }
        });

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
                for (int i = 0; i < 8; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] =0;
                    }
                }
                selectedItems[5] = 1;
            }
        });

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
                for (int i = 0; i < 8; i++) {
                    if (selectedItems[i] == 1) {
                        areaButton[i].setBackgroundResource(unSelectedIcon[i]);
                        selectedItems[i] =0;
                    }
                }
                selectedItems[6] = 1;
            }
        });




        view_detail = view.findViewById(R.id.region_detail);
        view_seoul = view.findViewById(R.id.region_detail_seoul);
        view_incheon = view.findViewById(R.id.region_detail_incheon);
        view_daejeon = view.findViewById(R.id.region_detail_daegeon);
        view_daegu = view.findViewById(R.id.region_detail_daegu);
        view_gwangju = view.findViewById(R.id.region_detail_gwangju);
        view_pusan = view.findViewById(R.id.region_detail_pusan);
        view_ulsan = view.findViewById(R.id.region_detail_ulsan);

        view_detail.setVisibility(View.GONE);
        view_seoul.setVisibility(View.GONE);
        view_incheon.setVisibility(View.GONE);
        view_daejeon.setVisibility(View.GONE);
        view_daegu.setVisibility(View.GONE);
        view_gwangju.setVisibility(View.GONE);
        view_pusan.setVisibility(View.GONE);
        view_ulsan.setVisibility(View.GONE);



        // 버튼 리스너

        // 서울
        // 서울
        view.findViewById(R.id.tag_1).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_1).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_2).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_3).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_4).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_5).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_6).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_7).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_8).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_9).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_10).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_11).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_12).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_13).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_14).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_15).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_16).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_17).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_18).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_19).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_20).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_21).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_22).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_23).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_24).setOnClickListener(mClickListener);
        view.findViewById(R.id.tag_1_25).setOnClickListener(mClickListener);
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
            intent.putExtra("areacode", "test");
            intent.putExtra("sigungucode", b.getText());
            v.getContext().startActivity(intent);

        }
    };
}