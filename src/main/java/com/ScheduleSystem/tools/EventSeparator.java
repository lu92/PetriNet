package com.ScheduleSystem.tools;

import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.Case;
import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.Event;

/**
 * Created by SG0222895 on 10/21/2015.
 */
public class EventSeparator {

    public static boolean checkSeparation(Event event1, Event event2) throws IllegalArgumentException {
        if (event1.getCePetriNet().equals(event2.getCePetriNet()))
            throw new IllegalArgumentException("event2 " + event2 + " doesn't belongs to the same Petri Net");

        if (event1.equals(event2))
            throw new IllegalArgumentException("selected events are the same");

//        Case intersectionOfMinimumConditions = event1.getMinimumCase().getIntersection(event2.getMinimumCase());
//        Case intersectionOfNextConditions = event1.getNextCase().getIntersection(event2.getNextCase());
        if (event1.getMinimumCase().getIntersection(event2.getMinimumCase()).isEmpty() && event1.getNextCase().getIntersection(event2.getNextCase()).isEmpty())
            return true;
        else
            return false;
    }

    public static boolean checkSeparation(Event ... events) {
        return false;
    }
}
