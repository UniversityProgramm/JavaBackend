package com.Task15.controller;

import com.Task15.dto.Message;
import com.Task15.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {
    @Autowired
    private MessageRepository repository;

    @GetMapping("/message")
    public Iterable<Message> getMessages() {
        return repository.findAll();
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        repository.save(message);
        return message;
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        if (repository.existsById(id)) {
            message.setId(id);
            return new ResponseEntity<>(repository.save(message), HttpStatus.OK);
        } else {
            repository.save(message);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        repository.deleteById(id);
    }
}
