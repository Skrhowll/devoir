package com.dev.school.repository;

import com.dev.school.model.Classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassroomRepositoryImpl {
    private ArrayList<Classroom> classrooms = new ArrayList<>();

    // Retrieves all classrooms
    public List<Classroom> getAll() {
        return new ArrayList<>(classrooms); // Return a copy to prevent external modifications
    }

    // Adds a classroom to the repository
    public void add(Classroom classroom) {
        if (classroom != null) {
            classrooms.add(classroom);
        }
    }


    // Deletes a classroom by its ID
    public void delete(String id) {
        if (id != null) {
            classrooms.removeIf(classroom -> id.equals(classroom.getName()));
        }
    }

    // Finds a classroom by ID
    public Optional<Classroom> findById(String id) {
        if (id == null) {
            return Optional.empty(); // Return an empty Optional if id is null
        }
        return classrooms.stream()
                .filter(classroom -> id.equals(classroom.getName()))
                .findFirst();
    }
}
