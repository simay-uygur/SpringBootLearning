package com.simayuygur.springbootlearning;

import com.simayuygur.springbootlearning.data.entity.EmployeeEntity;
import com.simayuygur.springbootlearning.data.repository.EmployeeRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.TestCrud;

import java.util.List;

@SpringBootTest
class  SpringBootLearningApplicationTests implements TestCrud {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

    @Test
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

    //find by id
    @Test
    @Override
    public void testFindById() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        assertEquals("Simay TEST", employeeEntity.getName());
    }

    @Test
    @Override
    public void testList() {
        List<EmployeeEntity> list = employeeRepository.findAll();
        assertThat(list).size().isGreaterThan(0);   // is not null also works i guess
    }

    @Test
    @Override
    public void testUpdate() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        employeeEntity.setName("Updated TEST");
        employeeRepository.save(employeeEntity);
        assertEquals("Updated TEST", employeeRepository.findById(1L).get().getName());
    }

    @Test
    @Override
    public void testDelete()  {
        employeeRepository.deleteById(1L);
        assertThat(employeeRepository.existsById(1L)).isFalse();
    }
}
