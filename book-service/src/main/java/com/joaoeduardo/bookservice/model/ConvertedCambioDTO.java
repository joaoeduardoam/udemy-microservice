package com.joaoeduardo.bookservice.model;

public record ConvertedCambioDTO(String from, String to, Double conversionFactor, Double convertedValue, String enviroment) {
}
