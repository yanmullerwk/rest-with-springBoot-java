package br.com.yanmuller.services;

import br.com.yanmuller.exceptions.ResourceNotFoundException;
import br.com.yanmuller.mapper.DozerMapper;
import br.com.yanmuller.mapper.custom.PersonMapper;
import br.com.yanmuller.models.Person;
import br.com.yanmuller.repositories.PersonRepository;
import br.com.yanmuller.vo.v1.PersonVOV1;
import br.com.yanmuller.vo.v2.PersonVOV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;

    public PersonVOV1 findById(Long id){
        logger.info("Finding one person");

        // Busca a entidade e lança uma exceção se não encontrar
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No person found with id: " + id));

        // Converte a entidade encontrada para o VO
        return DozerMapper.parseObject(entity, PersonVOV1.class);
    }

    public List<PersonVOV1> findAll(){
        logger.info("finding all persons");

        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVOV1.class) ;
    }

    public PersonVOV1 create(PersonVOV1 person){
        logger.info("creating person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVOV1.class);
        return vo;
    }
    public PersonVOV2 createV2(PersonVOV2 person){
        logger.info("creating person");
        var entity = personMapper.convertVOToEntity(person);
        var vo = personMapper.convertEntityToVO(personRepository.save(entity));
        return vo;
    }

    public PersonVOV1 update(PersonVOV1 person){
        logger.info("updating person");
        var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No person found with id: " + person.getId()));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVOV1.class);
        return vo;
    }


    public void delete(Long id){
        logger.info("deleting person");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No person found with id: " + id));
        personRepository.delete(entity);
    }

}
