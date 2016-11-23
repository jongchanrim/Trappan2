package kr.co.trappan.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Adapter.CommentListAdapter;
import kr.co.trappan.Bean.Comment;
import kr.co.trappan.Connector.HttpClient;
import kr.co.trappan.Item.CustomProgressDialog;
import kr.co.trappan.Item.RecyclerViewOnItemClickListener;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-11-19.
 */

public class My_CommentActivity extends AppCompatActivity {

    Context context;
    private RecyclerView recyclerView;
    private CommentListAdapter Adapter;
    private RecyclerView.LayoutManager layoutManager;
    private CustomProgressDialog pd;
    ImageView review_backbutton;

    ArrayList<Comment> items = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_comment_page);

        pd = new CustomProgressDialog(My_CommentActivity.this);
        pd .getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        pd.show();
        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.my_comment_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Adapter = new CommentListAdapter(this, items, R.layout.activity_my_comment_page);
        recyclerView.setAdapter(Adapter);

        HttpClient.get("mcommentlist", null, new JsonHttpResponseHandler() {

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
                    Adapter.setItems(items);
                    Adapter.notifyDataSetChanged();
                    pd.dismiss();

                    //pd.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray response) {
                super.onFailure(statusCode, headers, throwable, response);
                pd.dismiss();

            }
        });

        recyclerView.addOnItemTouchListener(new

                RecyclerViewOnItemClickListener(My_CommentActivity.this, recyclerView,
                new RecyclerViewOnItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {

                        Intent intent = new Intent(My_CommentActivity.this, MemberPageActivity.class);
                        intent.putExtra("review_id", items.get(position).getReview_id());
                        startActivity(intent); // 다음 화면으로 넘어간다.
                    }

                    @Override
                    public void onItemLongClick(View v, int position) {

                    }
                }

        ));




        //뒤로가기 버튼
        review_backbutton = (ImageView) findViewById(R.id.my_comment_backbutton);
        review_backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}


