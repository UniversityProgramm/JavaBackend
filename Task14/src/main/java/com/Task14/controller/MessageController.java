package com.Task14.controller;

import com.Task14.dto.Message;
import com.Task14.dto.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {
    private List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message(1, "Work", "Hello", LocalDateTime.of(2023, 7, 11, 9, 1, 0)),
            new Message(2, "School", "Hi!", LocalDateTime.of(2017, 5, 6, 17, 0, 10)),
            new Message(3, "Homework", "Good morning", LocalDateTime.of(2020, 2, 2, 10, 1, 5)),
            new Message(4, "University", "Good evening", LocalDateTime.of(2021, 3, 26, 18, 32, 0))
    ));

    @GetMapping("/message")
    public Iterable<Message> getMessages() {
        return messages;
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return messages.stream().filter(p -> p.getId() == id).findFirst();
    }


    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        int index = - 1;
        for (Message m : messages) {
            if (m.getId() == id) {
                index = messages.indexOf(m);
                messages.set(index, message);
            }
        }
        return index == -1
                ? new ResponseEntity<>(addMessage(message), HttpStatus.CREATED)
                : new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        messages.removeIf(p -> p.getId() == id);
    }
}
