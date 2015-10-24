package com.ScheduleSystem.domain.employees.filters;

import com.ScheduleSystem.domain.employees.Employee;

import java.util.Set;

/**
 * Created by SG0222895 on 7/28/2015.
 */
public interface Criteria
{
    Set<Employee> doFilter(Set<Employee> employeeStorage);
}
