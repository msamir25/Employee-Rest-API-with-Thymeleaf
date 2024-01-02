package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void employeeService_save_ReturnEmployee(){
        Employee employee = new Employee("mo " , "Samir" , "msamir@gmail");

        when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);

        EmployeeServiceImpl employeeService1 = employeeService;
        employeeService1.save(employee);
        Assertions.assertThat(employeeService1).isNotNull();


    }

    @Test
    public void employeeService_findAll_ReturnAllEmployee(){
        employeeService.findAll();

        verify(employeeRepository).findAllByOrderByLastNameAsc();

    }

}