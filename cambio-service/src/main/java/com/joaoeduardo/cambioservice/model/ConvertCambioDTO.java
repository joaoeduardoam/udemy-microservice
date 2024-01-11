package com.joaoeduardo.cambioservice.model;

import java.math.BigDecimal;

public record ConvertCambioDTO(BigDecimal amount, String from, String to) {
}
