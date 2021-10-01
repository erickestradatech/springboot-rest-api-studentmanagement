package com.studentproject.studentmanagement.services;

import java.util.ArrayList;
import java.util.Optional;

import com.studentproject.studentmanagement.models.Student;
import com.studentproject.studentmanagement.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public ArrayList<Student> getAll() {
        return (ArrayList<Student>) studentRepository.findAll();
    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getById(Long id) {
        return studentRepository.findById(id);
    }

    public ArrayList<Student> getByAge(Integer age) {
        return studentRepository.findByAge(age);
    }

    public boolean delete(Long id) {
        try {
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
