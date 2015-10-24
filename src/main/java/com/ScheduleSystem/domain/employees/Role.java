package com.ScheduleSystem.domain.employees;

import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0222895 on 7/21/2015.
 */
@Data
public final class Role
{
    private Long id;
    private String name;
    private Set<Privilege> privilegeStorage = new HashSet<>();

    public Role()
    {
    }

    public Role(String name)
    {
        this.name = name;
    }

    public void addPrivilege(Privilege ... privileges) {
        privilegeStorage.addAll(Arrays.asList(privileges));
    }

    public void addPrivilege(String ... privileges) {
        for (String privilegeName : privileges)
            privilegeStorage.add(new Privilege(privilegeName));
    }

    public void removePrivilege(Privilege ... privileges) {
        privilegeStorage.removeAll(Arrays.asList(privileges));
    }
}
