package kr.co.trappan.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.co.trappan.Adapter.ReviewPagerAdapter;
import kr.co.trappan.R;

public class ReviewPageActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_page);

        viewPager=(ViewPager)findViewById(R.id.review_viewpager);
        ReviewPagerAdapter adapter=new ReviewPagerAdapter(getLayoutInflater());
        viewPager.setAdapter(adapter);
    }
}
