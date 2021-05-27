package com.gl.librarymanagement.model;

public class Library {

	private String title;
	private String author;
	private int price;
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Library [title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
}
