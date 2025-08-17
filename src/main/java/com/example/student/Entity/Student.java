package com.example.student.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // The @Id annotation specifies that this field is the primary key of the entity.
    // The @GeneratedValue annotation indicates that the value of this field will be generated automatically,
    // typically by the database. The strategy used here is GenerationType.IDENTITY
    private Long  id;
    private String name;
    private String email;
}
