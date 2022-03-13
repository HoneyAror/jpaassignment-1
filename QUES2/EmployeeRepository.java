package com.example.springdata.employee.repos;

import com.example.springdata.employee.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}
