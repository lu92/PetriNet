package com.ScheduleSystem.domain.employees.builders;

import com.ScheduleSystem.domain.employees.Address;
import com.ScheduleSystem.domain.employees.Employee;
import com.ScheduleSystem.domain.employees.EmployeeType;
import com.ScheduleSystem.domain.employees.Manager;
import com.ScheduleSystem.domain.employees.Role;
import org.joda.time.LocalDate;

/**
 * Created by SG0222895 on 7/28/2015.
 */
public class ManagerBuilder extends AbstractEmployeeBuilder
{
    public ManagerBuilder(String name, String lastname, String birth, String email, String telephoneNumber, Address address)
    {
        super(EmployeeType.MANAGER, name, lastname, birth, email, telephoneNumber, address);
    }

    public ManagerBuilder(String name, String lastname, String username, String password, String email, String birth, String telephoneNumber, Address address)
    {
        super(EmployeeType.MANAGER, name, lastname, username, password, email, birth, telephoneNumber, address);
    }

    @Override public Manager getBuildResult()
    {
        return (Manager) super.getBuildResult();
    }

    @Override protected void init()
    {
        Role employeeRole = new Role("employee");
        employeeRole.addPrivilege("LoginToTheSystem", "WatchingTheWorkflow", "SubmitTask", "ExecuteTask");

        Role managerRole = new Role("manager");
        managerRole.addPrivilege("CreateWorkflow", "CreateTask", "ManageEmployee");

        this.addRole(employeeRole, managerRole);
    }
}
