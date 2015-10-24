package com.ScheduleSystem.UnitTests.filters;

import com.ScheduleSystem.domain.employees.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by SG0222895 on 8/5/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/employeeConfig.xml")
public class EmployeeFilterTest
{
    @Autowired
    private Employee employee;

    @Test
    public void test() {
        System.out.println(employee);
    }

}
