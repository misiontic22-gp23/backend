package com.huellitas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huellitas.backend.entities.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Integer> {

}
