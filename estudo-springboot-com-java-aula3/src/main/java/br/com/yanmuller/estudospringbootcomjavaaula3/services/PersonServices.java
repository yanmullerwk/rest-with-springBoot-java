package br.com.yanmuller.estudospringbootcomjavaaula3.services;

import br.com.yanmuller.estudospringbootcomjavaaula3.Exceptions.ResourseNotFoundExceptions;
import br.com.yanmuller.estudospringbootcomjavaaula3.model.Person;
import br.com.yanmuller.estudospringbootcomjavaaula3.repositories.PersonRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices{


    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    public Person findById(Long id){
        logger.info("finding one person");

        return personRepository.findById(id).orElseThrow(()-> new ResourseNotFoundExceptions("No person found with id: " + id));
    }

    public List<Person> findAll(){
        logger.info("finding all persons");

        return personRepository.findAll();
    }

    public Person create(Person person){
        logger.info("creating person");
        return personRepository.save(person);
    }

    public Person upDate(Person person){
        logger.info("updating person");
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourseNotFoundExceptions("No person found with id: " + person.getId()));
        entity.setFirstName(person.getFirstName());
        entity.setSurname(person.getSurname());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return personRepository.save(person);
    }

    public void delete(Long id){
        logger.info("deleting person");
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourseNotFoundExceptions("No person found with id: " + id));
        personRepository.delete(entity);
    }



}
