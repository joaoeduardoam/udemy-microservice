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

        var cambio = cambioServiceClient.convertCambio(cambioDTO);

//        HashMap<String, String> params = new HashMap<>();
//        params.put("amount","10");
//        params.put("from","USD");
//        params.put("to",currency);

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
//        map.add("amount","10");
//        map.add("from","USD");
//        map.add("to",currency);

//        HttpEntity<ConvertCambioDTO> request = new HttpEntity<ConvertCambioDTO>(
//                new ConvertCambioDTO(10d, "USD",currency));
//
//        var response = new RestTemplate().getForEntity("http://localhost:8000/cambio-service", ConvertedCambioDTO.class, request);
//
//        var cambio = response.getBody();

        System.out.println("aaaaaaaaaaaaaaa"+cambio);

        book.setPrice(cambio.convertedValue());

        var port = environment.getProperty("local.server.port");
        var detailsBookDTO = new DetailsBookDTO(book, currency, port + " FEIGN");
        return detailsBookDTO;

    }

    public Double getPricebyId(Long id) {

        var book = bookRepository.getReferenceById(id);

        return book.getPrice();

    }



}
