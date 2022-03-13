package com.example.springdata.employee;

import com.example.springdata.employee.entities.Employee;
import com.example.springdata.employee.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

		employee.setName("HONEY");
		employee.setAge(22);
		employee.setLocation("kichha");


		employee1.setName("RADHA");
		employee1.setAge(25);
		employee1.setLocation("delhi");

		employee2.setName("VIJAY");
		employee2.setAge(24);
		employee2.setLocation("nainital");

		repository.save(employee);
		repository.save(employee1);
		repository.save(employee2);
	}

	@Test
	public void testUpdate(){
		Employee employee=repository.findById(17).get();
		employee.setName("AKASH");
		repository.save(employee);
	}

	@Test
	public void testUpdateage(){
		Employee employee=repository.findById(16).get();
		employee.setAge(30);
		repository.save(employee);
	}

	@Test
	public void testDelete(){
		repository.deleteById(13);
	}

	@Test
	public void testRead(){
		Employee employee=repository.findById(2).get();
		assertNotNull(employee);
		System.out.println(">>"+employee.getLocation());
	}

	@Test
	public  void testCount(){
		System.out.println("TOTAL EMPLOYEE ARE:  "+repository.count());
	}


	@Test
	public void testfindbyname(){
		List<Employee> emp=repository.findByname("RADHA");
		emp.forEach(e->System.out.println(e.getLocation()));
	}

	@Test
	public void testfindbyagegreaterthan(){
		List<Employee> emp=repository.findByageGreaterThan(22);
		emp.forEach(e->System.out.println(e.getLocation()));
	}

	@Test
	public  void testfindbyagebetween(){
		List<Employee> emp=repository.findByageBetween(28,32);
		emp.forEach(e->System.out.println(e.getName()));
	}
	@Test
	public  void testfindbynamelike(){
		List<Employee> emp=repository.findBynameLike("A%");
		emp.forEach(e->System.out.println(e.getName()));
	}

	@Test
	public void testfindallPaging(){
		Pageable pageable= PageRequest.of(0, 1);
		Page<Employee> result=repository.findAll(pageable);
		result.forEach(p-> System.out.println(p.getName()));
	}

	//on the basis of age
	@Test
	public void testfindallPagingandSorting(){
		Pageable pageable=PageRequest.of(0,2, Sort.Direction.DESC,"age");
		repository.findAll(pageable).forEach(p-> System.out.println(p.getName()));

	}








}
