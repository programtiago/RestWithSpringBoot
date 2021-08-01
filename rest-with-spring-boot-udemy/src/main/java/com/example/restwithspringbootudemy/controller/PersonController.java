package com.example.restwithspringbootudemy.controller;

import com.example.restwithspringbootudemy.data.model.Person;
import com.example.restwithspringbootudemy.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Person Endpoint", tags = {"PersonEndpoint"})
@RestController
@RequestMapping(value = "api/person/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml"})
    public Person findById(@PathVariable("id") Long id)
    {
        return personService.findById(id);
    }

    @ApiOperation(value = "Find all people recorded")
    @GetMapping(produces = { "application/json", "application/xml"})
    public List<Person> findAll()
    {
        return personService.findAll();
    }

    @PostMapping(produces = { "application/json", "application/xml"},
    consumes  = { "application/json", "application/xml"})
    public Person create(@RequestBody Person person)
    {
        return personService.create(person);
    }

    @PutMapping(produces = { "application/json", "application/xml"},
            consumes  = { "application/json", "application/xml"})
    public Person update(@RequestBody Person p)
    {
        return personService.update(p);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") Long id)
    {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }




}
