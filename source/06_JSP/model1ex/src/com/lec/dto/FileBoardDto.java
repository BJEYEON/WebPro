package com.lec.dto;// 답글

import java.sql.Timestamp;

// FileBoard table 필드 + cname, cemail
public class FileBoardDto {
	private int fid; //글번호
	private String cid;//글쓴이 아이디
	private String ftitle;
	private String fcontent;
	private String filename;
	private int fhit;
	private String fpw;
	private int fgroup;
	private int fstep;
	private int findent;
	private String fip;
	private String cname;
	private String cemail;
	private Timestamp fdate;
	public FileBoardDto() {}
	public FileBoardDto(int fid, String cid, String ftitle, String fcontent, String filename, int fhit, String fpw,
			int fgroup, int fstep, int findent, String fip, String cname, String cemail, Timestamp fdate) {
		super();
		this.fid = fid;
		this.cid = cid;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.filename = filename;
		this.fhit = fhit;
		this.fpw = fpw;
		this.fgroup = fgroup;
		this.fstep = fstep;
		this.findent = findent;
		this.fip = fip;
		this.cname = cname;
		this.cemail = cemail;
		this.fdate = fdate;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFhit() {
		return fhit;
	}
	public void setFhit(int fhit) {
		this.fhit = fhit;
	}
	public String getFpw() {
		return fpw;
	}
	public void setFpw(String fpw) {
		this.fpw = fpw;
	}
	public int getFgroup() {
		return fgroup;
	}
	public void setFgroup(int fgroup) {
		this.fgroup = fgroup;
	}
	public int getFstep() {
		return fstep;
	}
	public void setFstep(int fstep) {
		this.fstep = fstep;
	}
	public int getFindent() {
		return findent;
	}
	public void setFindent(int findent) {
		this.findent = findent;
	}
	public String getFip() {
		return fip;
	}
	public void setFip(String fip) {
		this.fip = fip;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public Timestamp getFdate() {
		return fdate;
	}
	public void setFdate(Timestamp Fdate) {
		this.fdate = fdate;
	}
	@Override
	public String toString() {
		return "FileBoardDto [fid=" + fid + ", cid=" + cid + ", ftitle=" + ftitle + ", fcontent=" + fcontent
				+ ", filename=" + filename + ", fhit=" + fhit + ", fpw=" + fpw + ", fgroup=" + fgroup + ", fstep="
				+ fstep + ", findent=" + findent + ", fip=" + fip + ", cname=" + cname + ", cemail=" + cemail
				+ ", fdate=" + fdate + "]";
	}
	
}
