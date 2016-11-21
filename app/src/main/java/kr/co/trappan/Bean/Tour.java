package kr.co.trappan.Bean;

/**
 * Created by jongchanrim on 2016. 11. 14..
 */

public class Tour {
    private String contentid;
    private String contenttypeid;
    private String title;
    private String addr1;
    private String addr2;
    private String areacode;
    private String cat2;
    private String firstimage;
    private String mlevel;
    private String overview;
    private float mapx;
    private float mapy;
    private Double rate=0.0;
    private int stamp=0;
    private int like=0;
    private String sigungucode;
    private String areaName;
    private String sigunguName;

    public Tour() {

    }

    public Tour(String addr1, String addr2, String areacode, String cat2, String contentid, String contenttypeid, String firstimage, int like, String mapx, String mapy, String mlevel, String overview, double rate, String sigungucode, int stamp, String title) {
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.areacode = areacode;
        this.cat2 = cat2;
        this.contentid = contentid;
        this.contenttypeid = contenttypeid;
        this.firstimage = firstimage;
        this.like = like;
        this.mapx = Float.parseFloat(mapx);
        this.mapy = Float.parseFloat(mapy);
        this.mlevel = mlevel;
        this.overview = overview;
        this.rate = rate;
        this.sigungucode = sigungucode;
        this.stamp = stamp;
        this.title = title;
    }



    public String getSigungucode() {
        return sigungucode;
    }

    public void setSigungucode(String sigungucode) {
        this.sigungucode = sigungucode;
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



    public String getCat2() {
        return cat2;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setMapx(float mapx) {
        this.mapx = mapx;
    }

    public void setMapy(float mapy) {
        this.mapy = mapy;
    }

    public String getSigunguName() {
        return sigunguName;
    }

    public void setSigunguName(String sigunguName) {
        this.sigunguName = sigunguName;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;

    }



    public String getFirstimage() {
        return firstimage;
    }

    public void setFirstimage(String firstimage) {
        this.firstimage = firstimage;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
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
