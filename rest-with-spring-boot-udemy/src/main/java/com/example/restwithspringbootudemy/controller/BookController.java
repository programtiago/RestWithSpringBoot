package com.example.restwithspringbootudemy.controller;

import com.example.restwithspringbootudemy.data.model.Book;
import com.example.restwithspringbootudemy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book/v1")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml"})
    public Book findById(@PathVariable("id") Long id)
    {
        return service.findById(id);
    }

    @GetMapping(produces = { "application/json", "application/xml"})
    public List<Book> findAll()
    {
        return service.findAll();
    }

    @PostMapping(produces = { "application/json", "application/xml"},
    consumes  = { "application/json", "application/xml"})
    public Book create(@RequestBody Book book)
    {
        return service.create(book);
    }

    @PutMapping(produces = { "application/json", "application/xml"},
            consumes  = { "application/json", "application/xml"})
    public Book update(@RequestBody Book b)
    {
        return service.update(b);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") Long id)
    {
        service.delete(id);
        return ResponseEntity.ok().build();
    }




}
