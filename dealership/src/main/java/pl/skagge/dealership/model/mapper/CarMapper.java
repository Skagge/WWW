package pl.skagge.dealership.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.skagge.dealership.model.Car;
import pl.skagge.dealership.model.Office;
import pl.skagge.dealership.model.request.CarRequest;
import pl.skagge.dealership.model.response.CarResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarResponse mapToCarResponse(Car car);
    List<CarResponse> mapToCarResponseList(List<Car> list);
    @Mapping(source = "office_id", target = "office", qualifiedByName = "officeToOfficeId")
    Car mapToCar(CarRequest carRequest);
    @Named("officeToOfficeId")
    public static Office officeToOfficeId(long office_id) {
        Office office = new Office();
        office.setId(office_id);
        return office;
    }
}
