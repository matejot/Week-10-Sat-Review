package ironhack.com.helloplantmanagment.Repository;

import ironhack.com.helloplantmanagment.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
