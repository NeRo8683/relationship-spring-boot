/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.party.service.imp;

import com.example.party.model.Party;
import com.example.party.model.Persona;
import com.example.party.repository.PersonaRepository;
import com.example.party.service.PersonaService;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author a
 */
@Service
public class PersonaServicioImp implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Collection<Persona> listarTodasLasPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public ResponseEntity<Persona> findById(long id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);

        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            return new ResponseEntity<>(persona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void deletePersonaPorId(long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        if (persona != null) {
            personaRepository.delete(persona);
        }
    }

    @Override
    public Collection<Party> listarFiestasDeLaPersona(long id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);

        if (personaOptional.isPresent()) {
            return personaOptional.get().getFiestas();
        } else {
            return Collections.emptyList();
        }
    }

}
