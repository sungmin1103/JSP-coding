package com.book;

public class BookVO {
	private String title;
	private String author;
	private String publisher;
	
	public BookVO() {
		
	}
	
	public BookVO(String title, String author, String Publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
	}
}
