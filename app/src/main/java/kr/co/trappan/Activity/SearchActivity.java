package kr.co.trappan.Activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
import kr.co.trappan.Bean.ListBean;
import kr.co.trappan.Util.HttpClient;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-11-11.
 */

public class SearchActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ListBean> items = new ArrayList<>();
    String areacode;
    String sigungucode;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        Intent intent = getIntent();
        areacode = intent.getExtras().getString("areacode");
        sigungucode = intent.getExtras().getString("sigungucode");

        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.search_list);
        recyclerView.setHasFixedSize(true);


        RequestParams params = new RequestParams();
//        params.put("areacode", areacode.toString().trim());
//        params.put("sigungucode", sigungucode.toString().trim());

        params.put("areacode", "1");
        params.put("sigungucode", "1");
        HttpClient.get("arealist", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                try {

                    JSONObject obj = new JSONObject();
                    for (int i = 0; i < response.length(); i++) {
                        obj = response.getJSONObject(i);
                        items.add(new ListBean(obj.getString("title"), obj.getString("areacode"), obj.getString("sigungucode"), obj.getString("firstimage"), obj.getInt("stamp"), obj.getInt("rate"), obj.getInt("like"))); //String title, String sigungucode, String firstimage, int stamp, int rate, int like
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });



        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SearchListAdapter(this, items, R.layout.search);
        recyclerView.setAdapter(adapter);

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
