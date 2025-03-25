package com.Task16.controller;

import com.Task16.dto.Message;
import com.Task16.repository.MessageRepository;
import com.Task16.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {
    @Autowired
    private MessageService service;

    @GetMapping("/message")
    public Iterable<Message> getMessages() {
        return service.getAllMessages();
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return service.getMessageById(id);
    }

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        return service.addMessage(message);
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        return service.updateMessage(id, message);
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        service.deleteMessage(id);
    }
}
