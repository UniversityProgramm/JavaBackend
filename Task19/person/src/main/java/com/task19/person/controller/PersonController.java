package com.task19.person.controller;

import com.task19.person.model.Person;
import com.task19.person.model.Weather;
import com.task19.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${location.url}")
    String locationUrl;

    @GetMapping("{id}/weather")
    public ResponseEntity<Weather> getWeather(@PathVariable int id) {
        if (repository.existsById(id)) {
            String location = repository.findById(id).get().getLocation();
            String url = String.format("http://%s/location/weather?name=", locationUrl);
            Weather weather = restTemplate.getForObject(url + location, Weather.class);
            return new ResponseEntity<>(weather, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        repository.findAll().forEach(persons::add);
        return persons;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable int id) {
        Optional<Person> personOptional = repository.findById(id);
        if (personOptional.isPresent()) {
            return ResponseEntity.ok(personOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return repository.findById(person.getId()).isPresent()
                ? new ResponseEntity(repository.findById(person.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(repository.save(person), HttpStatus.CREATED);
    }

    @PutMapping(("/{id}"))
    public ResponseEntity<Person> update(@PathVariable int id, @RequestBody Person person) {
        Optional <Person> personOptional = repository.findById(id);
        if (personOptional.isPresent()) {
            Person personToUpdate = personOptional.get();
            personToUpdate.setFirstname(person.getFirstname());
            personToUpdate.setLastname(person.getLastname());
            personToUpdate.setSurname(person.getSurname());
            personToUpdate.setBirthday(person.getBirthday());
            personToUpdate.setLocation(person.getLocation());
            return ResponseEntity.ok(repository.save(personToUpdate));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable int id) {
        Optional<Person> personOptional = repository.findById(id);
        if (personOptional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}