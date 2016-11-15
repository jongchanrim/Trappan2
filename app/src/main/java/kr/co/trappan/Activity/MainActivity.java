package kr.co.trappan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;


import kr.co.trappan.Adapter.TabPagerAdapter;
import kr.co.trappan.R;


public class MainActivity extends AppCompatActivity {



    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // Adding Toolbar to the activity


        // Initializing the TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home_icon_selected)); //setIcon
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.search_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.suggest_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.alarm_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.mypage_icon));



        // Initializing ViewPager
        viewPager = (ViewPager) findViewById(R.id.pager);


        // Creating TabPagerAdapter adapter
        TabPagerAdapter  pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Set TabSelectedListener

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                switch(tab.getPosition()){
                    case 0: tab.setIcon(R.drawable.home_icon_selected); break;
                    case 1: tab.setIcon(R.drawable.search_icon_selected); break;
                    case 2: tab.setIcon(R.drawable.suggest_icon_selected); break;
                    case 3: tab.setIcon(R.drawable.alarm_icon_selected); break;
                    case 4: tab.setIcon(R.drawable.mypage_icon_selected); break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch(tab.getPosition()){
                    case 0: tab.setIcon(R.drawable.home_icon); break;
                    case 1: tab.setIcon(R.drawable.search_icon); break;
                    case 2: tab.setIcon(R.drawable.suggest_icon); break;
                    case 3: tab.setIcon(R.drawable.alarm_icon); break;
                    case 4: tab.setIcon(R.drawable.mypage_icon); break;

                }
        }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

      tabLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Snackbar.make(v, v.toString(), Snackbar.LENGTH_LONG)
                      .setAction("Action", null).show();
          }
      });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up login_button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
