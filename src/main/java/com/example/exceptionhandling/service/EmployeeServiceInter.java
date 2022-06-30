package com.example.exceptionhandling.service;

import com.example.exceptionhandling.entity.Employee;

import java.util.List;

public interface EmployeeServiceInter {


    public Employee addEmployee(Employee employee);

    public List<Employee> getAll();

    public Employee getById(int id);

    public void deleteEmp(int id);
}
