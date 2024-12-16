package br.com.yanmuller.estudospringbootcomjavaaula3.services;

import br.com.yanmuller.estudospringbootcomjavaaula3.Exceptions.ResourseNotFoundExceptions;
import br.com.yanmuller.estudospringbootcomjavaaula3.data.vo.v1.PersonVO;

import br.com.yanmuller.estudospringbootcomjavaaula3.mapper.DozerMapper;
import br.com.yanmuller.estudospringbootcomjavaaula3.model.Person;
import br.com.yanmuller.estudospringbootcomjavaaula3.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.logging.Logger;

@Service
public class PersonServices{


    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    public PersonVO findById(Long id){
        logger.info("finding one person");

        var entity = personRepository.findById(id);

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll(){
        logger.info("finding all persons");

        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class) ;
    }

    public PersonVO create(PersonVO person){
        logger.info("creating person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person){
        logger.info("updating person");
        var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourseNotFoundExceptions("No person found with id: " + person.getId()));
        entity.setFirstName(person.getFirstName());
        entity.setSurname(person.getSurname());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }


    public void delete(Long id){
        logger.info("deleting person");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourseNotFoundExceptions("No person found with id: " + id));
        personRepository.delete(entity);
    }

}
