package com.joaoeduardo.cambioservice.service;

import com.joaoeduardo.cambioservice.model.Cambio;
import com.joaoeduardo.cambioservice.repository.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CambioService {


    @Autowired
    private Environment environment;
    @Autowired
    public CambioRepository cambioRepository;


    public Cambio getCambio(BigDecimal amount, String from, String to) {


        var cambio = cambioRepository.findByFromAndTo(from, to);
        if (cambio == null) throw new RuntimeException("Unsupported Currency!");
        cambio.setConvertedValue(cambio.getConversionFactor().multiply(amount));

        var port = environment.getProperty("local.server.port");
        cambio.setEnviroment(port);

        return cambio;

    }
}
