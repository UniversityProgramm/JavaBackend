package com.task19.location.controller;

import com.task19.location.model.Location;
import com.task19.location.model.Weather;
import com.task19.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationRepository repository;
    @Autowired
    private RestTemplate restTemplate;

    //http://localhost:8083/location/weather?name=Saransk
    @GetMapping("/weather")
    public ResponseEntity<Weather> redirectRequestWeather(@RequestParam String name) {
        Optional<Location> optionalLocation = repository.findByName(name);
        if (optionalLocation.isPresent()) {
            Location location = optionalLocation.get();
            String url = String.format("http://weather-info-service/weather?lat=%s&lon=%s", location.getLatitude(), location.getLongitude());
            return new ResponseEntity<>(restTemplate.getForObject(url, Weather.class), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Location> getAllLocation() {
        List<Location> locations = new ArrayList<>();
        repository.findAll().forEach(locations::add);
        return locations;
    }

    //http://localhost:8083/location/name?name=Saransk
    @GetMapping("/name")
    public Optional<Location> getLocationByName(@RequestParam String name) {
        return repository.findByName(name);
    }

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location) {
        Optional<Location> locationOptional = repository.findByName(location.getName());
        if (locationOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repository.save(location));
    }

    @PutMapping()
    public ResponseEntity<Location> updateLocation(@RequestParam String name, @RequestBody Location location) {
        Optional<Location> locationOptional = repository.findByName(name);
        if (locationOptional.isPresent()) {
            Location locationToUpdate = locationOptional.get();
            locationToUpdate.setLatitude(location.getLatitude());
            locationToUpdate.setLongitude(location.getLongitude());
            return ResponseEntity.ok(repository.save(locationToUpdate));
        }
        return ResponseEntity.notFound().build();
    }

    //http://localhost:8083/location?name=Moscow
    @DeleteMapping()
    public ResponseEntity<Location> deleteLocation(@RequestParam String name) {
        Optional<Location> locationOptional = repository.findByName(name);
        if (locationOptional.isPresent()) {
            repository.delete(locationOptional.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}