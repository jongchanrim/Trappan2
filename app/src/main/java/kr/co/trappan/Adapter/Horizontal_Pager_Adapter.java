package kr.co.trappan.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
                Bitmap bigPictureBitmap  = BitmapFactory.decodeResource(view.getResources(), R.drawable.slide01);
                bigPictureBitmap = Bitmap.createScaledBitmap(bigPictureBitmap, 400, 300, true);
                img.setImageBitmap(bigPictureBitmap);
                break;
            case 1:
                Bitmap bigPictureBitmap2  = BitmapFactory.decodeResource(view.getResources(), R.drawable.slide02);
                bigPictureBitmap2 = Bitmap.createScaledBitmap(bigPictureBitmap2, 400, 300, true);
                img.setImageBitmap(bigPictureBitmap2);
                break;
            case 2:
                Bitmap bigPictureBitmap3  = BitmapFactory.decodeResource(view.getResources(), R.drawable.slide01);
                bigPictureBitmap3 = Bitmap.createScaledBitmap(bigPictureBitmap3, 400, 300, true);
                img.setImageBitmap(bigPictureBitmap3);
                break;
            case 3:
                Bitmap bigPictureBitmap4  = BitmapFactory.decodeResource(view.getResources(), R.drawable.slide01);
                bigPictureBitmap4 = Bitmap.createScaledBitmap(bigPictureBitmap4, 400, 300, true);
                img.setImageBitmap(bigPictureBitmap4);
                break;
            case 4:
                Bitmap bigPictureBitmap5  = BitmapFactory.decodeResource(view.getResources(), R.drawable.slide01);
                bigPictureBitmap5 = Bitmap.createScaledBitmap(bigPictureBitmap5, 400, 300, true);
                img.setImageBitmap(bigPictureBitmap5);
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
