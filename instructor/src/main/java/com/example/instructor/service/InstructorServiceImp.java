/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.instructor.service;

import com.example.instructor.exception.ResourceNotFoundException;
import com.example.instructor.model.Instructor;
import com.example.instructor.repository.InstructorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a
 */
@Service
public class InstructorServiceImp implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public List<Instructor> listarInstructores() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor obtenerInstructorPorId(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor con el ID : " + id + " no encontrado"));
    }

    @Override
    public Instructor guardarInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor actualizarInstructor(Long id, Instructor instructorDetalles) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor con el ID : " + id + " no encontrado"));

        instructor.setEmail(instructorDetalles.getEmail());
        return instructorRepository.save(instructor);
    }

    @Override
    public void eliminarInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor con el ID : " + id + " no encontrado"));

        instructorRepository.delete(instructor);
    }

}
