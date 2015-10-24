package com.ScheduleSystem.domain.taskmanagment.petrinet.CE;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by SG0222895 on 10/4/2015.
 */
@Data
public class Case implements Cloneable {
    private Set<Condition> conditionSet = new HashSet<>();

    public Case() {
    }

    public Case(Set<Condition> conditionSet) {
        this.conditionSet = conditionSet;
    }

    public Case(Condition ... conditions) {
        conditionSet.addAll(Arrays.asList(conditions));
    }

    public void addCondition(Condition ... conditions) {
        conditionSet.addAll(Arrays.asList(conditions));
    }

    public void removeCondition(Condition ... conditions) {
        conditionSet.removeAll(Arrays.asList(conditions));
    }

    public boolean isEventBelongToCase(Event event) {
        return conditionSet.containsAll(event.getMinimumCase().getConditionSet());
    }

    public boolean isEventActive(Event event) {
        if (!isEventBelongToCase(event))
            throw new IllegalArgumentException("Event doesn't belong to case");
        return conditionSet.containsAll(event.getMinimumCase().getConditionSet()) && this.getIntersection(event.getNextCase()).isEmpty();
//        return conditionSet.containsAll(event.getMinimumCase().getConditionSet()) && conditionSet.retainAll(event.getNextCase().getConditionSet())? true : false;
    }

    public Case getIntersection(Case anotherCase) {
        Set<Condition> intersection = this.conditionSet.stream().filter(anotherCase.getConditionSet()::contains).collect(Collectors.toSet());
        return new Case(intersection);
    }

    public static Case getIntersection(Case case1, Case case2) {
        Set<Condition> intersection = case1.conditionSet.stream().filter(case2.getConditionSet()::contains).collect(Collectors.toSet());
        return new Case(intersection);
    }

    public int size() {
        return conditionSet.size();
    }
    public boolean isEmpty() {
        return conditionSet.isEmpty();
    }


}
