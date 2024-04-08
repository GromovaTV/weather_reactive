package ru.job4j.weather.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.weather.model.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("select distinct p from person p left join fetch p.roles where p.login=?1")
    Person findPersonByLogin(String login);

    @Override
    @Query("select distinct p from person p left join fetch p.roles where p.id=?1")
    Optional<Person> findById(Integer integer);

    @Override
    @Query("select distinct p from person p left join fetch p.roles")
    Iterable<Person> findAll();
}