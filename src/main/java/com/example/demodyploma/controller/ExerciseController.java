package com.example.demodyploma.controller;

import com.example.demodyploma.entity.ExerciseEntity;
import com.example.demodyploma.repository.ExerciseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getExercises")
    public List<ExerciseEntity> getExercises() {
        return exerciseEntityRepository.findAll();
    }

    @GetMapping("/getExercises/{id}")
    public Optional<ExerciseEntity> getExercise(@PathVariable Long id) {
        return exerciseEntityRepository.findById(id);
    }

    @PutMapping("/getExercises")
    public ResponseEntity<ExerciseEntity> changeExercise(@RequestBody ExerciseEntity exercise) {
        exerciseEntityRepository.save(exercise);
        return ResponseEntity.ok().body(exercise);
    }
}
