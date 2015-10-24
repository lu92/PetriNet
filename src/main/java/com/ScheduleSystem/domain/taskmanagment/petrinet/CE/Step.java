package com.ScheduleSystem.domain.taskmanagment.petrinet.CE;

import lombok.Data;

import java.util.*;

/**
 * Created by SG0222895 on 10/3/2015.
 */
@Data
public class Step {
    private Case beginCase;
    private Case endCase;
    private Set<Event> eventList = new HashSet<>();

    public Step(Case c_Case, Case c_prim_Case, Event event) throws Exception{
        if (event == null)
            throw new NullPointerException("Null pointer Exception");

        if (!c_Case.isEventActive(event))
            throw new IllegalArgumentException("event doesn't belong to beginning case");

        Set<Condition> C = new HashSet<>();
        c_Case.getConditionSet().stream().forEach(condition -> C.add(condition));

        C.removeAll(event.getMinimumCase().getConditionSet());
        C.addAll(event.getNextCase().getConditionSet());

        if (C.equals(c_prim_Case.getConditionSet())) {
            beginCase = c_Case;
            endCase = c_prim_Case;
            eventList.add(event);
        } else
            throw new IllegalArgumentException("cannot create Step Object");
    }

    public Step(Case c_Case, Case c_prim_Case, Event ... events) throws Exception{
        if (events.length == 0)
            throw new IllegalArgumentException("Needed event's arguments, minimum one event");

        for (Event event : events) {
            if (!c_Case.isEventActive(event))
                throw new IllegalArgumentException("event" + event.getName() + " " + "sha code: " + event.getSHA256Code() +  "  doesn't belong to beginning case");
        }

        Set<Condition> C = new HashSet<>();
        c_Case.getConditionSet().stream().forEach(condition -> C.add(condition));

        for (Event event : events) {
            C.removeAll(event.getMinimumCase().getConditionSet());
            C.addAll(event.getNextCase().getConditionSet());
        }
        if (C.equals(c_prim_Case.getConditionSet())) {
            beginCase = c_Case;
            endCase = c_prim_Case;
            eventList.addAll(Arrays.asList(events));
        } else
            throw new IllegalArgumentException("cannot create Step Object");
    }

    public int getNumberOfEvents() {
        return eventList.size();
    }
}
