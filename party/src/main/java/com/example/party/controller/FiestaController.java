/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.party.controller;

import com.example.party.model.Party;
import com.example.party.model.Persona;
import com.example.party.service.PartyService;
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
@RequestMapping("/fiesta")
public class FiestaController {

    @Autowired
    private PartyService partyService;

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<Collection<Party>> listarFiestas() {
        Collection<Party> parties = partyService.listarFiesta();
        return new ResponseEntity<>(parties, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable long id) {
        return personaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Party> guardarFiesta(@RequestBody Party party) {
        Party partySave = partyService.saveParty(party);
        return new ResponseEntity<>(partySave, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable long id) {
        personaService.deletePersonaPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
