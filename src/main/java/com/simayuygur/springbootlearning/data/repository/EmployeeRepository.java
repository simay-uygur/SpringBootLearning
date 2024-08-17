package com.simayuygur.springbootlearning.data.repository;

import com.simayuygur.springbootlearning.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository > CrudRepository
@Repository
public interface  EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
