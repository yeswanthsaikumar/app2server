package com.nagarro.serverrestapp.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private int bookcode;
	private String bookname;
	private String author;
	private Date dateadded;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book() {
		
	}

	public Book(String bookname, int bookcode, String author, Date dateadded) {
	
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.author = author;
		this.dateadded = dateadded;
	}

	public int getBookcode() {
		return bookcode;
	}

	public void setBookcode(int bookcode) {
		this.bookcode = bookcode;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDateadded() {
		return dateadded;
	}

	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}

	@Override
	public String toString() {
		return "books [bookcode=" + bookcode + ", bookname=" + bookname + ", author=" + author + ", dateadded="
				+ dateadded + "]";
	}

}
