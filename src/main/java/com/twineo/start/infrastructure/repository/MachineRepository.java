package com.twineo.start.infrastructure.repository;

import com.twineo.start.infrastructure.entity.MachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<MachineEntity, String> {
}
