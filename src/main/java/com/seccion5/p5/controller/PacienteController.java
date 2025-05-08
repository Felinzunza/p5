package com.seccion5.p5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seccion5.p5.model.Paciente;
import com.seccion5.p5.service.PacienteService;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    public ResponseEntity<List<Paciente>>getPacientes(){
        List<Paciente>pacientes = pacienteService.findAll();

        if(pacientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return new ResponseEntity<>(pacienteService.findAll(),HttpStatus.OK);
    }
}
