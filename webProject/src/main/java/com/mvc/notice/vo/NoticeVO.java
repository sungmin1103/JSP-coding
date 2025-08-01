package com.mvc.notice.vo;

public class NoticeVO {
	private int no;
	private String title;
	private String content;
	private String writer;
	private int writeday;
	private int view_count;

	
	public NoticeVO ( int no, String title, String writer, int writeday, int view_count){
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.writeday = writeday;
		this.view_count = view_count;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
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


	public int getWriteday() {
		return writeday;
	}


	public void setWriteday(int writeday) {
		this.writeday = writeday;
	}


	public int getView_count() {
		return view_count;
	}


	public void setView_count(int view_count) {
		this.view_count = view_count;
	}


	@Override
	public String toString() {
		return "NoticeVO [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", writeday="
				+ writeday + ", view_count=" + view_count + "]";
	}
	
	
	}
	

