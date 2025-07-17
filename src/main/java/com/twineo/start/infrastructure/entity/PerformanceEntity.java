package com.twineo.start.infrastructure.entity;

import com.twineo.start.domain.model.Machine;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "performances")
public class PerformanceEntity {
    @Id
    String id;
    String cpu;
    String ram;
    String disk;
    String load;
    Date uptime;
    @OneToOne
    @JoinColumn(name="machine_id")
    Machine machine;

    public PerformanceEntity(){
        this.id= UUID.randomUUID().toString();
    }
}
