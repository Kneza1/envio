package com.api.envio.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "envio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_envio")
    private Integer id;

    private String fechaEnvio;
    private String direccionDestino;
    private String estado;
    private String transportista;
    private String fechaEntregaEstimada;
}
