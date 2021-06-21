package pl.skagge.dealership.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequest {
    private long office_id;
    private String brand;
    private String model;
    private String vin;
    private String color;
    private int power;
}
