package com.twineo.start.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/machines")
public class MachineController {

    @GetMapping
    public String getMachines() {
        return "hello";
    }
}
