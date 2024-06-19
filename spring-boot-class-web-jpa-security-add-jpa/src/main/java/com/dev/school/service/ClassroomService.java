package com.dev.school.service;

import com.dev.school.model.Classroom;

import java.util.List;

public interface ClassroomService {
    public List<Classroom> getAll();

    public void add(Classroom classroom);

    public void update(Classroom classroomParameter);

    public void delete(String id);

    public Classroom findById(String id);
}
