package ru.job4j.weather.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity(name = "u_role")
@Table(name = "u_role")
@Data
@RequiredArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String role;

    public static Role of(String role) {
        Role auth = new Role();
        auth.role = role;
        return auth;
    }

    @Override
    public String toString() {
        return "Role{"
                + "id=" + id
                + ", role='" + role + '\''
                + '}';
    }
}