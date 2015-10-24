package com.ScheduleSystem.domain.employees;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0222895 on 7/21/2015.
 */
@Data
public class Privilege
{
    private Long id;
    private String privilege;
    private Set<Role> roleStorage = new HashSet<>();

    public Privilege()
    {
    }

    public Privilege(String privilegeName)
    {
        this.privilege = privilegeName;
    }

    @Override public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Privilege privilege1 = (Privilege) o;
        return privilege.equals(privilege1.privilege);
    }

    @Override public int hashCode()
    {
        return privilege.hashCode();
    }
}
