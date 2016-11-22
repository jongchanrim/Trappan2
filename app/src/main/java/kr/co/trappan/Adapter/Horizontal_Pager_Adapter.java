package kr.co.trappan.Adapter;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidquery.AQuery;

import java.util.ArrayList;

import kr.co.trappan.R;

/**
 * Created by SeungJun on 16. 11. 9..
 */
public class Horizontal_Pager_Adapter extends PagerAdapter{

    LayoutInflater inflater;
    ArrayList<String> list;
    AQuery aq;

    public Horizontal_Pager_Adapter(LayoutInflater inflater, ArrayList<String> list) {
        this.inflater=inflater;
        this.list=list;
    }

    @Override
    public int getCount() {
        return 5;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view=null;
        view= inflater.inflate(R.layout.horizontal_viewpager, null);

        aq=new AQuery(view);

        ImageView img= (ImageView)view.findViewById(R.id.viewpager_image);

        switch (position){
            case 0:
                img.setBackgroundResource(R.drawable.main_image1);
                break;
            case 1:
                img.setBackgroundResource(R.drawable.main_image2);
                break;
            case 2:
                img.setBackgroundResource(R.drawable.main_image3);
                break;
            case 3:
                img.setBackgroundResource(R.drawable.main_image4);
                break;
            case 4:
                img.setBackgroundResource(R.drawable.main_image5);
                break;
        }
        //aq.id(img).image(list.get(position));



        container.addView(view);

        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View)object);

    }


    @Override
    public boolean isViewFromObject(View v, Object obj) {
        // TODO Auto-generated method stub
        return v==obj;
    }

}
