package com.twineo.start.infrastructure.repository;

import com.twineo.start.infrastructure.entity.PerformanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<PerformanceEntity, String> {
}
