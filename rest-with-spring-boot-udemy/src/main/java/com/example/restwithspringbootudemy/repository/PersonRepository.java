package com.example.restwithspringbootudemy.repository;

import com.example.restwithspringbootudemy.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
