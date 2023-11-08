/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.party.service.imp;

import com.example.party.model.Party;
import com.example.party.model.Persona;
import com.example.party.repository.PartyRepository;
import com.example.party.repository.PersonaRepository;
import com.example.party.service.PartyService;

import java.util.Collection;
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
public class PartyServicioImp implements PartyService {

    @Autowired
    private PartyRepository partyRepository;
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Collection<Party> listarFiesta() {
        return partyRepository.findAll();
    }

    @Override
    public ResponseEntity<Persona> findById(long id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        return personaOptional.map(persona -> new ResponseEntity<>(persona, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @Override
    public Party saveParty(Party party) {
        return partyRepository.save(party);
    }

    @Override
    public void deletePersonaPorId(long id) {
        personaRepository.deleteById(id);
    }

}
