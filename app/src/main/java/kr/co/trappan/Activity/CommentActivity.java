package kr.co.trappan.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Adapter.CommentListAdapter;
import kr.co.trappan.Adapter.FollowingListAdapter;
import kr.co.trappan.Bean.Comment;
import kr.co.trappan.Bean.Member;
import kr.co.trappan.Bean.Tour;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-11-18.
 */

public class CommentActivity extends AppCompatActivity {

    Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Comment> items = new ArrayList<>();
    EditText comment_write_content;
    int review_id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_page);

        Intent intent = getIntent();
        review_id = intent.getExtras().getInt("review_id");


        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.comment_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Adapter = new CommentListAdapter(this, items, R.layout.activity_comment_page);
        recyclerView.setAdapter(Adapter);

        RequestParams params = new RequestParams();
        params.put("review_id", review_id);


        HttpClient.get("commentlist", params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                try {

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = response.getJSONObject(i);
                        Comment comment = new Comment();
                        comment.setComment_id(obj.getInt("comment_id"));
                        comment.setReview_id(obj.getInt("review_id"));
                        comment.setComment_content(obj.getString("comment_content"));
                        comment.setId(obj.getString("id"));
                        comment.setC_date(obj.getString("c_date"));
                        items.add(comment);
                    }
                    Adapter.notifyDataSetChanged();
                    //pd.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray response) {
                super.onFailure(statusCode, headers, throwable, response);

            }
        });


        //뒤로가기 버튼
        ImageView review_backbutton = (ImageView) findViewById(R.id.comment_backbutton);

        review_backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // 코멘트 내용
        comment_write_content = (EditText) findViewById(R.id.comment_write_comment);

        Button send_button = (Button) findViewById(R.id.comment_send_button);
        // 보내기 버튼 클릭
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params = new RequestParams();
                params.put("review_id", review_id);
                params.put("comment_content", comment_write_content.getText());

                HttpClient.get("addcomment", params, new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        super.onSuccess(statusCode, headers, response);


                    }
                });

            }
        });
    }
}


