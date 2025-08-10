package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deptno")
    private Integer id;
    @Column(name = "deptname")
    private String name;
    @Column(name = "deptdescription")
    private String description;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
