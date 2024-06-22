package ironhack.com.helloplantmanagment.contoller;


import ironhack.com.helloplantmanagment.model.Plant;
import ironhack.com.helloplantmanagment.service.PlantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
@RequiredArgsConstructor

public class PlantController {
    private final PlantService plantService;

    @GetMapping
    public List<Plant> findAll() {
        return plantService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Plant addPlant(@RequestBody @Valid Plant plant){
        return plantService.addPlant(plant);
    }

    @PutMapping("/{plantId}")
    public Plant updatePlant(@PathVariable("plantId") Long plantId,
                             @RequestBody Plant plant){
        return plantService.updatePlant(plantId, plant);
    }

    @DeleteMapping("/{plantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlant(@PathVariable("plantId") Long plantId){
        plantService.deletePlant(plantId);
    }

}
