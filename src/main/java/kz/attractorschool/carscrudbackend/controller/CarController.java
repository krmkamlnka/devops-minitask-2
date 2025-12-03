package kz.attractorschool.carscrudbackend.controller;

import kz.attractorschool.carscrudbackend.entity.Car;
import kz.attractorschool.carscrudbackend.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car saved = carService.create(car);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        Car updated = carService.update(id, car);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}