package com.ScheduleSystem.domain.employees.builders;

import com.ScheduleSystem.domain.employees.Address;
import com.ScheduleSystem.domain.employees.Employee;
import com.ScheduleSystem.domain.employees.EmployeeType;
import com.ScheduleSystem.domain.employees.Leave;
import com.ScheduleSystem.domain.employees.Manager;
import com.ScheduleSystem.domain.employees.Role;
import org.joda.time.LocalDate;

import java.util.Arrays;

/**
 * Created by SG0222895 on 7/28/2015.
 */
public abstract class AbstractEmployeeBuilder
{
    protected Employee employee;
    protected EmployeeType employeeType;

    protected AbstractEmployeeBuilder(EmployeeType employeeType, String name, String lastname, String birth, String email, String telephoneNumber, Address address) {
        this.employeeType = employeeType;
        switch (employeeType) {
            case EMPLOYEE:
                employee = new Employee(name, lastname, birth, email, telephoneNumber, address);
                break;
            case MANAGER:
                employee = new Manager(name, lastname, birth, email, telephoneNumber, address);
                break;
        }

        employee.setUsername(name+lastname);
        employee.setPassword(name+lastname);
        init();
    }

    public AbstractEmployeeBuilder(String name, String lastname, LocalDate birth, String email, String telephoneNumber, Address address)
    {
    }

    protected AbstractEmployeeBuilder(EmployeeType employeeType, String name, String lastname, String username, String password, String email, String birth, String telephoneNumber, Address address) {
        this(employeeType, name, lastname, birth, email, telephoneNumber, address);
        employee.setUsername(username);
        employee.setPassword(password);
        init();
    }

    public AbstractEmployeeBuilder(String name, String lastname, String username, String password, String email, LocalDate birth, String telephoneNumber, Address address)
    {
    }


    protected abstract void init();

    public void addRole(Role ... roles) {
        employee.getRoleStorage().addAll(Arrays.asList(roles));
    }

    public void removeRole(Role ... roles) {
        employee.getRoleStorage().removeAll(Arrays.asList(roles));
    }

    public void addLeave(Leave leave) {
        employee.addLeave(leave);
    }


    public AbstractEmployeeBuilder withName(String name) {
        employee.setName(name);
        return this;
    }

    public AbstractEmployeeBuilder withLastname(String lastname) {
        employee.setLastname(lastname);
        return this;
    }

    public AbstractEmployeeBuilder withEmail(String email) {
        employee.setEmail(email);
        return this;
    }

    public AbstractEmployeeBuilder withBirth(LocalDate birth) {
        employee.setBirth(birth);
        return this;
    }

    public AbstractEmployeeBuilder withTelephoneNumber(String telephoneNumber) {
        employee.setTelephoneNumber(telephoneNumber);
        return this;
    }

    public  AbstractEmployeeBuilder withAddress(Address address) {
        employee.setAddress(address);
        return this;
    }

    public Employee getBuildResult() {
        return employee;
    }
}
