package com.example.controller;

import com.example.model.CustomeResponse;
import com.example.model.Employee;
import com.example.service.EmployeeService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.List;

import static io.micronaut.http.HttpResponse.status;

@Controller("/api")
public class EmployeeController {

    @Inject
    private EmployeeService employeeService;

    @Get(produces = MediaType.APPLICATION_JSON, uri = "/employees")
    public HttpResponse<List<Employee>> getAllEmployees(){
        List<Employee> list=employeeService.getEmployees();

        if(list.size() != 0){
            return HttpResponse.status(HttpStatus.OK).body(list);
        }
        return HttpResponse.status(HttpStatus.NOT_FOUND);
    }

    @Get(produces = MediaType.APPLICATION_JSON, uri = "/employee/{id}")
    public HttpResponse<Employee> getEmployeeById(@PathVariable("id") long empId){
        Employee employee=employeeService.getEmployee(empId);

        if(employee!=null){
            return HttpResponse.status(HttpStatus.OK).body(employee);
        }
        return HttpResponse.status(HttpStatus.NOT_FOUND);
    }

    @Post(produces = MediaType.APPLICATION_JSON, uri = "/employee")
    public HttpResponse<CustomeResponse> createEmployee(@Body Employee employee){
        if(employee != null){
            return HttpResponse.status(HttpStatus.CREATED).body(new CustomeResponse(employeeService.addEmployee(employee)));
        }
        return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomeResponse("Error"));
    }

    @Put(produces = MediaType.APPLICATION_JSON, uri = "/employee/{id}")
    public HttpResponse<CustomeResponse> updateEmployee(Employee employee, @PathVariable("id") long empId){
        boolean status=employeeService.updateEmployee(employee, empId);

        if(status == true) {
            return HttpResponse.status(HttpStatus.OK).body(new CustomeResponse("Employee updated successfully"));
        }
        return HttpResponse.status(HttpStatus.OK).body(new CustomeResponse("Employee not updated successfully"));
    }

    @Delete(produces = MediaType.APPLICATION_JSON, uri = "/employee/{id}")
    public HttpResponse<CustomeResponse> deleteEmployee(@PathVariable("id") long empId){
        boolean status=employeeService.deleteEmployee(empId);
        if(status == true) {
            return HttpResponse.status(HttpStatus.OK).body(new CustomeResponse("Employee deleted successfully"));
        }
        return HttpResponse.status(HttpStatus.OK).body(new CustomeResponse("Employee not deleted successfully"));
    }

}
