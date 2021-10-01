package com.studentproject.studentmanagement.repositories;

import java.util.ArrayList;

import com.studentproject.studentmanagement.models.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    abstract ArrayList<Student> findByAge(Integer age);
}
