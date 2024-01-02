package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;



    @Test
    public void EmployeeRpository_SaveAll_ReturnSvedEmployee(){

        //arrange
        Employee theEmployee = new Employee("Mohamed " ,
                                            "samir " ,
                                               "Msamir25@org.com");

        //Act
        Employee employee = employeeRepository.save(theEmployee);

        //assert
        assertThat(employee).isNotNull();
    }

    @Test
    public void EmployeeRepository_findAll_ReturnMoreThanEmployee(){
        //arrange
        Employee theEmployee = new Employee("Mohamed " ,
                "samir " ,
                "Msamir25@org.com");
        Employee theEmployee2 = new Employee("Mohamed " ,
                "sami " ,
                "Msami30@org.com");

        //Act
        employeeRepository.save(theEmployee);
        employeeRepository.save(theEmployee2);

        List<Employee> Employees = employeeRepository.findAll();

        //assert
        assertThat(Employees).isNotNull();
        assertThat(Employees.size()).isEqualTo(2);

    }

    @Test
    public void EmployeeRepository_findById_ReturnEmployee(){
        //arrange
        Employee theEmployee = new Employee("Mohamed " ,
                "samir " ,
                "Msamir25@org.com");

        //Act
        employeeRepository.save(theEmployee);

        Employee Employees = employeeRepository.findById(theEmployee.getId()).get();

        //assert
        //assertThat(Employees).isNotNull();

        assertEquals(true , Employees);

    }


    @Test
    public void EmployeeRepository_findById_updateEmployee(){
        //arrange
        Employee theEmployee = new Employee("Mohamed " ,
                "samir " ,
                "Msamir25@org.com");

        //Act
        employeeRepository.save(theEmployee);

        Employee employees = employeeRepository.findById(theEmployee.getId()).get();
        employees.setFirstName("ahmed ");
        employees.setLastName("malik ");

        Employee updatedEmployee = employeeRepository.save(employees);

        //assert
        assertThat(updatedEmployee.getFirstName()).isNotNull();
        assertThat(updatedEmployee.getLastName()).isNotNull();

    }


    @Test
    public void EmployeeRepository_findById_deleteEmployee(){
        //arrange
        Employee theEmployee = new Employee("Mohamed " ,
                "samir " ,
                "Msamir25@org.com");

        //Act
        employeeRepository.save(theEmployee);

        employeeRepository.deleteById(theEmployee.getId());

        Optional<Employee> employeeOptional = employeeRepository.findById(theEmployee.getId());

        //assert
        assertThat(employeeOptional).isEmpty();

    }




}








