package com.twineo.start.infrastructure.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "performances")
public class PerformanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ou AUTO
    @Column(nullable = false, updatable = false)
    private Long id;
    String cpu;
    String ram;
    String disk;
    String load;
    Date uptime;
    @OneToOne
    @JoinColumn(name="machine_id")
    MachineEntity machine;
}
