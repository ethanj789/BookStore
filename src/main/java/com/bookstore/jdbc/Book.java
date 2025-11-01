package com.bookstore.jdbc;

public class Book {
	private String author;
	private String title;
	private int id;
	private double price;
	public Book(String author, String title, int id, double price) {
		this.author = author;
		this.title = title;
		this.id = id;
		this.price = price;
	}
	public Book(String author, String title, double price) {
		this.author = author;
		this.title = title;
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
