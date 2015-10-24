package com.ScheduleSystem.domain.employees;

import lombok.Data;
import org.joda.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0222895 on 7/21/2015.
 */
@Data
public class Person
{
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private LocalDate birth;
    private String telephoneNumber;
    private Address address;
    private Set<Role> roleStorage = new HashSet<>();

    public Person()
    {
    }

    public Person(String name, String lastname)
    {
        this.name = name;
        this.lastname = lastname;
    }

    public Person(String name, String lastname, LocalDate birth, String telephoneNumber, Address address)
    {
        this(name, lastname);
        this.birth = birth;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public Person(String name, String lastname, String username, String password, String email, LocalDate birth, String telephoneNumber, Address address)
    {
        this(name, lastname, birth, telephoneNumber, address);
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Person(Long id, String name, String lastname, LocalDate birth, String telephoneNumber, Address address)
    {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birth = birth;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }
}
