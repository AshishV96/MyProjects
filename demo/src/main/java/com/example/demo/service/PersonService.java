package com.example.demo.service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repo;
    public Person create(Person person)
    {
        return repo.save(person);
    }

}
