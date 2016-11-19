package kr.co.trappan.Bean;

public class Comment {
	private int comment_id;
	private int review_id;
	private int comment_count;
	private String id;
	private String comment_content;
	private String c_date;
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
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

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public Comment ()
	{

	}

	public Comment (int comment_id,int review_id, int comment_count, String id, String comment_content, String c_date ){

		this.comment_id = comment_id;
		this.review_id = review_id;
		this.comment_count = comment_count;
		this.id = id;
		this.comment_content = comment_content;
		this.c_date = c_date;

	}
	
	

}
