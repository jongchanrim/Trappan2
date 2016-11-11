package kr.co.trappan.Item;

import android.graphics.drawable.Drawable;

/**
 * Created by thfad_000 on 2016-11-09.
 */

public class SearchList_item {

    String region;
    String space;
    String star;
    String like;
    String stamp;

    public String getRegion(){ return this.region; }
    public String getSpace(){
        return this.space;
    }
    public String getStar(){
        return this.star;
    }
    public String getLike(){
        return this.like;
    }
    public String getStamp(){
        return this.stamp;
    }

    public SearchList_item( String region, String space, String star, String like, String stamp){

        this.region=region;
        this.space = space;
        this.star = star;
        this.like = like;
        this.stamp = stamp;

    }

}
