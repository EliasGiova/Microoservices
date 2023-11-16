package com.userservice.userservice.feignClients;

import com.userservice.userservice.models.Motorcycle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "motorcycle-service", url = "http://localhost:8003")
public interface MotoFeingClient {

    @PostMapping("/api/motorcycles")
    Motorcycle save(@RequestBody Motorcycle motorcycle);

    @GetMapping("/user/{userId}")
    List<Motorcycle> getMotorcycle(@PathVariable("userId") int userId);
}
