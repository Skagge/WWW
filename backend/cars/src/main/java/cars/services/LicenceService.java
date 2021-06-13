package cars.services;

import cars.models.Licence;
import cars.repositories.LicenceRepository;
import cars.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenceService {

    private final LicenceRepository licenceRepository;
    private final UserRepository userRepository;

    @Autowired
    public LicenceService(LicenceRepository licenceRepository,
                          UserRepository userRepository) {
        this.licenceRepository = licenceRepository;
        this.userRepository = userRepository;
    }

    public List<Licence> getAllLicenses() {
        return licenceRepository.findAll();
    }

    public Optional<Licence> getLicenseById(int id) {
        return licenceRepository.findById(id);
    }

    public Licence addLicence(Licence licence) {
        return licenceRepository.save(licence);
    }
}
