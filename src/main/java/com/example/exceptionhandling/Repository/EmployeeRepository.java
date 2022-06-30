package com.example.exceptionhandling.Repository;

import com.example.exceptionhandling.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
