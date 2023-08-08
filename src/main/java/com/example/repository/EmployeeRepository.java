package com.example.repository;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    public String addEmployee(Employee employee);

    public List<Employee> getEmployees();

    public Employee getEmployee(long id);

    public boolean updateEmployee(Employee employee, long empId);

    public boolean deleteEmployee(long id);

}
