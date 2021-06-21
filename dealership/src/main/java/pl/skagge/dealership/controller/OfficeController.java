package pl.skagge.dealership.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skagge.dealership.model.Office;
import pl.skagge.dealership.model.mapper.OfficeMapper;
import pl.skagge.dealership.model.request.OfficeRequest;
import pl.skagge.dealership.service.OfficeService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/offices")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeService officeService;
    private final OfficeMapper officeMapper;

    @GetMapping
    public ResponseEntity<?> getOffices() {
        return new ResponseEntity<>(officeMapper.mapToOfficeResponseList(officeService.getOffices()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getSingleOffice(@PathVariable long id) {
        Optional<Office> office = officeService.getSingleOffice(id);
        if(office.isPresent())
            return new ResponseEntity<>(officeMapper.mapToOfficeResponse(office.get()), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createOffice(@RequestBody OfficeRequest officeRequest) {
        return new ResponseEntity<>(officeMapper.mapToOfficeResponse(officeService.createOffice(officeMapper.mapToOffice(officeRequest))), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOffice(@PathVariable long id) {
        Optional<Office> office = officeService.getSingleOffice(id);
        if(office.isPresent()) {
            if(office.get().getCars().isEmpty()) {
                officeService.deleteOffice(id);
                return new ResponseEntity<>("Offices deleted!", HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Cannot delete! The office has cars!", HttpStatus.CONFLICT);
            }
        }
        else {
            return new ResponseEntity<>("The Office was not found!", HttpStatus.NOT_FOUND);
        }
    }
}
