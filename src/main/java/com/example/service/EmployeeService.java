package com.example.service;

import com.example.configuration.AerospikeConfiguration;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class EmployeeService implements EmployeeRepository {

    @Inject
    private AerospikeConfiguration aerospikeConfiguration;

    @Override
    public String addEmployee(Employee employee) {
        aerospikeConfiguration.getMapper().save(employee);
        return "Employee Added Successfully with Employee Id : "+employee.getEmpId();
    }

    @Override
    public List<Employee> getEmployees() {
        return aerospikeConfiguration.getMapper().scan(Employee.class);
    }

    @Override
    public Employee getEmployee(long id) {
        Employee employee = aerospikeConfiguration.getMapper().read(Employee.class, id);
        return employee;
    }

    @Override
    public boolean updateEmployee(Employee employee,long empId) {
        Employee updateEmployee = aerospikeConfiguration.getMapper().read(Employee.class, empId);
        if(empId == employee.getEmpId()){
            updateEmployee.setEmpName(employee.getEmpName());
            updateEmployee.setEmpMail(employee.getEmpMail());
            updateEmployee.setEmpNumber(employee.getEmpNumber());
            updateEmployee.setEmpAge(employee.getEmpAge());
            updateEmployee.setSal(employee.getSal());
            updateEmployee.setjDate(employee.getjDate());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(long empId) {
        Employee deleteEmployee = aerospikeConfiguration.getMapper().read(Employee.class, empId);
        if(deleteEmployee != null){
            aerospikeConfiguration.getMapper().delete(empId);
            return true;
        }
        return false;
    }

}
