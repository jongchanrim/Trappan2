package kr.co.trappan.Item;

import kr.co.trappan.Connector.NameSelector;

/**
 * Created by jongchanrim on 2016. 11. 14..
 */

public class SearchLists_item {
    private String contentId;
    private String title;
    private String areacode;
    private String sigungucode;
    private String firstimage;
    private int stamp;
    private int rate;
    private int like;
    private String sigunguName;

    public SearchLists_item() {
    }

    public SearchLists_item(int like, String contentId, String title, String areacode, String sigungucode, String firstimage, int stamp, int rate) {
        this.like = like;
        this.contentId = contentId;
        this.title = title;
        this.areacode = areacode;
        this.sigungucode = sigungucode;
        this.firstimage = firstimage;
        this.stamp = stamp;
        this.rate = rate;
        setSigunguName();
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getSigunguName() {
        return sigunguName;
    }

    public void setSigunguName() {

        this.sigunguName =NameSelector.selectSigunguName(areacode, sigungucode);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSigungucode() {
        return sigungucode;
    }

    public void setSigungucode(String sigungucode) {
        this.sigungucode = sigungucode;
    }

    public String getFirstimage() {
        return firstimage;
    }

    public void setFirstimage(String firstimage) {

        firstimage = firstimage.replaceAll("\\", "");
        this.firstimage = firstimage;
    }

    public int getStamp() {
        return stamp;
    }

    public void setStamp(int stamp) {
        this.stamp = stamp;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }



}
