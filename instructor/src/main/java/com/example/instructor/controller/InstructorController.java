/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.instructor.controller;

import com.example.instructor.model.Instructor;
import com.example.instructor.service.InstructorService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a
 */
@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/get")
    public List<Instructor> listarInstructores() {
        return instructorService.listarInstructores();
    }

//    @GetMapping("/{id}")
    @GetMapping("/instructor/{id}")
    public ResponseEntity<Instructor> verDetallesDelInstructor(@PathVariable Long id) {
        Instructor instructor = instructorService.obtenerInstructorPorId(id);
        return ResponseEntity.ok().body(instructor);
    }

    @PostMapping("/post")
    public Instructor guardarInstructor(@Valid @RequestBody Instructor instructor) {
        return instructorService.guardarInstructor(instructor);
    }

    @PutMapping("/instructores/{id}")
    public ResponseEntity<Instructor> actualizarInstructor(
            @PathVariable Long id,
            @Valid @RequestBody Instructor instructorDetalles
    ) {
        Instructor instructorActualizado = instructorService.actualizarInstructor(id, instructorDetalles);
        return ResponseEntity.ok(instructorActualizado);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> eliminarInstructor(@PathVariable Long id) {
        instructorService.eliminarInstructor(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Instructor eliminado", Boolean.TRUE);
        return respuesta;
    }

}
