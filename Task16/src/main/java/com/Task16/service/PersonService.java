package com.Task16.service;

import com.Task16.dto.Message;
import com.Task16.dto.Person;
import com.Task16.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    public Iterable<Person> getAllPersons(){
        return repository.findAll();
    }

    public Optional<Person> getPersonById(int id) {
        return repository.findById(id);
    }

    public ResponseEntity<List<Message>> getAllMessagesForPerson(int id) {
        return new ResponseEntity<>(repository.findById(id).get().getMessages(), HttpStatus.OK);
    }

    public ResponseEntity<Message> getMessageForPerson(int p_id, int m_id) {
        if (!repository.existsById(p_id)) {return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        Person person = repository.findById(p_id).get();
        Message messageToSearch = new Message();
        boolean flag = false;
        for (Message message : person.getMessages()) {
            if (message.getId() == m_id) {
                messageToSearch = message;
                flag = true;
                break;
            }
        }
        if (!flag) {return new ResponseEntity<>(HttpStatus.BAD_REQUEST);};
        return new ResponseEntity<>(messageToSearch, HttpStatus.OK);
    }

    public Person addPerson(Person person) {
        repository.save(person);
        return person;
    }

    public ResponseEntity<Person> addMessage(int id, Message message) {
        if (repository.existsById(id)) {
            Person person = repository.findById(id).get();
            message.setPerson(person);
            message.setTime(LocalDateTime.now());
            person.addMessage(message);
            return new ResponseEntity<>(repository.save(person), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(null);
    }

    public ResponseEntity<Person> updatePerson(int id, Person person) {
        if (repository.existsById(id)) {
            person.setId(id);
            return new ResponseEntity<>(repository.save(person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(repository.save(person), HttpStatus.CREATED);
        }
    }

    public HttpStatus deleteMessageFromPerson(int p_id, int m_id) {
        if (!repository.existsById(p_id)) {return HttpStatus.BAD_REQUEST;}
        Person person = repository.findById(p_id).get();
        Message messageToDelete = new Message();
        boolean flag = false;
        for (Message message : person.getMessages()) {
            if (message.getId() == m_id) {
                messageToDelete = message;
                flag = true;
                break;
            }
        }
        if (!flag) {return HttpStatus.BAD_REQUEST;};
        person.removeMessage(messageToDelete);
        repository.save(person);
        return HttpStatus.OK;
    }

    public void deletePerson(int id) {
        repository.deleteById(id);
    }

}