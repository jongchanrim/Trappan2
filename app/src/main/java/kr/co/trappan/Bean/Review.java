package kr.co.trappan.Bean;

public class Review {
	private String user_image;
	private int review_id;
	private String id;
	private String contentid;
	private String review_title;
	private String review_content;
	private String img_1;
	private String img_2;
	private String img_3;
	private String img_4;
	private String img_5;
	private String img_6;
	private String c_date;

	public String getUser_image() {
		return user_image.replaceAll("\\", "");
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}

	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getImg_1() {
		return img_1.replaceAll("\\", "");
	}
	public void setImg_1(String img_1) {
		this.img_1 = img_1;
	}
	public String getImg_2() {
		return img_2.replaceAll("\\", "");
	}
	public void setImg_2(String img_2) {
		this.img_2 = img_2;
	}
	public String getImg_3() {
		return img_3.replaceAll("\\", "");
	}
	public void setImg_3(String img_3) {
		this.img_3 = img_3;
	}
	public String getImg_4() {
		return img_4.replaceAll("\\", "");
	}
	public void setImg_4(String img_4) {
		this.img_4 = img_4;
	}
	public String getImg_5() {
		return img_5.replaceAll("\\", "");
	}
	public void setImg_5(String img_5) {
		this.img_5 = img_5;
	}
	public String getImg_6() {
		return img_6.replaceAll("\\", "");
	}
	public void setImg_6(String img_6) {
		this.img_6 = img_6;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public Review() {
	}

	public Review(String id, String img_1, String review_title, String review_content) {
		this.id = id;
		this.img_1 = img_1;
		this.review_content = review_content;
		this.review_title = review_title;
	}

	public Review(String user_image,String id, String c_date, String review_content, String review_title){
		this.id = id;
		this.c_date = c_date;
		this.review_content = review_content;
		this.review_title = review_title;
		this.user_image = user_image;
	}
}
