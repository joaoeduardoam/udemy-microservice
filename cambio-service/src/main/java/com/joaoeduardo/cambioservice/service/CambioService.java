package com.joaoeduardo.cambioservice.service;

import com.joaoeduardo.cambioservice.exceptions.UnsupportedCurrencyException;
import com.joaoeduardo.cambioservice.model.ConvertedCambioDTO;
import com.joaoeduardo.cambioservice.repository.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CambioService {


    @Autowired
    private Environment environment;
    @Autowired
    public CambioRepository cambioRepository;


    public ConvertedCambioDTO getCambio(Double amount, String from, String to) {


        var cambio = cambioRepository.findByFromAndTo(from, to);
        if (cambio == null) throw new UnsupportedCurrencyException("Unsupported Currency!");

        var convertedValue = cambio.getConversionFactor()*amount;
        BigDecimal convertedValueScaled = BigDecimal.valueOf(convertedValue).setScale(2, RoundingMode.CEILING);
        var port = environment.getProperty("local.server.port");

        return new ConvertedCambioDTO(from, to, cambio.getConversionFactor(), convertedValueScaled, port);

    }
}
