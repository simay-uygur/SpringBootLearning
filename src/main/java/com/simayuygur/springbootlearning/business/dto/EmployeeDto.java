package com.simayuygur.springbootlearning.business.dto;

import com.simayuygur.springbootlearning.data.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;  

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class EmployeeDto extends BaseEntity implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String emailId;
}
