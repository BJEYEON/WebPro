package com.lec.friend;

public class FriendDto {
	private int fnum;
	private String fname;
	private String ftel;
	public FriendDto() {}
	public FriendDto(int fnum, String fname, String ftel) {
		super();
		this.fnum = fnum;
		this.fname = fname;
		this.ftel = ftel;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFtel() {
		return ftel;
	}
	public void setFtel(String ftel) {
		this.ftel = ftel;
	}
	@Override
	public String toString() {
		return "FriendDto [fnum=" + fnum + ", fname=" + fname + ", ftel=" + ftel + "]";
	}
}
