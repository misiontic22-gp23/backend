package com.huellitas.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.huellitas.backend.converters.ConsultaConverter;
import com.huellitas.backend.data.ConsultaData;
import com.huellitas.backend.entities.Consulta;
import com.huellitas.backend.repositories.ConsultaRepository;

@Service
public class ConsultaService {
    
    @Autowired
    private ConsultaRepository consultaRepository;

    private ConsultaConverter consultaConverter = new ConsultaConverter();

    //Listar todas las consultas
    public List<ConsultaData> findAll() {
        return consultaConverter.toData(consultaRepository.findAll());
    }

    //Listar una consulta por id
    public ConsultaData findById(int id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
            if(!consulta.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡La consulta no existe!");
            }
        return consultaConverter.toData(consulta.get());
    }

    //Agregar una consulta
    public ConsultaData insert(ConsultaData consulta) {
        if(consultaRepository.existsById(consulta.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡No se puede insertar una consulta con id!");
        }
        Consulta consultaEntity = consultaConverter.toEntity(consulta);
        ConsultaData response = consultaConverter.toData(consultaRepository.save(consultaEntity));
        return response;
    }

    //Editar una consulta
    public ConsultaData update(ConsultaData consulta) {
        if(!consultaRepository.existsById(consulta.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede actualizar una consulta que no existe!");
        }
        return consultaConverter.toData(consultaRepository.save(consultaConverter.toEntity(consulta)));
    }

    //Eliminar una consulta
    public ConsultaData deleteById(int id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
            if(!consulta.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede eliminar una consulta que no existe!");
            }
        consultaRepository.deleteById(id);
        return consultaConverter.toData(consulta.get());
    }
}
