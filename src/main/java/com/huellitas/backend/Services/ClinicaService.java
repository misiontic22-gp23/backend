package com.huellitas.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.huellitas.backend.converters.ClinicaConverter;
import com.huellitas.backend.data.ClinicaData;
import com.huellitas.backend.entities.Clinica;
import com.huellitas.backend.repositories.ClinicaRepository;

@Service
public class ClinicaService {
    
    @Autowired
    ClinicaRepository clinicaRepository;

    ClinicaConverter clinicaConverter = new ClinicaConverter();
    
    //Listar todas las historias clinicas
    public List<ClinicaData> findAll() {
        return clinicaConverter.toData(clinicaRepository.findAll());
    }

    //Listar una historia clinica por id
    public ClinicaData findById(int id) {
        Optional <Clinica> clinica = clinicaRepository.findById(id);
            if(!clinica.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡La historia clinica no existe!");
            }   
        return clinicaConverter.toData(clinica.get());
    }

    //Crear una historia clinica
    public ClinicaData insert(ClinicaData clinica) {
        if(clinicaRepository.existsById(clinica.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡No se puede insertar una historia clinica con id!");
        }
        Clinica clinicaEntity = clinicaConverter.toEntity(clinica);
        ClinicaData response = clinicaConverter.toData(clinicaRepository.save(clinicaEntity));
        return response;
    }

    //Editar una historia clinica
    public ClinicaData update(ClinicaData clinica) {
        if(!clinicaRepository.existsById(clinica.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede actualizar una historia clinica que no existe!");
        }
        Clinica clinicaEntity = clinicaConverter.toEntity(clinica);
        ClinicaData response = clinicaConverter.toData(clinicaRepository.save(clinicaEntity));
        return response;
    }

    //Eliminar una historia clinica
    public ClinicaData deleteById(int id) {
        Optional<Clinica> clinica = clinicaRepository.findById(id); 
        if(clinica.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede eliminar una historia clinica que no existe!");
        }
        clinicaRepository.deleteById(id);
        return clinicaConverter.toData(clinica.get());
    }
}
