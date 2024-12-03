package org.example.java_spring_hw_4.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Класс пользователя
 */
@Data
@Entity
@Table(name="userTable")
public class User {
    /**
     * Поле идентификатора
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Поле имени
     */
    @Column(name = "firstName", nullable = false)
    private String firstName;

    /**
     * Поле фамилии
     */
    @Column(name = "lastName", nullable = false)
    private String lastName;
}
