package kr.co.trappan.Item;

/**
 * Created by thfad_000 on 2016-10-05.
 */
public class Horizontal_item {
    int image;
    String title;
    String code;

    public  int getImage(){
        return this.image;
    }
    public String getTitle(){
        return this.title;
    }
    public String getCode(){ return this.code; }

    public void setImage(int imageItem) {image =imageItem;}

    public Horizontal_item(int image, String title, String code){
        this.image=image;
        this.title=title;
        this.code = code;

    }
}