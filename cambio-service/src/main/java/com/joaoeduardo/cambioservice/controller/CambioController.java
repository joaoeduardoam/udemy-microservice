package com.joaoeduardo.cambioservice.controller;

import com.joaoeduardo.cambioservice.model.Cambio;
import com.joaoeduardo.cambioservice.model.ConvertCambioDTO;
import com.joaoeduardo.cambioservice.service.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("cambio-service")
public class CambioController {


    @Autowired
    private CambioService cambioService;
    @GetMapping//(value = "/{amount}/{from}/{to}")
    public Cambio convertCambio(@RequestBody ConvertCambioDTO dto){



        var cambio = cambioService.getCambio(dto.amount(), dto.from(), dto.to());


        return cambio;


    }

}
