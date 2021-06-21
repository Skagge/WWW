package pl.skagge.dealership.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponse {
    private String brand;
    private String model;
    private String color;
    private int power;
}
