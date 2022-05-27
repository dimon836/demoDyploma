package com.example.demodyploma.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "exercise")
@Getter
public class ExerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "condition")
    private String condition;
}
