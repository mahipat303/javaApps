package com.masai.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Book;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/bookservice")
public class LibraryController {

	private List<Book> books = new ArrayList<>();

	@PostConstruct
	public void setBooks() {
		books.add(new Book(1, "dorimon", "nobita", "disney", "cartoon", 20, 10, "no12"));
		books.add(new Book(2, "ninja", "hathodi", "nick", "cartoon", 30, 15, "ha12"));
		books.add(new Book(3, "power ranger", "spd", "nick", "skifi", 30, 30, "po14"));
		books.add(new Book(4, "dragon", "lenister", "cartoon network", "fixnal", 60, 100, "dr22"));
		books.add(new Book(5, "game of thrown", "jefri", "HBO", "fantasy drama", 100, 1000, "ga55"));
	}

//	http://localhost:8888/bookservice/books
	@GetMapping("/books")
	public List<Book> getBookshandler() {
		return books;
	}

//	http://localhost:8888/bookservice/books/<id>
	@GetMapping("/books/{id}")
	public Book getBookhandler(@PathVariable("id") int book_id) {

		for (Book book : books) {
			if (book.getBook_id() == book_id)
				return book;
		}

		return null;
	}

//	http://localhost:8888/bookservice/books
	@PostMapping("/books")
	public String createBook(@RequestBody Book book) {

		books.add(book);

		return "book created successfuly " + "\n" + "your book :- " + book;

	}

//	http://localhost:8888/bookservice/books/<id>
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable("id") int book_id) {

		books.removeIf(book -> book.getBook_id() == book_id);

		return "book deleted successfuly";

	}

//	 http://localhost:8888/bookservice/books/<id>
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable("id") int book_id, @RequestBody Book book) {

		Book b = null;
		for (Book bk : books) {
			if (bk.getBook_id() == book_id) {

				bk.setName(book.getName());
				bk.setAuthor(book.getAuthor());
				bk.setAuthor_no(book.getAuthor_no());
				bk.setCategory(book.getCategory());
				bk.setPages(book.getPages());
				bk.setPrice(book.getPrice());
				bk.setPublication(book.getPublication());
				return bk;

			}
		}

		return b;

	}

//	 http://localhost:8888/bookservice/updateprice/<id>?price=500
	@PatchMapping("/updateprice/{id}")
	public Book updateBookPrice(@PathVariable("id") int book_id, @RequestParam("price") int price) {

		Book b = null;
		for (Book book : books) {
			if (book.getBook_id() == book_id) {
				book.setPrice(price);
				b = book;
			}
		}

		return b;

	}

}
