package br.com.yanmuller.controllers;

import br.com.yanmuller.models.Person;
import br.com.yanmuller.services.PersonServices;
import br.com.yanmuller.vo.v1.PersonVOV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices personServices;

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonVOV1> findById(@PathVariable Long id) {
        return ResponseEntity.ok(personServices.findById(id));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<PersonVOV1>> findAll() {
        return ResponseEntity.ok(personServices.findAll());
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonVOV1> create(@RequestBody PersonVOV1 person) {
        return ResponseEntity.ok(personServices.create(person));
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonVOV1> update(@RequestBody PersonVOV1 person) {
        return ResponseEntity.ok(personServices.update(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }

}
