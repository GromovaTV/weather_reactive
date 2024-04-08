package ru.job4j.weather.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity(name = "person")
@DynamicUpdate
@Table(name = "person")
@Data
@RequiredArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String login;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "persons_roles",
            joinColumns = @JoinColumn(name = "person_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private List<Role> roles;

    public static Person of(int id, String login, String password) {
        Person person = new Person();
        person.setId(id);
        person.setLogin(login);
        person.setPassword(password);
        return person;
    }

    @Override
    public String toString() {
        return "Person{"
                + "id=" + id
                + ", login='" + login + '\''
                + ", password='" + password + '\''
                + ", roles='" + roles + '\''
                + '}';
    }
}