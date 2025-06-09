package com.api.envio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.envio.models.Envio;

public interface EnvioRepository extends JpaRepository<Envio, Integer> {

}
