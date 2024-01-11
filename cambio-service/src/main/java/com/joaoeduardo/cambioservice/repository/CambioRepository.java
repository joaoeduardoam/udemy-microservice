package com.joaoeduardo.cambioservice.repository;

import com.joaoeduardo.cambioservice.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

    public Cambio findByFromAndTo(String from, String to);

}
