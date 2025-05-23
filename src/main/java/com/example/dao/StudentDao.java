package com.example.dao;

import com.example.entity.Student;
import java.util.List;

public interface StudentDao {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    void update(Student student);
    void delete(int id);
}
