package crudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crudapp.model.Person;
import crudapp.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findOne(Long id) {
        return personRepository.getOne(id);
    }

    public Person save(Person questionCategory) {
        return personRepository.save(questionCategory);
    }

    public void delete(Long id) {
    	personRepository.deleteById(id);
    }
}
