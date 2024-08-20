package com.simayuygur.springbootlearning.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simayuygur.springbootlearning.data.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
//for register

@Getter
@Setter

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column(name = "system_auto_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;

}
