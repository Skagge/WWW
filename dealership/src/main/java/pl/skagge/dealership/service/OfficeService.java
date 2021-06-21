package pl.skagge.dealership.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.skagge.dealership.model.Office;
import pl.skagge.dealership.repository.OfficeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfficeService {

    private final OfficeRepository officeRepository;

    public List<Office> getOffices() {
        return officeRepository.findAll();
    }

    public Optional<Office> getSingleOffice(long id) {
        return officeRepository.findById(id);
    }

    public Office createOffice(Office office) {
        return officeRepository.save(office);
    }

    public void deleteOffice(long id) {
        officeRepository.deleteById(id);
    }
}
