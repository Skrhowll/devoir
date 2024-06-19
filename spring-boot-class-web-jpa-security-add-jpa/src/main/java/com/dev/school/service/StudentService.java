package com.dev.school.service;

import com.dev.school.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAll();

    public void add(Student student);

    public void update(Student studentParameter);

    public void delete(String id);

    public Student findById(String id);
}
