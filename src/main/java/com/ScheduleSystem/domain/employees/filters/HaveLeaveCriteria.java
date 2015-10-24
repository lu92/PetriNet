package com.ScheduleSystem.domain.employees.filters;

import com.ScheduleSystem.domain.employees.Employee;
import org.joda.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0222895 on 7/28/2015.
 */
public class HaveLeaveCriteria implements Criteria
{
    private LocalDate beginDate;
    private LocalDate endDate;

    public HaveLeaveCriteria(LocalDate beginDate, LocalDate endDate)
    {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    @Override public Set<Employee> doFilter(Set<Employee> employeeStorage)
    {
        Set<Employee> employeesWhichHaveLeave = new HashSet<>();
        for (Employee employee : employeeStorage) {
//            if (employee.ge)
        }
        return employeesWhichHaveLeave;
    }
}
