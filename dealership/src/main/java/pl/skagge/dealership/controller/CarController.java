package pl.skagge.dealership.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skagge.dealership.model.Car;
import pl.skagge.dealership.model.mapper.CarMapper;
import pl.skagge.dealership.model.request.CarRequest;
import pl.skagge.dealership.service.CarService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    @GetMapping
    public ResponseEntity<?> getCars() {
        return new ResponseEntity<>(carMapper.mapToCarResponseList(carService.getCars()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getSingleCar(@PathVariable long id) {
        Optional<Car> car = carService.getSingleCar(id);
        if(car.isPresent())
            return new ResponseEntity<>(carMapper.mapToCarResponse(car.get()), HttpStatus.OK);
        else
            return new ResponseEntity<>("Car does not exists!", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody CarRequest carRequest) {
        Car car = carMapper.mapToCar(carRequest);
        Optional<Car> carInDatabase = carService.findCarByVin(car.getVin());

        if(carInDatabase.isPresent())
            return new ResponseEntity<>("VIN already exists!", HttpStatus.BAD_REQUEST);
        else {
            carService.createCar(car);
            return new ResponseEntity<>(carMapper.mapToCarResponse(car), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCar(@PathVariable long id) {
        Optional<Car> car  = carService.getSingleCar(id);
        if(car.isPresent()) {
            carService.deleteCar(id);
            return new ResponseEntity<>("Car deleted!", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Car was not found!", HttpStatus.NOT_FOUND);
    }
}
