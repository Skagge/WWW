package cars.controllers;

import cars.models.Licence;
import cars.services.LicenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/licences")
public class LicenceController {

    private final LicenceService licenceService;

    @Autowired
    public LicenceController(LicenceService licenceService) {
        this.licenceService = licenceService;
    }

    @GetMapping
    public List<Licence> getAllLicences() {
        return licenceService.getAllLicenses();
    }

    @GetMapping("/{id}")
    public Optional<Licence> getUserById(@PathVariable int id) {
        return licenceService.getLicenseById(id);
    }

    @PostMapping
    public Licence addLicence(@RequestBody Licence licence) {
        return licenceService.addLicence(licence);
    }
}
