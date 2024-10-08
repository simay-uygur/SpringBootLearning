package com.simayuygur.springbootlearning.business.services;

import com.simayuygur.springbootlearning.business.dto.EmployeeDto;
import com.simayuygur.springbootlearning.data.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface EmployeeServices {

    //CRUD
    public List<EmployeeDto> getAllEmployees();

    //list
    //http:/localhost:8080/api/v1/index
 /*   @GetMapping({"/index", "/"})
    String getRoot();
*/
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id) throws Throwable;
    public ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto) throws Throwable;
    public ResponseEntity<EmployeeDto> deleteEmployee(Long id) throws Throwable;


    //model mapper
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity);
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto);
}
