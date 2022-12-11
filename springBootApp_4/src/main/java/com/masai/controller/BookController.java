package com.masai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.BookNotFoundException;
import com.masai.model.Book;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/bookservice")
public class BookController {

	private List<Book> books = new ArrayList<>();

	@PostConstruct
	public void setBooks() {
		books.add(new Book(1, "dorimon", "nobita", 20));
		books.add(new Book(2, "ninja", "hathodi", 30));
		books.add(new Book(3, "power ranger", "spd", 30));
		books.add(new Book(4, "dragon", "lenister", 60));
		books.add(new Book(5, "game of thrown", "jefri", 100));
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBookshandler() {

		if (books.size() <= 0) {
			throw new BookNotFoundException("No book available in DataBase");
		}
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);

	}

//	http://localhost:8888/bookservice/books/<id>
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookhandler(@PathVariable("id") int book_id) {

		for (Book book : books) {
			if (book.getBook_id() == book_id)
				return new ResponseEntity<Book>(book, HttpStatus.OK);
		}

		throw new BookNotFoundException("No book available with ID :" + book_id);
	}

//	http://localhost:8888/bookservice/books
	@PostMapping("/books")
	public ResponseEntity<String> createBook(@RequestBody Book book) {

		for (Book b : books) {
			if (b.getBook_id() == book.getBook_id())
				throw new BookNotFoundException("book already present in DataBase with same ID");
		}
		books.add(book);

		String message = "book created successfuly " + "\n" + "your book :- " + book;
		return new ResponseEntity<String>(message, HttpStatus.CREATED);

	}

//	http://localhost:8888/bookservice/books/<id>
	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") int book_id) {

		boolean flag = books.removeIf(book -> book.getBook_id() == book_id);

		if (flag) {
			String message = "book deleted successfuly";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}

		else
			throw new BookNotFoundException("No book available with ID :" + book_id);

	}

//	 http://localhost:8888/bookservice/books/<id>
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") int book_id, @RequestBody Book book) {

		for (Book bk : books) {
			if (bk.getBook_id() == book_id) {
				bk.setName(book.getName());
				bk.setAuthor(book.getAuthor());
				bk.setPrice(book.getPrice());
				return new ResponseEntity<Book>(bk, HttpStatus.OK);
			}
		}

		throw new BookNotFoundException("No book available with ID :" + book_id);

	}

}
