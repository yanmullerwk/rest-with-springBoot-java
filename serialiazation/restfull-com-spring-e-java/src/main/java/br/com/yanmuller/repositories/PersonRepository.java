package br.com.yanmuller.repositories;

import br.com.yanmuller.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Long id(Long id);
}
