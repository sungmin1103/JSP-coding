package com.mvc.notice.vo;

public class NoticeVO {
	private int noticeNo;
	private String title;
	private String content;
	private String writer;
	private String writeday;
	private int viewCount;
	private String isImportant;
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getIsImportant() {
		return isImportant;
	}
	public void setIsImportant(String isImportant) {
		this.isImportant = isImportant;
	}
	@Override
	public String toString() {
		return "NoticeVO [noticeNo=" + noticeNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", writeday=" + writeday + ", viewCount=" + viewCount + ", isImportant=" + isImportant + "]";
	}
	
	
	
	

	
}
	

