/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.party.service;


import com.example.party.model.Party;
import com.example.party.model.Persona;
import java.util.Collection;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author a
 */
public interface PersonaService {

    Collection<Persona> listarTodasLasPersonas();
    ResponseEntity<Persona> findById(long id);
    Persona savePersona(Persona persona);
    void deletePersonaPorId(long id);
    Collection<Party> listarFiestasDeLaPersona(long id);
}
