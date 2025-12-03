package kz.attractorschool.carscrudbackend.service;

import kz.attractorschool.carscrudbackend.entity.Car;
import kz.attractorschool.carscrudbackend.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car create(Car car) {
        return carRepository.save(car);
    }

    public Car update(Long id, Car updatedCar) {
        Car existing = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found: " + id));

        existing.setBrand(updatedCar.getBrand());
        existing.setModel(updatedCar.getModel());
        existing.setColor(updatedCar.getColor());
        existing.setYear(updatedCar.getYear());
        existing.setPrice(updatedCar.getPrice());

        return carRepository.save(existing);
    }

    public void delete(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found: " + id);
        }
        carRepository.deleteById(id);
    }
}