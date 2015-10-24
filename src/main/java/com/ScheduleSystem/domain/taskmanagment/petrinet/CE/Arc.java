package com.ScheduleSystem.domain.taskmanagment.petrinet.CE;

import lombok.Data;

/**
 * Created by SG0222895 on 9/26/2015.
 */
@Data
public class Arc extends PetriObject {
    private Condition condition;
    private Event event;
    private Direction direction;

    public Arc() {
    }

    public Arc(Condition condition, Event event, Direction direction) {
        this.condition = condition;
        this.event = event;
        this.direction = direction;
    }

    public static Arc create(Condition condition, Event event) {
        return new Arc(condition, event, Direction.OUTGOING);
    }

    public static Arc create(Event event, Condition condition) {
        return new Arc(condition, event, Direction.INCOMMING);
    }

    public static Arc incomming(Condition condition, Event event) {
        return new Arc(condition, event, Direction.INCOMMING);
    }

    public static Arc outgoing(Condition condition, Event event) {
        return new Arc(condition, event, Direction.OUTGOING);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Arc arc = (Arc) o;

        if (!condition.equals(arc.condition)) return false;
        if (!event.equals(arc.event)) return false;
        return direction == arc.direction;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + condition.hashCode();
        result = 31 * result + event.hashCode();
        result = 31 * result + direction.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Arc{" +
                "condition=" + condition.getName() +
                ", event=" + event.getName() +
                ", direction=" + direction +
                '}';
    }
}
