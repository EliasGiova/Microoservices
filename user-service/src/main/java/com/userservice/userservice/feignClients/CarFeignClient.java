package com.userservice.userservice.feignClients;

import com.userservice.userservice.models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "cars-service", url = "http://localhost:8002")
public interface CarFeignClient {

    @PostMapping("/api/cars")
    Car save(@RequestBody Car car);

    @GetMapping("/user/{userId}")
    List<Car> getCar(@PathVariable("userId") int userId);
}
