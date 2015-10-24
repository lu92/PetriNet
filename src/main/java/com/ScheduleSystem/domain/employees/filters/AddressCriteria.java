package com.ScheduleSystem.domain.employees.filters;

import com.ScheduleSystem.domain.employees.Address;
import com.ScheduleSystem.domain.employees.Employee;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0222895 on 7/28/2015.
 */
public class AddressCriteria implements Criteria
{
    private Address address;

    public AddressCriteria(Address address)
    {
        this.address = address;
    }

    @Override public Set<Employee> doFilter(Set<Employee> employeeStorage)
    {
        Set<Employee> employeesFindedByAddress = new HashSet<>();
        for (Employee employee : employeeStorage)
            if (employee.getAddress().equals(address))
                employeesFindedByAddress.add(employee);
        return employeesFindedByAddress;
    }
}
