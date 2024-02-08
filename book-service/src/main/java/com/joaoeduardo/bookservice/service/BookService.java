package com.joaoeduardo.bookservice.service;

import com.joaoeduardo.bookservice.exceptions.BookNotFoundException;
import com.joaoeduardo.bookservice.model.Book;
import com.joaoeduardo.bookservice.model.ConvertCambioDTO;
import com.joaoeduardo.bookservice.model.ConvertedCambioDTO;
import com.joaoeduardo.bookservice.model.DetailsBookDTO;
import com.joaoeduardo.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class BookService {


    @Autowired
    private Environment environment;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioServiceClient cambioServiceClient;



    public DetailsBookDTO getBook(Long id, String currency) {


        var book = bookRepository.getReferenceById(id);
        if (book == null) throw new BookNotFoundException();

        ConvertCambioDTO cambioDTO = new ConvertCambioDTO(book.getPrice(), "USD", currency);

        System.out.println("aaaaaaaaaaaaaaa"+cambioDTO);

        var convertedCambioDTO = cambioServiceClient.convertCambio(cambioDTO);

        System.out.println("aaaaaaaaaaaaaaa"+convertedCambioDTO);

        book.setPrice(convertedCambioDTO.convertedValue());

        var bookServicePort = "Book Service port: "+environment.getProperty("local.server.port");
        var cambioServicePort = "Cambio Service port: "+convertedCambioDTO.enviroment();

        var detailsBookDTO = new DetailsBookDTO(book, currency, bookServicePort + cambioServicePort);
        return detailsBookDTO;

    }




}
