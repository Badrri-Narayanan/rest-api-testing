package com.restApi.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "book name cannot be null")
    @NotBlank(message = "book name cannot be blank")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "author name cannot be null")
    @NotBlank(message = "author name cannot be blank")
    private String author;
}
