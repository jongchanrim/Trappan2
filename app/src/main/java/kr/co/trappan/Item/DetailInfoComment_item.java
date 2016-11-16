package kr.co.trappan.Item;

/**
 * Created by thfad_000 on 2016-11-08.
 */

public class DetailInfoComment_item{

    String id;
    int image;
    String title;
    String content;


    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public DetailInfoComment_item(String id, int image, String title, String content) {
        this.content = content;
        this.id = id;
        this.image = image;
        this.title = title;
    }
}