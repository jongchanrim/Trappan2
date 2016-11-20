package kr.co.trappan.Bean;

import java.sql.Date;

//DTO(Data Transfer Object) = VO(Value Object) = JavaBean
public class Member {

	private String id;
	private String email; 
	private String password;
	private String name;
	private String back_img;
	private String pro_img;
	private String intro;
	private String isfollow;


	public String getIsfollow() {
		return isfollow;
	}

	public void setIsfollow(String isfollow) {
		this.isfollow = isfollow;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBack_img() {
		return back_img;
	}
	public void setBack_img(String back_img) {
		this.back_img = back_img;
	}
	public String getPro_img() {
		return pro_img;
	}
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro_img) {
		this.intro = intro_img;
	}


	public Member (){

	}
	public Member(String id, String email, String password, String name, String back_img, String pro_img, String intro)
	{
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.back_img = back_img;
		this.pro_img = pro_img;
		this.intro = intro;
	}
	
}
