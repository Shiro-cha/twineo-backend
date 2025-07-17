package com.twineo.start.infrastructure.repository;

import com.twineo.start.infrastructure.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionEntity, String> {
}
