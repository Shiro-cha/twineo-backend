package com.twineo.start.api.controller;

import com.twineo.start.domain.model.Machine;
import com.twineo.start.infrastructure.entity.MachineEntity;
import com.twineo.start.infrastructure.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/machines")
public class MachineController {

    @Autowired
    private MachineRepository machineRepository;

    @GetMapping
    public List<Machine> getMachines() {
        return machineRepository.findAll().stream()
                .map(this::toDomainModel)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Machine createMachine(@RequestBody Machine machine) {
        MachineEntity entity = fromDomainModel(machine);
        MachineEntity saved = machineRepository.save(entity);
        return toDomainModel(saved);
    }

    @PutMapping("/{id}")
    public Machine updateMachine(@PathVariable Long id, @RequestBody Machine machine) {
        Optional<MachineEntity> optional = machineRepository.findById(String.valueOf(id));
        if (optional.isPresent()) {
            MachineEntity entity = optional.get();
            entity.setName(machine.name);
            entity.setIp(machine.ip);
            entity.setUsername(machine.user);
            entity.setPassword(machine.password);
            entity.setKey(machine.key);
            return toDomainModel(machineRepository.save(entity));
        }
        throw new RuntimeException("Machine not found");
    }

    @DeleteMapping("/{id}")
    public void deleteMachine(@PathVariable Long id) {
        machineRepository.deleteById(String.valueOf(id));
    }

    @PostMapping("/{id}/archive")
    public String archiveMachine(@PathVariable Long id) {
        // Ajoute une logique réelle ici avec un champ d'archivage si disponible
        return "Machine with ID " + id + " archived.";
    }

    @PostMapping("/{id}/share")
    public String shareMachine(@PathVariable Long id) {
        // Ajoute une logique réelle de partage ici (lien, email, etc.)
        return "Machine with ID " + id + " shared.";
    }

    private Machine toDomainModel(MachineEntity entity) {
        Machine machine = new Machine();
        machine.id = entity.getId().toString();
        machine.name = entity.getName();
        machine.ip = entity.getIp();
        machine.user = entity.getUsername();
        machine.password = entity.getPassword();
        machine.key = entity.getKey();
        return machine;
    }

    private MachineEntity fromDomainModel(Machine machine) {
        MachineEntity entity = new MachineEntity();
        entity.setName(machine.name);
        entity.setIp(machine.ip);
        entity.setUsername(machine.user);
        entity.setPassword(machine.password);
        entity.setKey(machine.key);
        return entity;
    }
}
