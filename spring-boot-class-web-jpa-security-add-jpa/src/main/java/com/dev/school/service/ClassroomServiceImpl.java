package com.dev.school.service;

import com.dev.school.model.Classroom;

import java.util.ArrayList;
import java.util.List;

public class ClassroomServiceImpl implements ClassroomService {
    private ArrayList<Classroom> classrooms = new ArrayList<>();

    @Override
    public List<Classroom> getAll() {
        return new ArrayList<>(classrooms);
    }

    @Override
    public void add(Classroom classroom) {
        classrooms.add(classroom);
    }

    @Override
    public void update(Classroom classroom) {
        // Assume an appropriate update logic
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Classroom findById(String id) {
        return null;
    }

}
