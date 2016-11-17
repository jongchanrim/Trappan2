package kr.co.trappan.Bean;

/**
 * Created by thfad_000 on 2016-11-08.
 */

public class Comment {

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

    public Comment(String id, int image, String title, String content) {
        this.content = content;
        this.id = id;
        this.image = image;
        this.title = title;
    }
}