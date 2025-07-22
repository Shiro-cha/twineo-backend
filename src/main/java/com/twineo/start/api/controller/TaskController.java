package com.twineo.start.api.controller;


import com.twineo.start.domain.model.Task;
import com.twineo.start.infrastructure.entity.MachineEntity;
import com.twineo.start.infrastructure.entity.TaskEntity;
import com.twineo.start.infrastructure.repository.MachineRepository;
import com.twineo.start.infrastructure.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private MachineRepository machineRepository;

    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAll().stream()
                .map(this::toDomainModel)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        TaskEntity entity = fromDomainModel(task);
        TaskEntity saved = taskRepository.save(entity);
        return toDomainModel(saved);
    }

    @PostMapping("/{id}/cancel")
    public Task cancelTask(@PathVariable Long id) {
        Optional<TaskEntity> optional = taskRepository.findById(String.valueOf(id));
        if (optional.isPresent()) {
            TaskEntity entity = optional.get();
            entity.setStatus("CANCELLED");
            return toDomainModel(taskRepository.save(entity));
        }
        throw new RuntimeException("Task not found");
    }

    @PostMapping("/{id}/restart")
    public Task restartTask(@PathVariable Long id) {
        Optional<TaskEntity> optional = taskRepository.findById(String.valueOf(id));
        if (optional.isPresent()) {
            TaskEntity entity = optional.get();
            entity.setStatus("PENDING");
            entity.setExecutionTime(new Date());
            return toDomainModel(taskRepository.save(entity));
        }
        throw new RuntimeException("Task not found");
    }

    private Task toDomainModel(TaskEntity entity) {
        Task task = new Task();
        task.id = entity.getId().toString();
        task.name = entity.getName();
        task.command = entity.getCommand();
        task.status = entity.getStatus();
        task.executionTime = entity.getExecutionTime();
        if (entity.getMachine() != null) {
            task.machine = new com.twineo.start.domain.model.Machine();
            task.machine.id = entity.getMachine().getId().toString();
            task.machine.name = entity.getMachine().getName();
        }
        return task;
    }

    private TaskEntity fromDomainModel(Task task) {
        TaskEntity entity = new TaskEntity();
        entity.setName(task.name);
        entity.setCommand(task.command);
        entity.setStatus(task.status);
        entity.setExecutionTime(task.executionTime);
        if (task.machine != null && task.machine.id != null) {
            Optional<MachineEntity> machineOpt = machineRepository.findById(String.valueOf(Long.valueOf(task.machine.id)));
            machineOpt.ifPresent(entity::setMachine);
        }
        return entity;
    }
}

