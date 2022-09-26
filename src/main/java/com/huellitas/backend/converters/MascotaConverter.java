package com.huellitas.backend.converters;

import com.huellitas.backend.data.MascotaData;
import com.huellitas.backend.entities.Mascota;

public class MascotaConverter extends Converter<Mascota, MascotaData> {


    @Override
    public Mascota toEntity(MascotaData object) {
        return object == null ? null : Mascota.builder()
            .id(object.getId())
            .Mascota(object.getMascota())
            .Color(object.getColor())
            .Raza(object.getRaza())
            .build();
    }

    @Override
    public MascotaData toData(Mascota object) {
        return object == null ? null : MascotaData.builder()
            .id(object.getId())
            .Mascota(object.getMascota())
            .Color(object.getColor())
            .Raza(object.getRaza())
            .build();
    }

}
