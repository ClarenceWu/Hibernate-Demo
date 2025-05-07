package com.example.service;

import com.example.dao.StudentDao;
import com.example.dao.StudentDaoImpl;
import com.example.entity.Student;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao dao = new StudentDaoImpl();

    @Override
    public void register(String name) {
        dao.save(new Student(name));
    }

    @Override
    public List<Student> listAll() {
        return dao.findAll();
    }
}
