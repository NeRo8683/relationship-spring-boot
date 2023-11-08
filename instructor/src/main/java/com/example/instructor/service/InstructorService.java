/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.instructor.service;

import com.example.instructor.model.Instructor;
import java.util.List;

/**
 *
 * @author a
 */
public interface InstructorService {
    
    List<Instructor> listarInstructores();
    Instructor obtenerInstructorPorId(Long id);
    Instructor guardarInstructor(Instructor instructor);
    Instructor actualizarInstructor(Long id, Instructor instructorDetalles);
    void eliminarInstructor(Long id);


}
