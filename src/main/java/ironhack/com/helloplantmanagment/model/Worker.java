package ironhack.com.helloplantmanagment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data //includes all getters and setters
@Table(name = "workers")


public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long workerId;
    private String name;
    private String address;


    public Worker(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
