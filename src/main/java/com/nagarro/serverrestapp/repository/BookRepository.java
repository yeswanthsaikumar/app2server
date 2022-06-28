package com.nagarro.serverrestapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.serverrestapp.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	Book findByBookcode(int bookcode);

}
