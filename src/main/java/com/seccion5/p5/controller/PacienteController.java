package com.seccion5.p5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seccion5.p5.model.Paciente;
import com.seccion5.p5.service.PacienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public ResponseEntity<List<Paciente>>getPacientes(){ //ResponseEntity me facilita generar mensajes como por ejemplo errores
        List<Paciente>pacientes = pacienteService.findAll();

        if(pacientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        };
        return new ResponseEntity<>(pacienteService.findAll(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Paciente>postPaciente(@RequestBody Paciente paciente) {
        Paciente buscado = pacienteService.findbyId(paciente.getId());
        if(buscado == null){
            
        return new ResponseEntity<>(pacienteService.save(paciente),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/id")
    public ResponseEntity<Paciente>getPacientebyId(@PathVariable int id) {

        Paciente buscado = pacienteService.findbyId(id);
        if (buscado != null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    
}
