package com.huellitas.backend.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaData {
    private int id;
    private int temperatura;
    private int frecuenciaCardiaca;
    private int frecuenciaRespiratoria;
    private String estado;
    private String recomendaciones;
    private ClinicaData historiaClinica;
    private VetData veterinario;

}
