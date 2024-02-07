package com.itexcellence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Department implements Serializable {

    @Id
    private String id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "department",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Employee> employees;
}
