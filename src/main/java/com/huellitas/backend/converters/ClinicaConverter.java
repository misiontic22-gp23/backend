package com.huellitas.backend.converters;

import com.huellitas.backend.data.ClinicaData;
import com.huellitas.backend.entities.Clinica;

public class ClinicaConverter extends Converter<Clinica, ClinicaData> {

    @Override
    public Clinica toEntity(ClinicaData object) {
        return object == null ? null : Clinica.builder()
            .id(object.getId())
            .Fecha(object.getFecha())
            .build();
    }

    @Override
    public ClinicaData toData(Clinica object) {
        return object == null ? null : ClinicaData.builder()
        .id(object.getId())
        .Fecha(object.getFecha())
        .build();
    }

}
