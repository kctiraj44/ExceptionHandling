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
        try {
            Employee employee1 = employeeServiceInter.addEmployee(employee);
            return new ResponseEntity<>(employee1, HttpStatus.CREATED);
        }
        catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException ce = new ControllerException("612","Something went wrong in controller");
            return  new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
    }





    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllRecords() {
        List<Employee> employees = employeeServiceInter.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }



    @GetMapping("/all/{id}")
    public ResponseEntity<?> getByID(@PathVariable int id) {
        try {
            Employee employee = employeeServiceInter.getById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException ce = new ControllerException("612","Something went wrong in controller");
            return  new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
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
