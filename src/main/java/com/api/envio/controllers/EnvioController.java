package com.api.envio.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.envio.models.Envio;
import com.api.envio.service.EnvioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/envios")
@RequiredArgsConstructor
public class EnvioController {

    private final EnvioService envioService;

    @GetMapping
    public List<Envio> getAll() {
        return envioService.listarEnvios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            Envio envio = envioService.buscarEnvioPorId(id);
            return ResponseEntity.ok(envio);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(Map.of("mensaje", ex.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<Envio> crear(@RequestBody Envio nuevoEnvio) {
        Envio creado = envioService.crearEnvio(nuevoEnvio);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Envio> actualizar(@PathVariable Integer id, @RequestBody Envio envioActualizado) {
        Envio actualizado = envioService.actualizarEnvio(id, envioActualizado);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        envioService.eliminarEnvio(id);
        return ResponseEntity.noContent().build();
    }
}
