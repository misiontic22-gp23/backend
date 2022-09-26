package com.huellitas.backend.converters;

import com.huellitas.backend.data.ConsultaData;
import com.huellitas.backend.entities.Consulta;

public class ConsultaConverter extends Converter<Consulta, ConsultaData> {

    private ClinicaConverter clinicaConverter = new ClinicaConverter();
    private VetConverter vetConverter = new VetConverter();

    @Override
    public Consulta toEntity(ConsultaData object) {
        return object == null ? null : Consulta.builder()
            .id(object.getId())
            .temperatura(object.getTemperatura())
            .frecuenciaCardiaca(object.getFrecuenciaCardiaca())
            .frecuenciaRespiratoria(object.getFrecuenciaRespiratoria())
            .estado(object.getEstado())
            .recomendaciones(object.getRecomendaciones())
            .historiaClinica(clinicaConverter.toEntity(object.getHistoriaClinica()))
            .veterinario(vetConverter.toEntity(object.getVeterinario()))
            .build();
    }

    @Override
    public ConsultaData toData(Consulta object) {
        return object == null ? null : ConsultaData.builder()
        .id(object.getId())
        .temperatura(object.getTemperatura())
        .frecuenciaCardiaca(object.getFrecuenciaCardiaca())
        .frecuenciaRespiratoria(object.getFrecuenciaRespiratoria())
        .estado(object.getEstado())
        .recomendaciones(object.getRecomendaciones())
        .historiaClinica(clinicaConverter.toData(object.getHistoriaClinica()))
        .veterinario(vetConverter.toData(object.getVeterinario()))
        .build();
    }

}
