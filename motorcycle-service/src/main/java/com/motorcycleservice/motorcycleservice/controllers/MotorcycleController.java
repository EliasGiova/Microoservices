package com.motorcycleservice.motorcycleservice.controllers;

import com.motorcycleservice.motorcycleservice.entities.Motorcycle;
import com.motorcycleservice.motorcycleservice.services.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycles")
public class MotorcycleController {

    @Autowired
    private MotorcycleService motorcycleService;

    @GetMapping
    public ResponseEntity<List<Motorcycle>> ListMotorcycles() {
        List<Motorcycle> motorcycles = motorcycleService.getAll();
        if (motorcycles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motorcycles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorcycle> getMotorcycleById(@PathVariable("id") int id) {
        Motorcycle motorcycle = motorcycleService.getMotoById(id);
        if (motorcycle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motorcycle);
    }

    @PostMapping
    public ResponseEntity<Motorcycle> saveMotorcycle(@RequestBody Motorcycle motorcycle) {
        Motorcycle newMotorcycle = motorcycleService.save(motorcycle);
        return ResponseEntity.ok(newMotorcycle);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Motorcycle>> ListMotorcyclesByUserId(@PathVariable("userId") int userID) {
        List<Motorcycle> motorcycles = motorcycleService.byUserId(userID);
        if (motorcycles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motorcycles);
    }
}
