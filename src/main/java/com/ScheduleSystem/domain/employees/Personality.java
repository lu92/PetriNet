package com.ScheduleSystem.domain.employees;

import lombok.Data;
import org.joda.time.LocalDate;

/**
 * Created by SG0222895 on 7/28/2015.
 */
@Data
public class Personality
{
    //  do nadawania przy AbstractEmployeeBuilder
    private String name;
    private String lastname;
    private String email;
    private LocalDate birth;
    private String telephoneNumber;
    private Address address;

    public Personality(String name, String lastname, String email, LocalDate birth, String telephoneNumber, Address address)
    {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birth = birth;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }
}
