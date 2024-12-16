package br.com.yanmuller.estudospringbootcomjavaaula3.controllers;

import br.com.yanmuller.estudospringbootcomjavaaula3.data.vo.v1.PersonVO;
import br.com.yanmuller.estudospringbootcomjavaaula3.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/person")
    public class PersonController {

        @Autowired
        private PersonServices personServices;

        @GetMapping("/{id}")
        public ResponseEntity<PersonVO> findById(@PathVariable Long id) {
            return ResponseEntity.ok(personServices.findById(id));
        }

        @GetMapping
        public ResponseEntity<List<PersonVO>> findAll() {
            return ResponseEntity.ok(personServices.findAll());
        }

        @PostMapping
        public ResponseEntity<PersonVO> create(@RequestBody PersonVO person) {
            return ResponseEntity.ok(personServices.create(person));
        }

        @PutMapping
        public ResponseEntity<PersonVO> update(@RequestBody PersonVO person) {
            return ResponseEntity.ok(personServices.update(person));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            personServices.delete(id);
            return ResponseEntity.noContent().build();
        }
    }


