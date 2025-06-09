package com.api.envio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.envio.models.Envio;
import com.api.envio.repository.EnvioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnvioService {

    private final EnvioRepository envioRepository;

    public List<Envio> listarEnvios() {
        return envioRepository.findAll();
    }

    public Envio crearEnvio(Envio envio) {
        return envioRepository.save(envio);
    }

    public Envio buscarEnvioPorId(Integer id) {
        return envioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Envío no encontrado con ID: " + id));
    }

    public Envio actualizarEnvio(Integer id, Envio envioActualizado) {
        Envio envioExistente = envioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Envío no encontrado con ID: " + id));

        envioExistente.setFechaEnvio(envioActualizado.getFechaEnvio());
        envioExistente.setDireccionDestino(envioActualizado.getDireccionDestino());
        envioExistente.setEstado(envioActualizado.getEstado());
        envioExistente.setTransportista(envioActualizado.getTransportista());
        envioExistente.setFechaEntregaEstimada(envioActualizado.getFechaEntregaEstimada());

        return envioRepository.save(envioExistente);
    }

    public void eliminarEnvio(Integer id) {
        envioRepository.deleteById(id);
    }
}
