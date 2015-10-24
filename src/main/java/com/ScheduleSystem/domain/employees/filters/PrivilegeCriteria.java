package com.ScheduleSystem.domain.employees.filters;

import com.ScheduleSystem.domain.employees.Employee;
import com.ScheduleSystem.domain.employees.Privilege;
import com.ScheduleSystem.domain.employees.Role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0222895 on 7/28/2015.
 */
public class PrivilegeCriteria implements Criteria
{
    private Set<Privilege> privilegeStorage = new HashSet<>();

    public PrivilegeCriteria(Privilege ... privileges)
    {
        this.privilegeStorage = new HashSet<>(Arrays.asList(privileges));
    }

    @Override public Set<Employee> doFilter(Set<Employee> employeeStorage)
    {
        Set<Employee> employeesFindedByPrivileges = new HashSet<>();
        Set<Privilege> allPrivilegesWhichBelongsToEmployee = new HashSet<>();
        for (Employee employee : employeeStorage) {
            for (Role role : employee.getRoleStorage()) {
                allPrivilegesWhichBelongsToEmployee.addAll(role.getPrivilegeStorage());
            }
        }

        for (Employee employee : employeeStorage) {
            if (allPrivilegesWhichBelongsToEmployee.contains(privilegeStorage))
                employeesFindedByPrivileges.add(employee);
        }

        return employeesFindedByPrivileges;
    }
}
