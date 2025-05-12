package com.seccion5.p5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.seccion5.p5.model.Paciente;
import com.seccion5.p5.repos.PacienteRepository;

public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    
    public List<Paciente>findAll(){
        return pacienteRepository.findAll();
    };
    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
    public Paciente findbyId(int id){
        return pacienteRepository.findById(id);
    }
}
