package com.simayuygur.springbootlearning.business.services.impl;


import com.simayuygur.springbootlearning.business.dto.EmployeeDto;
import com.simayuygur.springbootlearning.business.services.EmployeeServices;
import com.simayuygur.springbootlearning.data.entity.EmployeeEntity;
import com.simayuygur.springbootlearning.data.repository.EmployeeRepository;
import com.simayuygur.springbootlearning.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//database processes are done here

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    //list
    //http:/localhost:8080/api/v1/employees
    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        Iterable<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        for (EmployeeEntity employeeEntity : employeeEntities) {
            EmployeeDto employeeDto = entityToDto(employeeEntity);
            employeeDtoList.add(employeeDto);
        }
        
        return employeeDtoList;
    }

    //save
    //http:/localhost:8080/api/v1/employees/1
    @PostMapping("/employees")
    @Override
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDto);
        employeeRepository.save(employeeEntity);
        return null;
    }


    //find
    //http:/localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) throws Throwable {
        EmployeeEntity employeeEntity = (EmployeeEntity) employeeRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id " +id));
        EmployeeDto employeeDto = entityToDto(employeeEntity);
        return ResponseEntity.ok(employeeDto);
    }

    //update
    //http:/localhost:8080/api/v1/employees
    @PutMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) throws Throwable {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDto);
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).
                 orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id " +id + " for update"));
        employee.setName(employeeEntity.getName());
        employee.setSurname(employeeEntity.getSurname());
        employee.setEmailId(employeeEntity.getEmailId());

        EmployeeEntity updatedEmployee = (EmployeeEntity) employeeRepository.save(employee);
        EmployeeDto updatedEmployeeDto = entityToDto(updatedEmployee);

        return ResponseEntity.ok(updatedEmployeeDto);
    }

    @DeleteMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> deleteEmployee(Long id) throws Throwable {
        EmployeeEntity employeeEntity = (EmployeeEntity) employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id " +id + " for deletion"));
        employeeRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        EmployeeDto employeeDto = entityToDto(employeeEntity);

        return ResponseEntity.ok(employeeDto) ;
    }



    //////////////////////////////////////////////////////////////////////////
    //ModelMapper
    //entity ==> dto
    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = modelMapper.map(employeeEntity, EmployeeDto.class);
        return employeeDto;
    }

    //dto ==> entity
    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        return employeeEntity;
    }
}
