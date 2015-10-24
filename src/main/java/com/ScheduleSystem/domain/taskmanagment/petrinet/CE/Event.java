package com.ScheduleSystem.domain.taskmanagment.petrinet.CE;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by SG0222895 on 10/3/2015.
 */
@Data
public class Event extends PetriObject{
    private CEPetriNet cePetriNet;
    private Set<Arc> arcSet = new HashSet<>();

    public Event() {
    }

    public Event(String name) {
        super(name);
    }

    public Case getMinimumCase() {
        Case minimumCase = new Case();
        for (Arc arc : arcSet)
            if (arc.getDirection() == Direction.INCOMMING)
                minimumCase.addCondition(arc.getCondition());
        return minimumCase;
    }

    public Case getNextCase() {
        Case eventCase = new Case();
        for (Arc arc : arcSet) {
            if (arc.getDirection() == Direction.OUTGOING)
                eventCase.addCondition(arc.getCondition());
        }
        return eventCase;
    }

    public boolean isSeparatedWithOtherEvent(Event event) throws IllegalArgumentException {
        if (!cePetriNet.isEventBelongToNet(event))
            throw new IllegalArgumentException("event " + event + " doesn't belongs to the same Petri Net");

        if (this.equals(event))
            throw new IllegalArgumentException("selected events are the same");

        if (this.getMinimumCase().getIntersection(event.getMinimumCase()).isEmpty() && this.getNextCase().getIntersection(event.getNextCase()).isEmpty())
            return true;
        else
            return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Event event = (Event) o;

        return cePetriNet.equals(event.cePetriNet);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
//        result = 31 * result + cePetriNet.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "cePetriNet=" + cePetriNet.getName() +
                ", arcSet=" + arcSet +
                '}';
    }
}
