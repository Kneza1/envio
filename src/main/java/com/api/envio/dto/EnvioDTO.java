package com.api.envio.dto;

import lombok.Data;

@Data
public class EnvioDTO {
    private String fechaEnvio;
    private String direccionDestino;
    private String estado;
    private String transportista;
    private String fechaEntregaEstimada;
}
