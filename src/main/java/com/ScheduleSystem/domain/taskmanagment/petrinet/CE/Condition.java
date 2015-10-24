package com.ScheduleSystem.domain.taskmanagment.petrinet.CE;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0222895 on 10/3/2015.
 */
@Data
public class Condition extends PetriObject{
    private CEPetriNet cePetriNet;
    private Set<Condition> neighbourConditionSet = new HashSet<>();
    private Set<Arc> arcSet = new HashSet<>();
    private int tokens = 0;


//    public void setCePetriNet(CEPetriNet cePetriNet) {
//        this.cePetriNet = cePetriNet;
//    }

    public Condition() {
    }

    public Condition(String name) {
        this.name = name;
    }


    public void incrementToken() {
        tokens++;
    }

    public void decrementToken() {
        tokens--;
    }

    public boolean isIsolated() {
        return arcSet.isEmpty() ? true : false;
    }

    public Set<Event> getEventsForCondition() {
        Set<Event> preEventsForCondition = new HashSet<>();
        for (Arc arc : arcSet) {
            if (arc.getDirection() ==  Direction.INCOMMING)
                preEventsForCondition.add(arc.getEvent());
        }
        return preEventsForCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Condition condition = (Condition) o;

        return cePetriNet.equals(condition.cePetriNet);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
//        result = 31 * result + cePetriNet.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "cePetriNet=" + cePetriNet.getName() +
                ", neighbourConditionSet=" + neighbourConditionSet +
                ", arcSet=" + arcSet +
                ", tokens=" + tokens +
                '}';
    }
}
