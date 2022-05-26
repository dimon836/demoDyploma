package com.example.demodyploma.repository;

import com.example.demodyploma.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
    @NotNull RoleEntity findByName(String name);
}
