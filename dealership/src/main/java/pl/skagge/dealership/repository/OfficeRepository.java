package pl.skagge.dealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.skagge.dealership.model.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
}
