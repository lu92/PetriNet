package com.ScheduleSystem.domain.employees.filters;

import com.ScheduleSystem.domain.employees.Employee;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0222895 on 8/5/2015.
 */
public class TelephoneNumberCriteria implements Criteria
{
    private String regex;

    public TelephoneNumberCriteria(String regex)
    {
        this.regex = regex;
    }

    @Override public Set<Employee> doFilter(Set<Employee> employeeStorage)
    {
        Set<Employee> correctEmployee = new HashSet<>();
        for (Employee employee : employeeStorage) {
            if (employee.getTelephoneNumber().matches(regex))
                correctEmployee.add(employee);
        }
        return correctEmployee;
    }
}
