package kr.co.trappan.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

import kr.co.trappan.Adapter.CommentListAdapter;
import kr.co.trappan.Adapter.ListViewAdapter;
import kr.co.trappan.Adapter.ReviewListAdapter;
import kr.co.trappan.Bean.Comment;
import kr.co.trappan.Bean.Review;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-11-19.
 */
public class LikeActivity extends AppCompatActivity {

    Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_page);

        ArrayList<Review> items = new ArrayList<>();

        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.like_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Adapter = new ReviewListAdapter(this, items);
        recyclerView.setAdapter(Adapter);

        // items.add(new Comment(review_id,id,contentid,review_title,review_content,img_1,img_2,img_3,img_4,img_5,img_6,c_date));
    // items.add(new Review("a","a","a","a","a","a","a","a","a","a","a","a","a"));

        // 뒤로가기 버튼
        ImageView review_backbutton = (ImageView) findViewById(R.id.like_backbutton);

        review_backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });
    }
}
