package com.joaoeduardo.bookservice.service;

import com.joaoeduardo.bookservice.model.ConvertCambioDTO;
import com.joaoeduardo.bookservice.model.ConvertedCambioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cambio-service")
public interface CambioServiceClient {

    @PutMapping(value = "/cambio-service")
    ConvertedCambioDTO convertCambio(@RequestBody ConvertCambioDTO dto);


}
