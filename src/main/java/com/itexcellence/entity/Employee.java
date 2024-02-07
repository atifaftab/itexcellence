package com.itexcellence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Employee  implements Serializable {
    @Id
    private String id;
    private String name;
    private String email;
    private String position;
    private double salary;
//    private String departmentId;
    @ManyToOne( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

}
