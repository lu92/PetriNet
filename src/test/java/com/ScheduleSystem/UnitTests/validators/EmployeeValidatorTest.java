package com.ScheduleSystem.UnitTests.validators;

import com.ScheduleSystem.domain.employees.Address;
import com.ScheduleSystem.domain.employees.Employee;
import com.ScheduleSystem.domain.employees.Role;
import com.ScheduleSystem.domain.employees.builders.EmployeeBuilder;
import com.ScheduleSystem.validators.EmployeeValidator;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Created by SG0222895 on 8/4/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = EmployeeValidatorConfig.class)
@ContextConfiguration(locations = "/employeeValidatorConfig.xml")
public class EmployeeValidatorTest
{
    @Autowired
    private EmployeeValidator employeeValidator;

    private EmployeeBuilder employeeBuilder;

    @Test
    public void validEmployeeTest() {
        Role role = new Role("Java Developer");
        role.addPrivilege("Spring Framework", "JSP", "Java 8");

        employeeBuilder = new EmployeeBuilder("Adam", "Nowak",
                "1980/10/21", "adam.nowak@gmail.com", "123456789",
                new Address("Poland", "Warsaw", "Wiejska", "23-456"));
        Employee employee = employeeBuilder.getBuildResult();

        Errors errors = new BeanPropertyBindingResult(employee, "employee validation");
        ValidationUtils.invokeValidator(employeeValidator, employee, errors);
        Assert.assertEquals(0, errors.getErrorCount());

    }

    @Test
    public void employeeWithoutAddress() {
        employeeBuilder = new EmployeeBuilder("Adam", "Nowak",
                "1980/10/21", "adam.nowak@gmail.com", "123456789", null);

        Employee employee = employeeBuilder.getBuildResult();

        Errors errors = new BeanPropertyBindingResult(employee, "employee validation");
        ValidationUtils.invokeValidator(employeeValidator, employee, errors);
        Assert.assertEquals(4, errors.getFieldErrorCount());
    }


    @Test
    public void employeeWithNegativeNumberOfLeaveDaysTest() {
        employeeBuilder = new EmployeeBuilder("Adam", "Nowak",
                "1980/10/21", "adam.nowak@gmail.com", "123456789",
                new Address("Poland", "Warsaw", "Wiejska", "23-456"));
        Employee employee = employeeBuilder.getBuildResult();

        Errors errors = new BeanPropertyBindingResult(employee, "employee validation");

        ReflectionTestUtils.setField(employee, "leaveDays", -1);    //  important tool

        ValidationUtils.invokeValidator(employeeValidator, employee, errors);
        Assert.assertEquals(1, errors.getErrorCount());
        Assert.assertEquals("leaveDays", errors.getFieldError("leaveDays").getField());
    }

}
