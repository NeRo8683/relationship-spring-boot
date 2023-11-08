/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.student.service;


import com.example.student.model.Student;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author a
 */
@Service
public interface StudentService {
    
    public List<Student> findAllStudent();
    public Student saveStudent(Student student);
    public Student findStudentById(Long id);
    public Student updateStudent (Student estudiante);
    public void deleteStudent(Long id);
}
