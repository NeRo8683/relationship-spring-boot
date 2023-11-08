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
public interface PartyService {

    Collection<Party> listarFiesta();
    ResponseEntity<Persona> findById(long id);
    Party saveParty(Party party);
    void deletePersonaPorId(long id);

}
