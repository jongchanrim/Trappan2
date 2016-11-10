package kr.co.trappan.Item;

/**
 * Created by thfad_000 on 2016-10-05.
 */
public class Horizontal_item {
    int image;
    String title;


    public  int getImage(){
        return this.image;
    }
    public String getTitle(){
        return this.title;
    }


    public Horizontal_item(int image, String title){
        this.image=image;
        this.title=title;

    }
}