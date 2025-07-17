package com.twineo.start.infrastructure.repository;

import com.twineo.start.infrastructure.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<TypeEntity, String> {
}
