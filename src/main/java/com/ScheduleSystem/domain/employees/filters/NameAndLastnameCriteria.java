package com.ScheduleSystem.domain.employees.filters;

import com.ScheduleSystem.domain.employees.Employee;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0222895 on 7/28/2015.
 */
public class NameAndLastnameCriteria implements Criteria
{
    private String name, lastname;

    public NameAndLastnameCriteria(String name, String lastname)
    {
        this.name = name;
        this.lastname = lastname;
    }

    @Override public Set<Employee> doFilter(Set<Employee> employeeStorage)
    {
        Set<Employee> employeesFindedByNameAndLastName = new HashSet<>();
        for (Employee employee : employeeStorage)
            if (employee.getName().equals(name) && employee.getLastname().equals(lastname))
                employeesFindedByNameAndLastName.add(employee);
        return employeesFindedByNameAndLastName;
    }
}
