package com.Task16.service;

import com.Task16.dto.Message;
import com.Task16.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    MessageRepository repository;

    public Iterable<Message> getAllMessages() {
        return repository.findAll();
    }

    public Optional<Message> getMessageById(int id) {
        return repository.findById(id);
    }

    public Message addMessage(Message message) {
        return repository.save(message);
    }

    public ResponseEntity<Message> updateMessage(int id, Message message) {
        if (repository.existsById(id)) {
            message.setId(id);
            return new ResponseEntity<>(repository.save(message), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(repository.save(message), HttpStatus.CREATED);
        }
    }

    public void deleteMessage(int id) {
        repository.deleteById(id);
    }
}
