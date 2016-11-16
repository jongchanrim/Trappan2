package kr.co.trappan.Activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;

import java.util.ArrayList;

import kr.co.trappan.Adapter.DetailInfoCommentAdapter;
import kr.co.trappan.Adapter.ListViewAdapter;
import kr.co.trappan.Dialog.RatingDialog;
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

    private Dialog ratingDialog;
    private RatingBar ratingBar;

    private TextView content;
    private TextView btn_more;
    String test="서울대학교미술관은 여러 해 동안의 긴 준비끝에 서울대학교 박물관 현대미술부에서 독립하여 국내최초의 대학미술관으로 탄생하게 되었다.삼성그룹이 건립하여 그렇게되었다 블라블라 블라";

    String star_rate="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_information);

        main_image=(ImageView)findViewById(R.id.main_image);
        main_image_text=(TextView)findViewById(R.id.main_image_text);
        btn_image1=(ImageView)findViewById(R.id.btn1_image1);
        btn_image2=(ImageView)findViewById(R.id.btn1_image2);
        btn_image3=(ImageView)findViewById(R.id.btn1_image3);

        content=(TextView)findViewById(R.id.content_dd);
        btn_more=(TextView)findViewById(R.id.btn_more);

        if(test.length()<30) {
            content.setText(test);
            btn_more.setVisibility(View.INVISIBLE);
        } else{
            content.setText(test.substring(0,30)+"...");
        }

        btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_more.getText().toString()=="더보기"){
                    btn_more.setText("접기");
                    content.setText(test);
                }else{
                    content.setText(test.substring(0,30)+"...");
                    btn_more.setText("더보기");
                }

            }
        });




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
                ratingDialog=new Dialog(DetailInformationActivity.this);
                ratingDialog.setContentView(R.layout.rating_dialog);
                ratingDialog.setCancelable(true);
                ratingBar = (RatingBar)ratingDialog.findViewById(R.id.ratingBar);
                ratingBar.setRating(0);

                Drawable progress = ratingBar.getProgressDrawable();
                DrawableCompat.setTint(progress, Color.LTGRAY);

                LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
                stars.getDrawable(2).setColorFilter(Color.parseColor("#f8b62b"), PorterDuff.Mode.SRC_ATOP);

                TextView text = (TextView) ratingDialog.findViewById(R.id.rating_text);
                text.setText("별점주기");

                Button updateButton = (Button) ratingDialog.findViewById(R.id.btn_check);
                updateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("rate",star_rate);
                        btn_image3.setBackgroundResource(R.drawable.detail_icon_03_02);
                        ratingDialog.dismiss();
                    }
                });

                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        star_rate=""+rating;
                    }
                });
                //now that the dialog is set up, it's time to show it
                ratingDialog.show();

            }
        });

    }



    private View.OnClickListener checklistner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    private View.OnClickListener falselistner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

}
