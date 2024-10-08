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
public class EmployeeEntity extends BaseEntity {

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;

    @Column(name = "email_name")
    private String emailId;


    public EmployeeEntity(String name, String surname, String emailId) {
        this.name = name;
        this.surname = surname;
        this.emailId = emailId;
    }
}
