package kr.co.trappan.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import kr.co.trappan.R;

/**
 * Created by SeungJun on 16. 11. 9..
 */
public class Horizontal_Pager_Adapter extends PagerAdapter{

    LayoutInflater inflater;

    public Horizontal_Pager_Adapter(LayoutInflater inflater) {
        this.inflater=inflater;
    }


    @Override
    public int getCount() {
        return 10;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view=null;
        view= inflater.inflate(R.layout.horizontal_viewpager, null);

        ImageView img= (ImageView)view.findViewById(R.id.viewpager_image);

        if (position==0){
            img.setBackgroundResource(R.drawable.a);
        }else if(position==1){
            img.setBackgroundResource(R.drawable.seoul);
        }else if(position==2){
            img.setBackgroundResource(R.drawable.back_button);
        }else if(position==3){
            img.setBackgroundResource(R.drawable.detail_icon_01_02);
        }else if(position==4){
            img.setBackgroundResource(R.drawable.detail_icon_04_a0203);
        }else if(position==5){
            img.setBackgroundResource(R.drawable.seoul);
        }else if(position==6){
            img.setBackgroundResource(R.drawable.seoul);
        }
        //img.setImageResource(R.drawable.a);

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
