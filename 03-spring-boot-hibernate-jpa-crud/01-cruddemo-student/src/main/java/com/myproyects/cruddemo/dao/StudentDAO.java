package com.myproyects.cruddemo.dao;

import com.myproyects.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findBySecondName(String secondName);

    void update(Student theStudent);
}