package com.example.demodyploma.repository;


import com.example.demodyploma.entity.UserEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    @NotNull List<UserEntity> findAll();
    @NotNull UserEntity findByLogin(String login);
}
