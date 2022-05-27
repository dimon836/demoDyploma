package com.example.demodyploma.repository;

import com.example.demodyploma.entity.ExerciseEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseEntityRepository extends JpaRepository<ExerciseEntity, Long> {
    @NotNull List<ExerciseEntity> findAll();
}
