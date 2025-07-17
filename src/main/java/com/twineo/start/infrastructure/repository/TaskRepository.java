package com.twineo.start.infrastructure.repository;

import com.twineo.start.infrastructure.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, String> {
}
