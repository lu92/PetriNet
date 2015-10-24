package com.ScheduleSystem.domain.employees;


/**
 * Created by SG0222895 on 7/26/2015.
 */
public class Manager extends Employee
{
    public Manager()
    {
    }

    public Manager(String name, String lastname)
    {
        super(name, lastname);
    }

    public Manager(String name, String lastname, String birth, String email, String telephoneNumber, Address address)
    {
        super(name, lastname, birth, email, telephoneNumber, address);
    }

    public Manager(String name, String lastname, String username, String password, String email, String birth, String telephoneNumber, Address address)
    {
        super(name, lastname, username, password, email, birth, telephoneNumber, address);
    }
}
