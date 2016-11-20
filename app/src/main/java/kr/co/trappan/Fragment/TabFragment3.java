package kr.co.trappan.Fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Activity.SearchActivity;
import kr.co.trappan.Adapter.ReviewListAdapter;
import kr.co.trappan.Adapter.SearchFragmentAdapter;
import kr.co.trappan.Adapter.SearchListAdapter;
import kr.co.trappan.Bean.Tour;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.Item.RecyclerViewOnItemClickListener;
import kr.co.trappan.Item.SearchFragmentItem;
import kr.co.trappan.Item.SearchLists_item;
import kr.co.trappan.R;
/**
 * Created by thfad_000 on 2016-10-04.
 */
public class TabFragment3 extends Fragment {

    RecyclerView recyclerViewArea;
    private RecyclerView recyclerViewc;
    private RecyclerView.Adapter Adapterc;
    private LinearLayoutManager layoutManagerc;
    ArrayList<Tour>
            items = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment3, container, false);

        recyclerViewArea = (RecyclerView) view.findViewById(R.id.reco_area);
        recyclerViewArea.setHasFixedSize(true);

        ArrayList<SearchFragmentItem> itemsb = new ArrayList<>();

        itemsb.add(new SearchFragmentItem(R.drawable.seoul_1_c));
        itemsb.add(new SearchFragmentItem(R.drawable.incheon_2_c));
        itemsb.add(new SearchFragmentItem(R.drawable.daejeon_3_c));
        itemsb.add(new SearchFragmentItem(R.drawable.daegu_4_c));
        itemsb.add(new SearchFragmentItem(R.drawable.gwangju_5_c));
        itemsb.add(new SearchFragmentItem(R.drawable.pusan_6_c));
        itemsb.add(new SearchFragmentItem(R.drawable.ulsan_7_c));
        itemsb.add(new SearchFragmentItem(R.drawable.sejong_8_c));
        itemsb.add(new SearchFragmentItem(R.drawable.gyeonggi_31_c));
        itemsb.add(new SearchFragmentItem(R.drawable.gangwon_32));
        itemsb.add(new SearchFragmentItem(R.drawable.chungbuk_33_c));
        itemsb.add(new SearchFragmentItem(R.drawable.chungnam_34_c));
        itemsb.add(new SearchFragmentItem(R.drawable.gyeongbuk_35_c));
        itemsb.add(new SearchFragmentItem(R.drawable.gyeongnam_36_c));
        itemsb.add(new SearchFragmentItem(R.drawable.jeonbuk_37_c));
        itemsb.add(new SearchFragmentItem(R.drawable.jeonnam_38_c));
        itemsb.add(new SearchFragmentItem(R.drawable.jeju_39_c));

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerViewArea.setLayoutManager(layoutManager);

        SearchFragmentAdapter Adapter = new SearchFragmentAdapter(itemsb);
        recyclerViewArea.setAdapter(Adapter);




        recyclerViewc = (RecyclerView) view.findViewById(R.id.recmmand_list);
        layoutManagerc = new LinearLayoutManager(getActivity());
        recyclerViewc.setLayoutManager(layoutManagerc);
        Adapterc = new SearchListAdapter(getActivity(),items, 1);
        recyclerViewc.setAdapter(Adapterc);

        HttpClient.get("randomreco", null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                try {

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = response.getJSONObject(i);
                        Tour tour = new Tour();
                        tour.setContentid(obj.getString("contentid"));
                        tour.setTitle(obj.getString("title"));
                        tour.setAreacode(obj.getString("areacode"));
                        tour.setCat2(obj.getString("cat2"));
                        tour.setFirstimage(obj.getString("firstimage"));
                        tour.setSigungucode(obj.getString("sigungucode"));
                        tour.setLike(obj.getInt("tlike"));
                        tour.setStamp(obj.getInt("stamp"));
                        tour.setRate(obj.getDouble("rate"));
                        items.add(tour);
                    }
                    Adapterc.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });

        recyclerViewArea.addOnItemTouchListener(new
                RecyclerViewOnItemClickListener(getActivity(), recyclerViewArea,
                new RecyclerViewOnItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View v, int position) {
                        RequestParams params = new RequestParams();
                        switch(position){
                            case 0: {
                                params.put("areacode", "1");
                                break;
                            }
                            case 1: {
                                params.put("areacode", "2");                                break;
                            }
                            case 2: {
                                params.put("areacode", "3");                                break;
                            }
                            case 3: {
                                params.put("areacode", "4");                                 break;
                            }
                            case 4: {
                                params.put("areacode", "5");                                 break;
                            }
                            case 5: {
                                params.put("areacode", "6");                                 break;
                            }
                            case 6: {
                                params.put("areacode", "7");                                 break;
                            }
                            case 7: {
                                params.put("areacode", "8");                                 break;
                            }
                            case 8: {
                                params.put("areacode", "9");                                 break;
                            }
                            case 9: {
                                params.put("areacode", "31");                                 break;
                            }
                            case 10: {
                                params.put("areacode", "32");                                 break;
                            }
                            case 11: {
                                params.put("areacode", "33");                                 break;
                            }
                            case 12: {
                                params.put("areacode", "34");                                 break;
                            }
                            case 13: {
                                params.put("areacode", "35");                                 break;
                            }
                            case 14: {
                                params.put("areacode", "36");                                 break;
                            }
                            case 15: {
                                params.put("areacode", "37");                                 break;
                            }
                            case 16: {
                                params.put("areacode", "38");                                 break;
                            }
                            case 17: {
                                params.put("areacode", "39");                                 break;
                            }

                        }
                        HttpClient.get("randomreco", null, new JsonHttpResponseHandler() {

                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                                super.onSuccess(statusCode, headers, response);
                                try {
                                    ArrayList<Tour> temp = new ArrayList<Tour>();

                                    for (int i = 0; i < response.length(); i++) {
                                        JSONObject obj = response.getJSONObject(i);
                                        Tour tour = new Tour();
                                        tour.setContentid(obj.getString("contentid"));
                                        tour.setTitle(obj.getString("title"));
                                        tour.setAreacode(obj.getString("areacode"));
                                        tour.setCat2(obj.getString("cat2"));
                                        tour.setFirstimage(obj.getString("firstimage"));
                                        tour.setSigungucode(obj.getString("sigungucode"));
                                        tour.setLike(obj.getInt("tlike"));
                                        tour.setStamp(obj.getInt("stamp"));
                                        tour.setRate(obj.getDouble("rate"));
                                        temp.add(tour);
                                    }
                                    items = temp;
                                    Adapterc.notifyDataSetChanged();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray response) {
                                super.onFailure(statusCode, headers, throwable, response);

                            }
                        });

                    }
                    @Override
                    public void onItemLongClick(View v, int position) {

                    }
                }));





                    return view;
    }
}