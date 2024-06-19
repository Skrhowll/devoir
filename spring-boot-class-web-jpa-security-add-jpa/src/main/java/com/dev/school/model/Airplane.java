package com.dev.school.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * A JPA entity that represents a table in the database for airplanes.
 */
@Data
@Entity
@Table(name = "airplane")
public class Airplane {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

}

