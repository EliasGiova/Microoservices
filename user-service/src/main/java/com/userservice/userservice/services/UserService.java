package com.userservice.userservice.services;

import com.userservice.userservice.entities.User;
import com.userservice.userservice.models.Car;
import com.userservice.userservice.models.Motorcycle;
import com.userservice.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        User newUser = userRepository.save(user);
        return newUser;
    }

    public List<User>getAll(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    //Conexión desde Usuario Servicio a los microservicios de Auto
    public List<Car> getCars(int userId){
        List<Car> cars = restTemplate.getForObject("http://localhost:8002/api/cars/user/" + userId, List.class);
        return cars;
    }

    //Conexión desde Usuario Servicio a los microservicios de Moto
    public List<Motorcycle> getMotorcycles(int userId){
        List<Motorcycle> motorcycles = restTemplate.getForObject("http://localhost:8003/api/motorcycles/user/" + userId, List.class);
        return motorcycles;
    }
}
