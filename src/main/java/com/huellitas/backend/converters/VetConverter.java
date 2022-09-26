package com.huellitas.backend.converters;

import com.huellitas.backend.data.VetData;
import com.huellitas.backend.entities.Vet;

public class VetConverter extends Converter<Vet, VetData> {

    private MascotaConverter MascotaConverter = new MascotaConverter();

    @Override
    public Vet toEntity(VetData object) {
        return object == null ? null : Vet.builder()
            .id(object.getId())
            .identificacion(object.getIdentificacion())
            .nombre(object.getNombre())
            .apellido(object.getApellido())
            .telefono(object.getTelefono())
            .tarjeta(object.getTarjeta())
            .password(object.getPassword())
            .Mascota(MascotaConverter.toEntity(object.getMascota()))
            .build();
    }

    @Override
    public VetData toData(Vet object) {
        return object == null ? null : VetData.builder()
        .id(object.getId())
            .identificacion(object.getIdentificacion())
            .nombre(object.getNombre())
            .apellido(object.getApellido())
            .telefono(object.getTelefono())
            .tarjeta(object.getTarjeta())
            .password(null)
            .Mascota(MascotaConverter.toData(object.getMascota()))
            .build();
    }

}