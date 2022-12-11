package com.masai.model;

public class Book {

	private int Book_id;
	private String name;
	private String author;
	private int price;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int book_id, String name, String author, int price) {
		super();
		Book_id = book_id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public int getBook_id() {
		return Book_id;
	}

	public void setBook_id(int book_id) {
		Book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [Book_id=" + Book_id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}

}
