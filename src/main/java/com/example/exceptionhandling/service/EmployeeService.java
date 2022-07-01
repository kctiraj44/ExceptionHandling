package com.example.exceptionhandling.service;

import com.example.exceptionhandling.CustomException.BusinessException;
import com.example.exceptionhandling.CustomException.EmptyInputException;
import com.example.exceptionhandling.Repository.EmployeeRepository;
import com.example.exceptionhandling.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService implements EmployeeServiceInter {

    @Autowired
    private EmployeeRepository repository;


    @PostConstruct
    public void saveTheData() {
        List<Employee> list = Stream.of(new Employee(12, "JAPAN"),
                new Employee(23, "USA"),
                new Employee(56, "NEPAL")).collect(Collectors.toList());
        repository.saveAll(list);
    }


    @Override
    public Employee addEmployee(Employee employee) {

            if(employee.getName().isEmpty() || employee.getName().length()==0){
                throw new EmptyInputException("601","Please Send Proper name,Its Blank");
            }
            Employee employee1 = repository.save(employee);
            return employee1;

    }

    @Override
    public List<Employee> getAll() {
        try {
            List<Employee> empList = repository.findAll();
            if(empList.isEmpty()){
                throw new BusinessException("604","Hey list is completely empty");
            }
            return empList;
        }catch (Exception ex){
            throw new BusinessException("605","Something went wrong is service layer while Fetching"+ex.getMessage());
        }
    }

    @Override
    public Employee getById(int id) {

            Employee employee = repository.findById(id).get();
            return employee;



    }

    @Override
    public void deleteEmp(int id) {
        repository.deleteById(id);
    }
}
