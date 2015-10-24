package com.ScheduleSystem.domain.taskmanagment.petrinet.CE;

import lombok.Data;
import lombok.Getter;

import java.util.*;

/**
 * Created by SG0222895 on 10/3/2015.
 */
@Data
public class CEPetriNet extends PetriObject {
    private String description;
    private Set<Condition> conditionSet = new HashSet<>();
    private Set<Event> eventSet = new HashSet<>();
    private @Getter Set<Arc> arcSet = new HashSet<>();

    public CEPetriNet() {
    }

    public CEPetriNet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Optional<Condition> findCondition(String conditionName) {
        return conditionSet.stream().filter(condition -> condition.getName().equals(conditionName)).findFirst();
    }

    public Optional<Set<Condition>> findConditions(String ... conditionNames) {
        Set<Condition> findedConditions = new HashSet<>();
        List<String> names = Arrays.asList(conditionNames);
        for (Condition condition : conditionSet) {
            if (names.contains(condition.getName()))
                findedConditions.add(condition);
        }
        return Optional.of(findedConditions);
    }

    public Optional<Event> findEvent(String eventName) {
        return eventSet.stream().filter(event -> event.getName().equals(eventName)).findFirst();
    }

    public int getNumberOfConditions() {
        return conditionSet.size();
    }

    public int getNumberOfEvents() {
        return eventSet.size();
    }

    public int getNumberOfArcs() {
        return arcSet.size();
    }

    public boolean isEvensActiveInCase(Case someCase, Event ... events) {
        for (Event event : events)
            if (!isEvenActiveInCase(someCase, event))
                return false;
        return true;
    }

    public boolean isEvenActiveInCase(Case someCase, Event event) {
        return someCase.isEventActive(event);
    }

    public boolean isEventBelongToNet(Event event) {
        return eventSet.contains(event);
    }

    public boolean isConditionBelongToNet(Condition condition) {
        return conditionSet.contains(condition);
    }

    public void printAllEvents() {
        for (Event event : eventSet)
            System.out.println(event);
    }

    public void printAllConditions() {
        for (Condition condition : conditionSet) {
            System.out.println(condition);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CEPetriNet that = (CEPetriNet) o;

        return !(eventSet != null ? !eventSet.equals(that.eventSet) : that.eventSet != null);
    }
}
