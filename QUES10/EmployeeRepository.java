package com.example.springdata.employee.repos;

import com.example.springdata.employee.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    List<Employee> findByname(String name);

    List<Employee> findByageGreaterThan(int age);

    List<Employee> findByageBetween(int age1,int age2);

    List<Employee> findBynameLike(String name);

}
