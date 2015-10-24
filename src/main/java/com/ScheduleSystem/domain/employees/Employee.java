package com.ScheduleSystem.domain.employees;

import com.ScheduleSystem.tools.StringToLocalDate;
import lombok.Data;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0222895 on 7/26/2015.
 */
@Data
public class Employee
{
    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private LocalDate birth;
    private String telephoneNumber;
    private Address address;
    private Set<Role> roleStorage = new HashSet<>();
    private Set<Leave> leaveStorage = new HashSet<>();
    private int leaveDays = 26;

    private static StringToLocalDate stringToLocalDate = new StringToLocalDate();

    public Employee()
    {
    }

    public Employee(String name, String lastname)
    {
        this.name = name;
        this.lastname = lastname;
    }

    public Employee(String name, String lastname, String birth, String email, String telephoneNumber, Address address)
    {
        this(name, lastname);
        if (birth == null)
            birth = "";

        this.birth = DateTimeFormat.forPattern("yyyy/MM/dd").parseLocalDate(birth);
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public Employee(String name, String lastname, String username, String password, String email, String birth, String telephoneNumber, Address address)
    {
        this(name, lastname, birth, email, telephoneNumber, address);
        this.username = username;
        this.password = password;
    }


    public void addLeave(Leave leave) {
        if (leaveDays > 0)
        {
            int days = new Period(leave).getDays();
            if (leaveDays - days >= 0)
            {
                this.leaveStorage.add(leave);
                leaveDays -= days;
            }
            else
                throw new IllegalArgumentException("leave is too long");
        } else throw new IllegalArgumentException("employee " + name + " " + lastname + " consumed all leave");
    }

    public boolean haveLeaveOnSelectedTerm(LocalDate beginDate, LocalDate endDate) {
        for (Leave leave : leaveStorage) {
//            if (leave)
        }
        return false;
    }
}
