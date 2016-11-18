package kr.co.trappan.Activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Adapter.SearchListAdapter;
import kr.co.trappan.Bean.Tour;
import kr.co.trappan.Connector.NameSelector;
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
    TextView search_name;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Tour> items = new ArrayList<>();

    String searchcase;
    CustomProgressDialog pd;
    JSONArray jsonArray = new JSONArray();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        pd = new CustomProgressDialog(SearchActivity.this);
        pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pd.show();
        Intent intent = getIntent();

        searchcase = intent.getExtras().getString("case");
        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.search_list);
        search_name = (TextView) findViewById(R.id.search_name);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SearchListAdapter(this, items, R.layout.search);
        recyclerView.setAdapter(adapter);

        if (searchcase.equals("area")) {

            String areacode = intent.getExtras().getString("areacode");
            String sigungucode = intent.getExtras().getString("sigungucode");

            search_name.setText(NameSelector.selectAreaName(areacode)+" "+NameSelector.selectSigunguName(areacode, sigungucode));

            RequestParams params = new RequestParams();
            params.put("areacode", areacode.toString().trim());
            params.put("sigungucode", sigungucode.toString().trim());
            params.put("areacode", areacode);
            params.put("sigungucode", sigungucode);

            HttpClient.get("sigungulist", params, new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                    Log.d(TAG, "httpOK: " + response.length());
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
        } else if (searchcase.equals("keyword")) {

            String keyword = intent.getExtras().getString("keyword");
            if(keyword != null)
            search_name.setText(keyword.toString());
            RequestParams params = new RequestParams();
            params.put("keyword", keyword.toString().trim());


            HttpClient.get("searchlist", params, new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                    Log.d(TAG, "httpOK: " + response.length());
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
        } else if (searchcase.equals("type")) {
            String type = intent.getExtras().getString("type");
            RequestParams params = new RequestParams();
            params.put("type", type.toString().trim());
            search_name.setText(NameSelector.selectCAT2(type));

            HttpClient.get("typelist", params, new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                    Log.d(TAG, "httpOK: " + response.length());
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
        }


        recyclerView.addOnItemTouchListener(new

                RecyclerViewOnItemClickListener(SearchActivity.this, recyclerView,
                new RecyclerViewOnItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        Log.d(TAG, "click");

                        Intent intent = new Intent(SearchActivity.this, DetailInformationActivity.class);
                        intent.putExtra("contentid", items.get(position).getContentid());
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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Search Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
