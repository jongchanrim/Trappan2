package com.example.jongchanrim.trappan;

/**
 * Created by thfad_000 on 2016-10-05.
 */
public class Recycler_item {
    int image;
    String title;

    int getImage(){
        return this.image;
    }
    String getTitle(){
        return this.title;
    }

    Recycler_item(int image, String title){
        this.image=image;
        this.title=title;
    }
}