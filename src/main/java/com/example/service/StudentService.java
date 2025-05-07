package com.example.service;

import com.example.entity.Student;
import java.util.List;

public interface StudentService {
    void register(String name);
    List<Student> listAll();
}
