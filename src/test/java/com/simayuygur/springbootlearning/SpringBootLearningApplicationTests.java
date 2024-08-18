package com.simayuygur.springbootlearning;

import com.simayuygur.springbootlearning.data.entity.EmployeeEntity;
import com.simayuygur.springbootlearning.data.repository.EmployeeRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.TestCrud;

@SpringBootTest
class  SpringBootLearningApplicationTests implements TestCrud {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

    @Override
    public void testCreate() {
        EmployeeEntity employeeEntity = EmployeeEntity
                .builder()
                .name("Simay TEST")
                .surname("Uygur TEST")
                .emailId("emil@test.com")
                .build();
        employeeRepository.save(employeeEntity);
        assertNotNull(employeeRepository.findById(1L).get());
    }

    @Override
    public void testUpdate() {

    }

    @Override
    public void testDelete() {

    }

    @Override
    public void testList() {

    }

    @Override
    public void testFindById() {

    }
}
