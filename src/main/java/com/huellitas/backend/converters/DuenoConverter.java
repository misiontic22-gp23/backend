package com.huellitas.backend.converters;

import com.huellitas.backend.data.DuenoData;
import com.huellitas.backend.entities.Dueno;

public class DuenoConverter extends Converter<Dueno, DuenoData> {

    private MascotaConverter MascotaConverter = new MascotaConverter();

    @Override
    public Dueno toEntity(DuenoData object) {
        return object == null ? null : Dueno.builder()
            .id(object.getId())
            .identificacion(object.getIdentificacion())
            .nombre(object.getNombre())
            .apellido(object.getApellido())
            .telefono(object.getTelefono())
            .Mascota(MascotaConverter.toEntity(object.getMascota()))
            .build();
    }

    @Override
    public DuenoData toData(Dueno object) {
        return object == null ? null : DuenoData.builder()
            .id(object.getId())
            .identificacion(object.getIdentificacion())
            .nombre(object.getNombre())
            .apellido(object.getApellido())
            .telefono(object.getTelefono())
            .Mascota(MascotaConverter.toData(object.getMascota()))
            .build();
    }

}
