package ironhack.com.helloplantmanagment.contoller;


import ironhack.com.helloplantmanagment.model.Location;
import ironhack.com.helloplantmanagment.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor

public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public List<Location> findAll(){
        return locationService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location addLocation(@RequestBody @Valid Location location){
        return locationService.addLocation(location);
    }

    @PutMapping("/{locationId}")
    public Location updateLocation(@PathVariable("locationId") Long locationId,
                                   @RequestBody Location location){
        return locationService.updateLocation(locationId, location);
    }

    @DeleteMapping("/{locationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocation(@PathVariable("locationId") Long locationId){
        locationService.deleteLocation(locationId);
    }

}
