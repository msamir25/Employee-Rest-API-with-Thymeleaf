package com.luv2code.springboot.thymeleafdemo;


import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class ThymeleafdemoApplicationTests {

	private EmployeeRepository employeeRepository;
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepository);
	List<Employee> theEmployees = employeeService.findAll();
	List<Employee> newEmployees = new ArrayList<>();

	@Test
	void itShouldAddNumbers() {


	}



	class Calculator {
		int add(int a, int b){
			return a+b;
		}
	}

}
