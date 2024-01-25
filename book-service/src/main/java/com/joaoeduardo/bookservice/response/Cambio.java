package com.joaoeduardo.bookservice.response;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cambio implements Serializable {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;



}
