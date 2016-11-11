package kr.co.trappan.Fragment;

/**
 * Created by thfad_000 on 2016-10-04.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import kr.co.trappan.Adapter.Horizontal_Pager_Adapter;
import kr.co.trappan.R;


public class TabFragment1 extends Fragment {


   private ViewPager horizontal_viewpager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment1, container, false);

        horizontal_viewpager=(ViewPager)view.findViewById(R.id.horizontal_viewpager);
        Horizontal_Pager_Adapter adapter=new Horizontal_Pager_Adapter(getLayoutInflater(savedInstanceState));
        horizontal_viewpager.setAdapter(adapter);

        return view;
    }
}


