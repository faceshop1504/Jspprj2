package ksh.jspprj.model;

import java.sql.Date;



public class NoticeFile {
	private String noticeCode;
	private String src;
	private Date regdate;
	private String code;
	private String description;
	
	
	
	public String getNoticeCode() {
		return noticeCode;
	}
	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
