package com.joaoeduardo.bookservice.model;

import java.time.LocalDateTime;

public record DetailsBookDTO(String author, String title, LocalDateTime launchDate, Double price, String currency, String enviroment) {


    public DetailsBookDTO(Book book, String currency, String enviroment) {

        this(book.getAuthor(), book.getTitle(), book.getLaunchDate(), book.getPrice(), currency, enviroment);

    }

}
