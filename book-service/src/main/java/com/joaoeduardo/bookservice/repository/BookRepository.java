package com.joaoeduardo.bookservice.repository;

import com.joaoeduardo.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {

}
