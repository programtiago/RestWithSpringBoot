package com.example.restwithspringbootudemy.service;

import com.example.restwithspringbootudemy.exception.ResourceNotFoundException;
import com.example.restwithspringbootudemy.data.model.Person;
import com.example.restwithspringbootudemy.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll()
    {
        return repository.findAll();
    }

    public Person findById(Long id)
    {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Records not found with the id " + id));
    }

    public Person create(Person person)
    {
        return repository.save(person);
    }

    public Person update(Person person)
    {
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id)
    {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        repository.delete(entity);
    }
}
