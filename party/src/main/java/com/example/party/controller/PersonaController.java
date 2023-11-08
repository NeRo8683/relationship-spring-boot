/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.party.controller;

import com.example.party.model.Party;
import com.example.party.model.Persona;
import com.example.party.service.PersonaService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<Collection<Persona>> listarPersonas() {
        Collection<Persona> personas = personaService.listarTodasLasPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable long id) {
        return personaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona) {
        Persona personaGuardada = personaService.savePersona(persona);
        return new ResponseEntity<>(personaGuardada, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable long id) {
        personaService.deletePersonaPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/fiestas")
    public ResponseEntity<Collection<Party>> listarFiestasDeLaPersona(@PathVariable long id) {
        Collection<Party> fiestas = personaService.listarFiestasDeLaPersona(id);
        return new ResponseEntity<>(fiestas, HttpStatus.OK);
    }
}
