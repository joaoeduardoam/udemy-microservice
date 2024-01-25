package com.joaoeduardo.bookservice.controller;

import com.joaoeduardo.bookservice.model.Book;
import com.joaoeduardo.bookservice.model.BookDTO;
import com.joaoeduardo.bookservice.model.ConvertCambioDTO;
import com.joaoeduardo.bookservice.model.DetailsBookDTO;
import com.joaoeduardo.bookservice.service.BookService;
import com.joaoeduardo.bookservice.service.CambioServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private BookService bookService;


    @PutMapping
    public DetailsBookDTO getBook(@RequestBody BookDTO dto){

       var detailsBookDTO = bookService.getBook(dto.id(), dto.currency());

       return detailsBookDTO;


    }

    @GetMapping
    public void workaround(){
    }

}
