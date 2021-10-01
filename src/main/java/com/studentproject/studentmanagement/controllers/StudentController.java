package com.studentproject.studentmanagement.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.studentproject.studentmanagement.models.Student;
import com.studentproject.studentmanagement.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping()
    public ArrayList<Student> getStudents() {
        return this.studentService.getAll();
    }

    @PostMapping()
    public Student createStudent(@RequestBody Student student) {
        return this.studentService.create(student);
    }

    @GetMapping(path = "/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long id) {
        return this.studentService.getById(id);
    }

    @GetMapping("/req")
    public ArrayList<Student> getStudentByAge(@RequestParam("age") Integer age) {
        return this.studentService.getByAge(age);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean status = this.studentService.delete(id);
        if (status) {
            return "Delete student with id " + id;
        } else {
            return "Could not delete user with id " + id;
        }
    }
}
