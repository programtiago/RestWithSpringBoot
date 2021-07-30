package com.example.restwithspringbootudemy.service;

import com.example.restwithspringbootudemy.data.model.Book;
import com.example.restwithspringbootudemy.exception.ResourceNotFoundException;
import com.example.restwithspringbootudemy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll()
    {
        return repository.findAll();
    }

    public Book findById(Long id)
    {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Records not found with the id " + id));
    }

    public Book create(Book book)
    {
        return repository.save(book);
    }

    public Book update(Book book)
    {
        Book entity = repository.findById(book.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        return repository.save(entity);
    }

    public void delete(Long id)
    {
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        repository.delete(entity);
    }
}
