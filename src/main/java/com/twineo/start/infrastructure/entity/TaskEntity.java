package com.twineo.start.infrastructure.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ou AUTO
    @Column(nullable = false, updatable = false)
    private Long id;
    String name;
    String command;
    String status;
    Date executionTime;
    @ManyToOne
    @JoinColumn(name="machine_id")
    MachineEntity machine;

}
