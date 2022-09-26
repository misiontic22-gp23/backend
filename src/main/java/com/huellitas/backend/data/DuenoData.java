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
public class DuenoData {
    private int id;
    private double identificacion;
    private String nombre;
    private String apellido;
    private double telefono;
    private MascotaData Mascota;
}
