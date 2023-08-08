package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import io.micronaut.http.HttpStatus;
import io.micronaut.test.annotation.MockBean;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class EmployeeControllerTest {

    @Inject
    EmployeeController controller;

    @MockBean
    EmployeeService employeeService;

    @Test
    void getAllEmployees() {
        when(employeeService.getEmployees())
                .thenReturn((Stream.of(new Employee(10001,"Ruturaj","rrr@gmail.com",800760842, new Date(),50000.88,25),
                                new Employee(10002,"Sham","rrr@gmail.com",800760842, new Date(),50000.88,25))
                        .collect(Collectors.toList())));

        List<Employee> employees = (List<Employee>) controller.getAllEmployees();
        assertEquals(2,employees.size());
    }


    @Test
    void getEmployeeById() {
        long employeeId = 10001L;
        when(employeeService.getEmployee(employeeId))
               .thenReturn(new Employee(10001,"Ruturaj","rrr@gmail.com",800760842, new Date(),50000.88,25));
        assertEquals(HttpStatus.OK,controller.getEmployeeById(employeeId).status());
    }
}