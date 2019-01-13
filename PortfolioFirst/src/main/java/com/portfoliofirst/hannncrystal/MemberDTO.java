package com.portfoliofirst.hannncrystal;

public class MemberDTO {

	int member_IDX;
	String member_id;
	String member_pw;
	String member_name;
	String member_mobile;
	String member_email;
	String member_date;
	int member_available;
	
	public int getMember_IDX() {
		return member_IDX;
	}
	public void setMember_IDX(int member_IDX) {
		this.member_IDX = member_IDX;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_mobile() {
		return member_mobile;
	}
	public void setMember_mobile(String member_mobile) {
		this.member_mobile = member_mobile;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_date() {
		return member_date;
	}
	public void setMember_date(String member_date) {
		this.member_date = member_date;
	}
	public int getMember_available() {
		return member_available;
	}
	public void setMember_available(int member_available) {
		this.member_available = member_available;
	}
	@Override
	public String toString() {
		return "MemberDTO [member_IDX=" + member_IDX + ", member_id=" + member_id + ", member_pw=" + member_pw
				+ ", member_name=" + member_name + ", member_mobile=" + member_mobile + ", member_email=" + member_email
				+ ", member_date=" + member_date + ", member_available=" + member_available + "]";
	}
	
	
}
