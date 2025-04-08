package com.task19.location.controller;

import com.task19.location.model.Location;
import com.task19.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationRepository repository;

    @GetMapping
    public Iterable<Location> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location) {
        return repository.findById(location.getId()).isPresent()
                ? new ResponseEntity(repository.findById(location.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(repository.save(location), HttpStatus.CREATED);
    }
}
