package pl.skagge.dealership.model.mapper;

import org.mapstruct.Mapper;
import pl.skagge.dealership.model.Office;
import pl.skagge.dealership.model.request.OfficeRequest;
import pl.skagge.dealership.model.response.OfficeResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfficeMapper {
    Office mapToOffice(OfficeRequest officeRequest);
    OfficeResponse mapToOfficeResponse(Office office);
    List<OfficeResponse> mapToOfficeResponseList(List<Office> list);
}
