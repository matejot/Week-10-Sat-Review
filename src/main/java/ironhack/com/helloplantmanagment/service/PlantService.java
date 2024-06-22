package ironhack.com.helloplantmanagment.service;

import ironhack.com.helloplantmanagment.Repository.PlantRepository;
import ironhack.com.helloplantmanagment.model.Plant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j

public class PlantService {
    private final PlantRepository plantRepository;
    public List<Plant> findAll() {
        return plantRepository.findAll();
    }

    //Add a single plant
    public Plant addPlant(Plant plant) {
        log.info("Adding new plant{}", plant);
        return plantRepository.save(plant);
    }

    //Delete a plant
    public void deletePlant(Long plantId) {
        log.info("Deleting plant with id{}", plantId);
        plantRepository.deleteById(plantId);
    }

    //Update a plant
    public Plant updatePlant(Long plantId, Plant plant) {
        log.info("updating plant with id{}", plantId);
        var plantToUpdate = plantRepository.findById(plantId).orElseThrow();
        plantToUpdate.setName(plant.getName());
        plantToUpdate.setSpecies(plant.getSpecies());
        plantToUpdate.setQuantity(plant.getQuantity());
        plantToUpdate.setLocationId(plantToUpdate.getLocationId());
        plantToUpdate.setWorkerId(plantToUpdate.getWorkerId());
        return plantRepository.save(plantToUpdate);
    }


}
