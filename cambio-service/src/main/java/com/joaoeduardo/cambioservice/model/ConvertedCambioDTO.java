package com.joaoeduardo.cambioservice.model;

import java.math.BigDecimal;

public record ConvertedCambioDTO(String from, String to, Double conversionFactor, Double convertedValue, String enviroment) {
}
