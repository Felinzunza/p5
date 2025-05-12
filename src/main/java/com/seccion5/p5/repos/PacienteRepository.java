package com.seccion5.p5.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seccion5.p5.model.Paciente;

@Repository                                                         //Long, pero en duoc da problemas
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
    List<Paciente>findAll(); //interfaz con encontrar paciente ya integrado con JPA

    @SuppressWarnings("unchecked")
    Paciente save(Paciente paciente);

    Paciente findById(int id);

  
   
    
}
