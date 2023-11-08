/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.instructor.repository;

import com.example.instructor.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author a
 */
@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long>{
    
}
