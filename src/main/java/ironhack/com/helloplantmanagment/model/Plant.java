package ironhack.com.helloplantmanagment.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "plants")

public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantId;
    private String name;
    private String species;
    private int quantity;
    @ManyToOne
    private Worker workerId;
    @ManyToOne
    private Location locationId;

    public Plant(String name,
                 String species,
                 int quantity,
                 Worker workerId,
                 Location locationId) {
        this.name = name;
        this.species = species;
        this.quantity = quantity;
        this.workerId = workerId;
        this.locationId = locationId;
    }
}
