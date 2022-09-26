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
public class MascotaData {
    private int id;
    private String Mascota;
    private String Color;
    private String Raza;
}
