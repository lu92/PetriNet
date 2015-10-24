package com.ScheduleSystem.domain.employees.filters;

import com.ScheduleSystem.domain.employees.Employee;
import com.ScheduleSystem.domain.employees.Role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0222895 on 7/28/2015.
 */
public class RoleCriteria implements Criteria
{
    private Set<Role> roleStorage = new HashSet<>();

    public RoleCriteria(Role ... roles)
    {
        roleStorage.addAll(Arrays.asList(roles));
    }

    @Override public Set<Employee> doFilter(Set<Employee> employeeStorage)
    {
        Set<Employee> employeesFindedByRole = new HashSet<>();
        for (Employee employee : employeeStorage)
            if (employee.getRoleStorage().contains(roleStorage))
                employeesFindedByRole.add(employee);
        return employeesFindedByRole;
    }
}
