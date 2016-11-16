package kr.co.trappan.Item;

/**
 * Created by jongchanrim on 2016. 11. 14..
 */

public class DetailInfo_item {
    private String contentid;
    private String contenttypeid;
    private String title;
    private String addr1;
    private String addr2;
    private String areacode;
    private String cat1;
    private String cat2;
    private String cat3;
    private String firstimage;
    private String firstimage2;
    private String mlevel;
    private String overview;
    private float mapx;
    private float mapy;
    private int rate;
    private int stamp;
    private int like;
    private String areaName;
    private String sigunguName;

    public DetailInfo_item() {
    }

    public DetailInfo_item(String contentid, String contenttypeid, String title, String addr1, String addr2, String areacode, String cat1, String cat2, String cat3, String firstimage, String firstimage2, String mlevel, String overview, String mapx, String mapy, int rate, int stamp, int like) {
        this.contentid = contentid;
        this.contenttypeid = contenttypeid;
        this.title = title;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.areacode = areacode;
        this.cat1 = cat1;
        this.cat2 = cat2;
        this.cat3 = cat3;
        this.firstimage = firstimage;
        this.firstimage2 = firstimage2;
        this.mlevel = mlevel;
        this.overview = overview;
        this.mapx = Float.parseFloat(mapx);
        this.mapy = Float.parseFloat(mapy);
        this.rate = rate;
        this.stamp = stamp;
        this.like = like;
    }

    public String getContentid() {
        return contentid;
    }

    public void setContentid(String contentid) {
        this.contentid = contentid;
    }

    public String getContenttypeid() {
        return contenttypeid;
    }

    public void setContenttypeid(String contenttypeid) {
        this.contenttypeid = contenttypeid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public String getCat3() {
        return cat3;
    }

    public void setCat3(String cat3) {
        this.cat3 = cat3;
    }

    public String getFirstimage() {
        return firstimage;
    }

    public void setFirstimage(String firstimage) {
        this.firstimage = firstimage;
    }

    public String getFirstimage2() {
        return firstimage2;
    }

    public void setFirstimage2(String firstimage2) {
        this.firstimage2 = firstimage2;
    }

    public String getMlevel() {
        return mlevel;
    }

    public void setMlevel(String mlevel) {
        this.mlevel = mlevel;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getMapx() {
        return mapx;
    }

    public void setMapx(String mapx) {
        this.mapx = Float.parseFloat(mapx);
    }

    public float getMapy() {
        return mapy;
    }

    public void setMapy(String mapy) {
        this.mapy = Float.parseFloat(mapy);
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getStamp() {
        return stamp;
    }

    public void setStamp(int stamp) {
        this.stamp = stamp;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
