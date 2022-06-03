package com.example.demodyploma.controller;

import com.example.demodyploma.entity.ExerciseEntity;
import com.example.demodyploma.repository.ExerciseEntityRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExerciseController {

    private final ExerciseEntityRepository exerciseEntityRepository;

    @Autowired
    public ExerciseController(ExerciseEntityRepository exerciseEntityRepository) {
        this.exerciseEntityRepository = exerciseEntityRepository;
    }

    @GetMapping(value = "/getExercises", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExerciseEntity>> getExercises() {
        return ResponseEntity.ok(exerciseEntityRepository.findAll());
    }

    @GetMapping(value = "/getExercises/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ExerciseEntity> getExercise(@PathVariable Long id) {
        return exerciseEntityRepository.findById(id);
    }

    @PutMapping("/replaceExercise")
    public void replaceExercise(@RequestBody ExerciseEntity exercise) {
        exerciseEntityRepository.save(exercise);
    }
}
