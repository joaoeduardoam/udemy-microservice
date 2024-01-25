package com.joaoeduardo.bookservice.model;

import java.math.BigDecimal;

public record ConvertCambioDTO(Double amount, String from, String to) {
}
