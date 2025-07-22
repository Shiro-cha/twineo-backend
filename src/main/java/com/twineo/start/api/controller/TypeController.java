package com.twineo.start.api.controller;

import com.twineo.start.domain.model.Type;
import com.twineo.start.infrastructure.entity.TypeEntity;
import com.twineo.start.infrastructure.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping
    public List<Type> getAllTypes() {
        return typeRepository.findAll().stream().map(this::toDomainModel).collect(Collectors.toList());
    }

    private Type toDomainModel(TypeEntity entity) {
        Type type = new Type();
        type.id = entity.getId().toString();
        type.name = entity.getName();
        return type;
    }
}
