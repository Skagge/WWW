package pl.skagge.dealership.model.response;

import lombok.Getter;
import lombok.Setter;
import pl.skagge.dealership.model.Car;

import java.util.List;

@Getter
@Setter
public class OfficeResponse {
    private String address;
    private String owner;
    private List<CarResponse> cars;
}
