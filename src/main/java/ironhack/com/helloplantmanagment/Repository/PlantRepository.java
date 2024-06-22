package ironhack.com.helloplantmanagment.Repository;

import ironhack.com.helloplantmanagment.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
