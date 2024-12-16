package br.com.yanmuller.estudospringbootcomjavaaula3.repositories;

import br.com.yanmuller.estudospringbootcomjavaaula3.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Long id(Long id);
}
