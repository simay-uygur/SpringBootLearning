package com.simayuygur.springbootlearning.data.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@Builder
@Log4j2
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name" ,nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String surname;

    @Column(name = "email_name", nullable = false)
    private String emailId;

    public EmployeeEntity(Long id, String name, String surname, String emailId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.emailId = emailId;
    }
}
