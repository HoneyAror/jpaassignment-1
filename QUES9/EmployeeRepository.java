package com.example.springdata.employee.repos;

import com.example.springdata.employee.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    List<Employee> findByname(String name);
}
