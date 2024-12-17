package br.com.yanmuller.mapper.custom;

import br.com.yanmuller.models.Person;
import br.com.yanmuller.vo.v2.PersonVOV2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonVOV2 convertEntityToVO(Person person) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setBirthday(new Date());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());

        return vo;
    }

    public Person convertVOToEntity(PersonVOV2 vo) {
        Person person = new Person();
        person.setId(vo.getId());
        person.setFirstName(vo.getFirstName());
        person.setLastName(vo.getLastName());
        //aqui seria o birthday
        person.setAddress(vo.getAddress());
        person.setGender(vo.getGender());
        return person;
    }
}
