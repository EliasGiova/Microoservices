package com.userservice.userservice.controllers;

import com.userservice.userservice.entities.User;
import com.userservice.userservice.models.Car;
import com.userservice.userservice.models.Motorcycle;
import com.userservice.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listUsers(){
        List<User> users = userService.getAll();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        User user = userService.getUserById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User newUser = userService.save(user);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> listCars(@PathVariable("userId") int userId){
        User user = userService.getUserById(userId);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        List<Car> cars = userService.getCars(userId);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/motorcycles/{userId}")
    public ResponseEntity<List<Motorcycle>> listMotorcycles(@PathVariable("userId") int userId){
        User user = userService.getUserById(userId);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        List<Motorcycle> motorcycles = userService.getMotorcycles(userId);
        return ResponseEntity.ok(motorcycles);
    }

    @PostMapping("/car/{userId}")
    public ResponseEntity<Car> saveCar(@PathVariable("userId") int userId, @RequestBody Car car){
        Car newCar = userService.saveCar(userId, car);
        return ResponseEntity.ok(newCar);
    }

    @PostMapping("/motorcycle/{userId}")
    public ResponseEntity<Motorcycle> saveMotorcycle(@PathVariable("userId") int userId, @RequestBody Motorcycle motorcycle){
        Motorcycle newMotorcycle = userService.saveMoto(userId, motorcycle);
        return  ResponseEntity.ok(newMotorcycle);
    }
}
