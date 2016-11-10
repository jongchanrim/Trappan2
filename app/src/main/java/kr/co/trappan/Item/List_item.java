package kr.co.trappan.Item;

/**
 * Created by thfad_000 on 2016-11-08.
 */

import android.graphics.drawable.Drawable;

public class List_item {

    int image;
    String title ;
    String date;
    String desc;

    public int getImage(){
        return this.image;
    }
    public String getTitle(){ return this.title; }
    public String getDate(){
        return this.date;
    }
    public String getDesc(){
        return this.desc;
    }

    public List_item(int image, String title, String date, String desc){
        this.image=image;
        this.title=title;
        this.date = date;
        this.desc = desc;

    }

}
