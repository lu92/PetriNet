package com.ScheduleSystem.domain.employees.filters;

/**
 * Created by SG0222895 on 8/5/2015.
 */
public class EmployeeFilter extends AbstractFilter
{
    public EmployeeFilter()
    {
    }

    public EmployeeFilter(Criteria... criterias)
    {
        super(criterias);
    }

    public EmployeeFilter withAddressCriteria(AddressCriteria ... addressCriteria){
        addCriteria(addressCriteria);
        return this;
    }

    public EmployeeFilter withNameAndLastnameCriteria(NameAndLastnameCriteria ... nameAndLastnameCriteria) {
        addCriteria(nameAndLastnameCriteria);
        return this;
    }

    public EmployeeFilter withRoleCriteria(RoleCriteria ... roleCriteria) {
        addCriteria(roleCriteria);
        return this;
    }

    public EmployeeFilter withPrivilegeCriteria(PrivilegeCriteria ... privilegeCriteria) {
        addCriteria(privilegeCriteria);
        return this;
    }

    public EmployeeFilter withHaveLeaveCriteria(HaveLeaveCriteria ... haveLeaveCriteria) {
        addCriteria(haveLeaveCriteria);
        return this;
    }
}
