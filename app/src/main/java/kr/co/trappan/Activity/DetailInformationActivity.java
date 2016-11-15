package kr.co.trappan.Activity;

import android.graphics.Paint;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;

import java.util.ArrayList;

import kr.co.trappan.Adapter.DetailInfoCommentAdapter;
import kr.co.trappan.Adapter.ListViewAdapter;
import kr.co.trappan.Item.DetailInfoComment_item;
import kr.co.trappan.Item.List_item;
import kr.co.trappan.R;

public class DetailInformationActivity extends AppCompatActivity {

    private ImageView main_image;
    private TextView main_image_text;
    private ImageView btn_image1,btn_image2,btn_image3;

    private ScrollView scrollView;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_information);

        main_image=(ImageView)findViewById(R.id.main_image);
        main_image_text=(TextView)findViewById(R.id.main_image_text);
        btn_image1=(ImageView)findViewById(R.id.btn1_image1);
        btn_image2=(ImageView)findViewById(R.id.btn1_image2);
        btn_image3=(ImageView)findViewById(R.id.btn1_image3);


        recyclerView=(RecyclerView)findViewById(R.id.detail_information_list);
        recyclerView.setHasFixedSize(true);

        RecyclerViewHeader header = (RecyclerViewHeader) findViewById(R.id.header);

        ArrayList<DetailInfoComment_item> items = new ArrayList<>();
        items.add(new DetailInfoComment_item("@hyojoo",R.drawable.gangwon,"전시회 너무 대단했다","동해물과 백두산이 마르고 닳도록..."));
        items.add(new DetailInfoComment_item("@hyojoo",R.drawable.gangwon,"전시회 너무 대단했다","동해물과 백두산이 마르고 닳도록..."));
        items.add(new DetailInfoComment_item("@hyojoo",R.drawable.gangwon,"전시회 너무 대단했다","동해물과 백두산이 마르고 닳도록..."));
        items.add(new DetailInfoComment_item("@hyojoo",R.drawable.gangwon,"전시회 너무 대단했다","동해물과 백두산이 마르고 닳도록..."));
        items.add(new DetailInfoComment_item("@hyojoo",R.drawable.gangwon,"전시회 너무 대단했다","동해물과 백두산이 마르고 닳도록..."));
        items.add(new DetailInfoComment_item("@hyojoo",R.drawable.gangwon,"전시회 너무 대단했다","동해물과 백두산이 마르고 닳도록..."));
        items.add(new DetailInfoComment_item("@hyojoo",R.drawable.gangwon,"전시회 너무 대단했다","동해물과 백두산이 마르고 닳도록..."));
        items.add(new DetailInfoComment_item("@hyojoo",R.drawable.gangwon,"전시회 너무 대단했다","동해물과 백두산이 마르고 닳도록..."));
        items.add(new DetailInfoComment_item("@hyojoo",R.drawable.gangwon,"전시회 너무 대단했다","동해물과 백두산이 마르고 닳도록..."));

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Adapter = new DetailInfoCommentAdapter(this ,items);
        recyclerView.setAdapter(Adapter);
        header.attachTo(recyclerView);
        main_image.setBackgroundResource(R.drawable.seoul);
        main_image_text.setPaintFlags(main_image_text.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);

        btn_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_image1.setBackgroundResource(R.drawable.detail_icon_01_02);
            }
        });
        btn_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_image2.setBackgroundResource(R.drawable.detail_icon_02_02);
            }
        });
        btn_image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_image3.setBackgroundResource(R.drawable.detail_icon_03_02);
            }
        });
    }

    private void resizeCommentList(int item_size){
        ViewGroup.LayoutParams params = recyclerView.getLayoutParams();
        params.height = 10 * item_size;
        recyclerView.setLayoutParams(params);
    }


}
