package com.example.demodyploma.controller;

import com.example.demodyploma.entity.ExerciseEntity;
import com.example.demodyploma.repository.ExerciseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/exercise")
@RestController
public class ExerciseController {

    private final ExerciseEntityRepository exerciseEntityRepository;

    @Autowired
    public ExerciseController(ExerciseEntityRepository exerciseEntityRepository) {
        this.exerciseEntityRepository = exerciseEntityRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExerciseEntity>> getExercises() {
        return ResponseEntity.ok(exerciseEntityRepository.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ExerciseEntity> getExercise(@PathVariable Long id) {
        return exerciseEntityRepository.findById(id);
    }

    @PutMapping
    public ResponseEntity<ExerciseEntity> putExercise(@RequestBody ExerciseEntity exercise) {
        exerciseEntityRepository.save(exercise);
        return ResponseEntity.ok().body(exercise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        exerciseEntityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
