package pl.skagge.dealership.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.skagge.dealership.model.Car;
import pl.skagge.dealership.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getSingleCar(long id) {
        return carRepository.findById(id);
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

    public Optional<Car> findCarByVin(String vin) {
        return carRepository.findCarByVin(vin);
    }
}
