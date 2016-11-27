package kr.co.trappan.Adapter;

import android.support.v4.view.PagerAdapter;
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
public class ReviewPagerAdapter extends PagerAdapter{

    LayoutInflater inflater;
    ArrayList<String> list;
    AQuery aq;
    public ReviewPagerAdapter(LayoutInflater inflater,ArrayList<String> list) {
        this.inflater=inflater;
        this.list=list;
    }

    public void setList(ArrayList<String> list){
        this.list = list;
    }

    @Override
    public int getCount() {
        if(list ==null)
            return 0;
        else
            return list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = null;
        view = inflater.inflate(R.layout.horizontal_viewpager, null);

        aq=new AQuery(view);

        ImageView img = (ImageView) view.findViewById(R.id.viewpager_image);

        aq.id(img).image(list.get(position));

        container.addView(view);

            return view;
        }


        @Override
        public void destroyItem (ViewGroup container,int position, Object object){

            container.removeView((View) object);

        }


        @Override
        public boolean isViewFromObject (View v, Object obj){
            // TODO Auto-generated method stub
            return v == obj;
        }

}
