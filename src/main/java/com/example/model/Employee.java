package com.example.model;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
@AerospikeRecord(namespace="test", set="Employee")
public class Employee {
    @AerospikeKey

    private long empId;
    private String empName;
    private String empMail;
    private long empNumber;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date jDate;
    private double sal;
    private int empAge;

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpMail() {
        return empMail;
    }

    public void setEmpMail(String empMail) {
        this.empMail = empMail;
    }

    public long getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(long empNumber) {
        this.empNumber = empNumber;
    }

    public Date getjDate() {
        return jDate;
    }

    public void setjDate(Date jDate) {
        this.jDate = jDate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public Employee() {
    }

    public Employee(long empId, String empName, String empMail, long empNumber, Date jDate, double sal, int empAge) {
        this.empId = empId;
        this.empName = empName;
        this.empMail = empMail;
        this.empNumber = empNumber;
        this.jDate = jDate;
        this.sal = sal;
        this.empAge = empAge;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empMail='" + empMail + '\'' +
                ", empNumber=" + empNumber +
                ", jDate=" + jDate +
                ", sal=" + sal +
                ", empAge=" + empAge +
                '}';
    }
}
