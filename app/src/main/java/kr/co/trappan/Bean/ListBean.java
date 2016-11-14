package kr.co.trappan.Bean;

import kr.co.trappan.Util.NameSelector;

/**
 * Created by jongchanrim on 2016. 11. 14..
 */

public class ListBean {
    private String title;
    private String areacode;
    private String sigungucode;
    private String firstimage;
    private int stamp;
    private int rate;
    private int like;
    private String sigunguName;

    public ListBean() {
    }

    public ListBean(String title, String areacode, String sigungucode, String firstimage, int stamp, int rate, int like) {
        this.title = title;
        this.areacode = areacode;
        this.sigungucode = sigungucode;
        this.firstimage = firstimage;
        this.stamp = stamp;
        this.rate = rate;
        this.like = like;
        setSigunguName();
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
