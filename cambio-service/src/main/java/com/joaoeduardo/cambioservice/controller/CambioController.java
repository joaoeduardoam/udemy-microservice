package com.joaoeduardo.cambioservice.controller;

import com.joaoeduardo.cambioservice.model.ConvertCambioDTO;
import com.joaoeduardo.cambioservice.model.ConvertedCambioDTO;
import com.joaoeduardo.cambioservice.service.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("cambio-service")
public class CambioController {


    @Autowired
    private CambioService cambioService;
    @PutMapping
    public ConvertedCambioDTO convertCambio(@RequestBody ConvertCambioDTO dto){

        var convertedCambioDTO = cambioService.getCambio(dto.amount(), dto.from(), dto.to());
        return convertedCambioDTO;

    }

}
