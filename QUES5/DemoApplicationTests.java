package com.example.springdata.employee;

import com.example.springdata.employee.entities.Employee;
import com.example.springdata.employee.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestEntityManager
class DemoApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Employee employee=new Employee();
		Employee employee1=new Employee();
		Employee employee2=new Employee();



		employee.setId(1);
		employee.setName("HONEY");
		employee.setAge(22);
		employee.setLocation("kichha");


		employee1.setId(2);
		employee1.setName("RADHA");
		employee1.setAge(25);
		employee1.setLocation("delhi");

		employee2.setId(3);
		employee2.setName("VIJAY");
		employee2.setAge(24);
		employee2.setLocation("nainital");

		repository.save(employee);
		repository.save(employee1);
		repository.save(employee2);
	}

	@Test
	public void testUpdate(){
		Employee employee=repository.findById(3).get();
		employee.setName("AKASH");
		repository.save(employee);
	}

	@Test
	public void testDelete(){
		repository.deleteById(3);
	}
}
