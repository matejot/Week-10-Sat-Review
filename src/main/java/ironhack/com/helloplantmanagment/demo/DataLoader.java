package ironhack.com.helloplantmanagment.demo;

import ironhack.com.helloplantmanagment.Repository.LocationRepository;
import ironhack.com.helloplantmanagment.Repository.PlantRepository;
import ironhack.com.helloplantmanagment.Repository.WorkerRepository;
import ironhack.com.helloplantmanagment.model.Location;
import ironhack.com.helloplantmanagment.model.Plant;
import ironhack.com.helloplantmanagment.model.Worker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j

public class DataLoader implements CommandLineRunner {


    private final LocationRepository locationRepository;
    private final WorkerRepository workerRepository;
    private final PlantRepository plantRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading data...");
        Location location1 = new Location("Eastern North America");
        Location location2 = new Location("Japan");
        Location location3 = new Location("Madagascar");
        var listOfLocations = List.of(location1, location2, location3);
        locationRepository.saveAll(listOfLocations);

        Worker worker = new Worker("Johny","SomeStreet");
        Worker worker2 = new Worker("Jane","SomeStreet");
        Worker worker3 = new Worker("Joe","SomeStreet");
        var listOfWorkers = List.of(worker, worker2, worker3);
        workerRepository.saveAll(listOfWorkers);

        Plant plant1 = new Plant("Eastern Redbud","Cercis canadensis",2,worker,location1);
        Plant plant2 = new Plant("Japanese Maple","Acer palmatum",5,worker3,location2);
        Plant plant3 = new Plant ("Royal Poinciana","Delonix regia",8,worker2,location3);
        var listOfPlants = List.of(plant1, plant2, plant3);
        plantRepository.saveAll(listOfPlants);
    }
}
