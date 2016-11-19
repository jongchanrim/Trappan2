package kr.co.trappan.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

import kr.co.trappan.Adapter.CommentListAdapter;
import kr.co.trappan.Bean.Comment;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-11-19.
 */

public class My_CommentActivity extends AppCompatActivity {

    Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_comment_page);

        ArrayList<Comment> items = new ArrayList<>();

        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.my_comment_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Adapter = new CommentListAdapter(this, items, R.layout.activity_my_comment_page);
        recyclerView.setAdapter(Adapter);

        //items.add(new Comment(comment_id,review_id,comment_count,"id","comment_content","c_date"));
        items.add(new Comment(1, 2, 3, "아이디", "리뷰를 남겼다. 리뷰를 남겼다, 리뷰를 남겼다. 리뷰를 남겼다.", "2016-11-18"));
        items.add(new Comment(1, 2, 3, "아이디", "리뷰를 남겼다. 리뷰를 남겼다, 리뷰를 남겼다. 리뷰를 남겼다.", "2016-11-18"));
        items.add(new Comment(1, 2, 3, "아이디", "리뷰를 남겼다. 리뷰를 남겼다, 리뷰를 남겼다. 리뷰를 남겼다.", "2016-11-18"));
        items.add(new Comment(1, 2, 3, "아이디", "리뷰를 남겼다. 리뷰를 남겼다, 리뷰를 남겼다. 리뷰를 남겼다.리뷰를 남겼다. 리뷰를 남겼다, 리뷰를 남겼다. 리뷰를 남겼다.", "2016-11-18"));

        //뒤로가기 버튼
        ImageButton review_backbutton = (ImageButton)findViewById(R.id.my_comment_backbutton);
        review_backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}


