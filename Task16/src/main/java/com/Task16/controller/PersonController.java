package com.Task16.controller;

import com.Task16.dto.Person;
import com.Task16.dto.Message;
import com.Task16.repository.PersonRepository;
import com.Task16.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping("/person")
    public Iterable<Person> getPersons() {
        return service.getAllPersons();
    }

    @GetMapping("/person/{id}")
    public Optional<Person> findPersonById(@PathVariable int id) {
        return service.getPersonById(id);
    }

    @GetMapping("/person/{p_id}/message")
    public ResponseEntity<List<Message>> getMessagesForPerson(@PathVariable int p_id) {
        return service.getAllMessagesForPerson(p_id);
    }

    @GetMapping("/person/{p_id}/message/{m_id}")
    public ResponseEntity<Message> getMessageForPerson(@PathVariable int p_id, @PathVariable int m_id) {
        return service.getMessageForPerson(p_id, m_id);
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        return service.addPerson(person);
    }

    @PostMapping("/person/{p_id}/message")
    public ResponseEntity<Person> addMessage(@PathVariable int p_id, @RequestBody Message message) {
        return service.addMessage(p_id, message);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        return service.updatePerson(id, person);
    }

    @DeleteMapping("/person/{m_id}/message/{p_id}")
    public ResponseEntity<HttpStatus> deleteMessage(@PathVariable int m_id, @PathVariable int p_id) {
       return new ResponseEntity<>(service.deleteMessageFromPerson(m_id, p_id));
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {
        service.deletePerson(id);
    }
}