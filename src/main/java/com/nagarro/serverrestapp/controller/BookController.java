package com.nagarro.serverrestapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.serverrestapp.exception.ResourceNotFoundException;
import com.nagarro.serverrestapp.model.Book;
import com.nagarro.serverrestapp.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

	
	private BookRepository bookrepository;
	public BookController(BookRepository bookrepository) {
		this.bookrepository = bookrepository;
	}

	// get all books
	@GetMapping
	public List<Book> getAllBooks() {
		return this.bookrepository.findAll();
	}

	// get book by id
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") long id) {
		return this.bookrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id :" + id));
	}

	@GetMapping("/book/{code}")
	public Book getBookByCode(@PathVariable("code") int bookcode) {
		return this.bookrepository.findByBookcode(bookcode);
				
	}

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return this.bookrepository.save(book);
	}
	
	// update book
	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") long bookId) {
		Book existingBook = this.bookrepository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id :" + bookId));
		existingBook.setAuthor(book.getAuthor());
		existingBook.setBookname(book.getBookname());
		existingBook.setDateadded(book.getDateadded());
		return this.bookrepository.save(existingBook);
	}
	
	// delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") long bookId) {
		Book existingBook = this.bookrepository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id :" + bookId));
		this.bookrepository.delete(existingBook);
		return ResponseEntity.ok().build();
	}
}