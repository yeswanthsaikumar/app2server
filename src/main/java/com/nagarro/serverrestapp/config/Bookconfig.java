package com.nagarro.serverrestapp.config;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.serverrestapp.model.Book;
import com.nagarro.serverrestapp.repository.BookRepository;

@Configuration
public class Bookconfig {

	@Bean
	CommandLineRunner commandLineRunner(BookRepository booksRepository) {
		return args -> {
			 Book atomichabits = new Book("atomic habits", 345, "james clear",Date.valueOf("2014-07-08") );
			 Book personal = new Book("Personal diary", 4543, "yesh",Date.valueOf("2004-08-08") );

			 booksRepository.saveAll(List.of(atomichabits,personal));
		};
	}
}
