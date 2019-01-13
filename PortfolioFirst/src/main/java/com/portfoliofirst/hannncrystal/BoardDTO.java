package com.portfoliofirst.hannncrystal;

public class BoardDTO {

	int board_IDX;
	String board_title;
	String board_content;
	int board_hit;
	int board_group;
	int board_depth;
	int board_step;
	String board_date;
	int member_IDX;
	
	public int getBoard_IDX() {
		return board_IDX;
	}
	public void setBoard_IDX(int board_IDX) {
		this.board_IDX = board_IDX;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public int getBoard_group() {
		return board_group;
	}
	public void setBoard_group(int board_group) {
		this.board_group = board_group;
	}
	public int getBoard_depth() {
		return board_depth;
	}
	public void setBoard_depth(int board_depth) {
		this.board_depth = board_depth;
	}
	public int getBoard_step() {
		return board_step;
	}
	public void setBoard_step(int board_step) {
		this.board_step = board_step;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public int getMember_IDX() {
		return member_IDX;
	}
	public void setMember_IDX(int member_IDX) {
		this.member_IDX = member_IDX;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [board_IDX=" + board_IDX + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_hit=" + board_hit + ", board_group=" + board_group + ", board_depth=" + board_depth
				+ ", board_step=" + board_step + ", board_date=" + board_date + ", member_IDX=" + member_IDX + "]";
	}
	
}
