package com.example.exceptionhandling.controller;

import com.example.exceptionhandling.CustomException.BusinessException;
import com.example.exceptionhandling.CustomException.ControllerException;
import com.example.exceptionhandling.entity.Employee;
import com.example.exceptionhandling.service.EmployeeServiceInter;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/code")
public class EmployeeController {

    @Autowired
    private EmployeeServiceInter employeeServiceInter;


    @PostMapping("/save")
    public ResponseEntity<?> savetoDB(@RequestBody Employee employee) {
            Employee employee1 = employeeServiceInter.addEmployee(employee);
            return new ResponseEntity<>(employee1, HttpStatus.CREATED);


    }


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllRecords() {
        List<Employee> employees = employeeServiceInter.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }



    @GetMapping("/all/{id}")
    public ResponseEntity<?> getByID(@PathVariable int id) {
            Employee employee = employeeServiceInter.getById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);

    }




    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> delTheEmployee(@PathVariable int id) {
        employeeServiceInter.deleteEmp(id);
        return new ResponseEntity<>("*---Deleted-----*", HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeServiceInter.addEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }


}
