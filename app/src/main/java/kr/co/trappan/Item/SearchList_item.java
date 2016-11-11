package kr.co.trappan.Item;

import android.graphics.drawable.Drawable;

/**
 * Created by thfad_000 on 2016-11-09.
 */

public class SearchList_item {

    int image;
    String region;
    String star;
    String like;
    String stamp;

    public int getImage(){
        return this.image;
    }
    public String getRegion(){ return this.region; }
    public String getStar(){
        return this.star;
    }
    public String getLike(){
        return this.like;
    }
    public String getStamp(){
        return this.stamp;
    }

    public SearchList_item( int image, String region,String star, String like, String stamp){

        this.image = image;
        this.region=region;
        this.star = star;
        this.like = like;
        this.stamp = stamp;

    }

}
