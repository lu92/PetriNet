package com.ScheduleSystem.UnitTests;

import com.ScheduleSystem.domain.employees.Address;
import com.ScheduleSystem.domain.employees.Employee;
import com.ScheduleSystem.domain.employees.Manager;
import com.ScheduleSystem.domain.employees.builders.AbstractEmployeeBuilder;
import com.ScheduleSystem.domain.employees.builders.EmployeeBuilder;
import com.ScheduleSystem.domain.employees.builders.ManagerBuilder;
import junit.framework.Assert;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SG0222895 on 7/28/2015.
 */
public class EmployeeBuilderTest
{
    private AbstractEmployeeBuilder employeeBuilder;
    private AbstractEmployeeBuilder managerBuilder;

    @Before
    public void initEmployee() {
        employeeBuilder = new EmployeeBuilder("Adam", "Nowak",
                "1980/10/21", "adam.nowak@gmail.com", "123456789",
                new Address("Poland", "Warsaw", "Wiejska", "23-456"));

        managerBuilder = new ManagerBuilder("Wojciech", "Seliga",
                "1970/01/01", "wojciech.seliga@spartez.com", "987654321",
                new Address("Poland", "Warsaw", "wiejska", "23-787"));
    }

    @Test
    public void validateEmployee() {
        Assert.assertNotNull(employeeBuilder);
        Assert.assertNotNull(employeeBuilder.getBuildResult());
        Assert.assertTrue(employeeBuilder.getBuildResult() instanceof Employee);

        Assert.assertEquals("Adam", employeeBuilder.getBuildResult().getName());
        Assert.assertEquals("Nowak", employeeBuilder.getBuildResult().getLastname());

        Assert.assertEquals("AdamNowak", employeeBuilder.getBuildResult().getUsername());
        Assert.assertEquals("AdamNowak", employeeBuilder.getBuildResult().getPassword());

        Assert.assertEquals(employeeBuilder.getBuildResult().getBirth(), new LocalDate(1980, 10, 21));
        Assert.assertEquals(employeeBuilder.getBuildResult().getAddress(), new Address("Poland", "Warsaw", "Wiejska", "23-456"));
    }

    @Test
    public void withMethodsFromBuilderTest() {
        employeeBuilder.withName("Piotr").withLastname("Kowalski").withBirth(new LocalDate(1965, 9, 11))
                .withAddress(new Address("United States", "New York", "Wall Street", "12-990"));

        Assert.assertEquals("Piotr", employeeBuilder.getBuildResult().getName());
        Assert.assertEquals("Kowalski", employeeBuilder.getBuildResult().getLastname());
        Assert.assertEquals(new LocalDate(1965, 9, 11), employeeBuilder.getBuildResult().getBirth());
        Assert.assertEquals(new Address("United States", "New York", "Wall Street", "12-990"), employeeBuilder.getBuildResult().getAddress());
    }

    @Test
    public void validateManager() {
        Assert.assertNotNull(managerBuilder.getBuildResult());
        Assert.assertTrue(managerBuilder.getBuildResult() instanceof Manager);

//        Manager manager = (Manager) managerBuilder.getBuildResult();
    }


}
