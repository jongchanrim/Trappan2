package kr.co.trappan.Activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Adapter.SearchListAdapter;
import kr.co.trappan.Item.SearchLists_item;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.Item.CustomProgressDialog;
import kr.co.trappan.Item.RecyclerViewOnItemClickListener;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-11-11.
 */

public class SearchActivity extends AppCompatActivity {
    static final String TAG = SearchActivity.class.getSimpleName();
    Context context;
    RecyclerView recyclerView;
    SearchListAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<SearchLists_item> items = new ArrayList<>();
    String areacode;
    String sigungucode;
    CustomProgressDialog pd;
    JSONArray jsonArray = new JSONArray();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        pd = new CustomProgressDialog(SearchActivity.this);
        pd .getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        pd.show();
        Intent intent = getIntent();
        areacode = intent.getExtras().getString("areacode");
        sigungucode = intent.getExtras().getString("sigungucode");

        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.search_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SearchListAdapter(this, items, R.layout.search);
        recyclerView.setAdapter(adapter);


        RequestParams params = new RequestParams();
//        params.put("areacode", areacode.toString().trim());
//        params.put("sigungucode", sigungucode.toString().trim());

        params.put("areacode", "1");
        params.put("sigungucode", "1");
        HttpClient.get("arealist", params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                Log.d(TAG, "httpOK: " + response.length());
                try {

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = response.getJSONObject(i);

                        items.add(new SearchLists_item(obj.getInt("like"), obj.getString("contentid"), obj.getString("title"),
                                obj.getString("areacode"), obj.getString("sigungucode"), obj.getString("firstimage"), obj.getInt("stamp"), obj.getInt("rate")));
                        Log.d(TAG, "httpOK: " + items.get(i).getFirstimage().toString());
                    }
                    adapter.setItems(items);
                    adapter.notifyDataSetChanged();
                    pd.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });


        recyclerView.addOnItemTouchListener(new RecyclerViewOnItemClickListener(SearchActivity.this, recyclerView,
                new RecyclerViewOnItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        Log.d(TAG, "click");

                        Intent intent = new Intent(SearchActivity.this, DetailInformationActivity.class);
                        intent.putExtra("contentid", items.get(position).getContentId());
                        startActivity(intent); // 다음 화면으로 넘어간다.
                    }

                    @Override
                    public void onItemLongClick(View v, int position) {
                        Log.d(TAG, "long click");
                    }
                }
        ));


//        Intent intent = getIntent();
//        String region_name = intent.getStringExtra("region_name");
//        String region_detail= intent.getStringExtra("region_detail");
//
//        TextView region = (TextView)findViewById(R.id.search_name);
//        region.setText(region_name);
//
//        TextView regionDetail = (TextView)findViewById(R.id.search_name_detail);
//        regionDetail.setText(region_detail);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        // client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }




}
