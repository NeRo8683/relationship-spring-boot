/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping({"/estudiante"})// localhost:8080/estudiante
    public String findStudent(Model modelo) {
        modelo.addAttribute("estudiantes", studentService.findAllStudent());
        return "students";
    }

    @GetMapping("/students")
    public List<Student> listarProductos() {
        return studentService.findAllStudent();
    }

    @GetMapping("/estudiante/nuevo")
    public String mostrarFormularioDeRegistrtarEstudiante(Model modelo) {
        Student student = new Student();
        modelo.addAttribute("estudiante", student);
        return "create_students";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("estudiante", studentService.findStudentById(id));
        return "edit_students";
    }

    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Student student,
            Model modelo) {
        Student estudianteExistente = studentService.findStudentById(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(student.getNombre());
        estudianteExistente.setApellido(student.getApellido());
        estudianteExistente.setEmail(student.getEmail());

        studentService.updateStudent(estudianteExistente);
        return "redirect:/students";
    }

    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
