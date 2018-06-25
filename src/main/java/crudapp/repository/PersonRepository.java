package crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import crudapp.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}