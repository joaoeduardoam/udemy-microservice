package com.joaoeduardo.bookservice.service;

import com.joaoeduardo.bookservice.model.ConvertCambioDTO;
import com.joaoeduardo.bookservice.model.ConvertedCambioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cambio-service", url = "http://localhost:8000/cambio-service")
public interface CambioServiceClient {

    @PutMapping
    ConvertedCambioDTO convertCambio(@RequestBody ConvertCambioDTO dto);

//    @PostMapping(value = "/cambio-service")
//    ConvertedCambioDTO saveCambio(@RequestBody ConvertCambioDTO dto);

}
