package com.ScheduleSystem.domain.employees.filters;

import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0222895 on 7/28/2015.
 */
@Data
public abstract class AbstractFilter
{
    protected Set<Criteria> allCriteria = new HashSet<>();

    public AbstractFilter()
    {
    }

    public AbstractFilter(Criteria ... criterias)
    {
        addCriteria(criterias);
    }


    public void addCriteria(Criteria ... criterias) {
        allCriteria.addAll(Arrays.asList(criterias));
    }

    public void removeCriteria(Criteria ... criterias) {
        for (Criteria criteria : criterias)
            removeCriteria(criteria);
    }

    public void removeCriteria(Criteria criteria) {
        if (criteria == null)
            throw new IllegalArgumentException("criteria cannot be null");
        else
            allCriteria.remove(criteria);
    }

    public boolean isEmpty() {
        return allCriteria.isEmpty();
    }

    public void clearCriteria() {
        allCriteria.clear();
    }
}
