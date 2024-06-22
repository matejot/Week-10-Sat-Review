package ironhack.com.helloplantmanagment.Repository;

import ironhack.com.helloplantmanagment.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
