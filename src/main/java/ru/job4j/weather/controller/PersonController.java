package ru.job4j.weather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.weather.model.Person;
import ru.job4j.weather.repository.PersonRepository;
import ru.job4j.weather.repository.RoleRepository;

@RestController
@RequestMapping("/users")
@Validated
public class PersonController {

    private static final Logger LOG =
            LoggerFactory.getLogger(PersonController.class.getSimpleName());
    private final PersonRepository persons;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;
    private final ObjectMapper objectMapper;

    public PersonController(PersonRepository persons, RoleRepository roleRepository,
                            BCryptPasswordEncoder encoder, ObjectMapper objectMapper) {
        this.persons = persons;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Person> signUp(@RequestBody Person person) {
        person.setPassword(encoder.encode(person.getPassword()));
        Person save = persons.save(person);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
