package com.motorcycleservice.motorcycleservice.services;

import com.motorcycleservice.motorcycleservice.entities.Motorcycle;
import com.motorcycleservice.motorcycleservice.repositories.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleService {
    @Autowired
    private MotorcycleRepository motorcycleRepository;

    public Motorcycle save(Motorcycle motorcycle) {
        Motorcycle newMotorcycle = motorcycleRepository.save(motorcycle);
        return newMotorcycle;
    }

    public List<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }

    public Motorcycle getMotoById(int id) {
        return motorcycleRepository.findById(id).orElse(null);
    }

    public List<Motorcycle> byUserId(int userId) {
        return motorcycleRepository.findByUserId(userId);
    }
}
