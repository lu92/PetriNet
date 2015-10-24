package com.ScheduleSystem.domain.taskmanagment.petrinet.CE;

/**
 * Created by SG0222895 on 10/21/2015.
 */
public class CEPetriNetBuilder {
    private CEPetriNet cePetriNetResult;
    private ArcBuilder arcBuilder;

    public CEPetriNetBuilder() {
        cePetriNetResult = new CEPetriNet();
        arcBuilder = new ArcBuilder(this);
    }

    public CEPetriNetBuilder(String name, String description) {
        cePetriNetResult = new CEPetriNet(name, description);
        arcBuilder = new ArcBuilder(this);
    }

    public CEPetriNetBuilder addConditions(String ... conditionNames) {
        for (String conditionName : conditionNames) {
            Condition condition = new Condition(conditionName);
            condition.setCePetriNet(cePetriNetResult);
            cePetriNetResult.getConditionSet().add(condition);
        }
        return this;
    }

    public CEPetriNetBuilder addConditions(Condition ... conditions) {
        for (Condition condition : conditions) {
            condition.setCePetriNet(cePetriNetResult);
            cePetriNetResult.getConditionSet().add(condition);
        }
        return this;
    }

    public CEPetriNetBuilder addEvent(String ... eventNames) {
        for (String eventName : eventNames)
            addEvent(new Event(eventName));
        return this;
    }

    public CEPetriNetBuilder addEvent(Event ... events) {
        for (Event event : events) {
            event.setCePetriNet(cePetriNetResult);
            cePetriNetResult.getEventSet().add(event);
        }
        return this;
    }

    public ArcBuilder setUpArcs() {
        return arcBuilder;
    }

    public CEPetriNet build() {
        return cePetriNetResult;
    }

    public CEPetriNet getBuildResult() {
        return cePetriNetResult;
    }

    public class ArcBuilder {

        private CEPetriNetBuilder cePetriNetBuilder;

        public ArcBuilder() {
        }

        public ArcBuilder(CEPetriNetBuilder cePetriNetBuilder) {
            this.cePetriNetBuilder = cePetriNetBuilder;
        }

        public ArcBuilder addArc(String  existingCondition,String direction, String existingEvent) throws IllegalArgumentException {
            return addArc(
                    cePetriNetBuilder.getBuildResult().findCondition(existingCondition).get(),
                    direction,
                    cePetriNetBuilder.getBuildResult().findEvent(existingEvent).get()
            );
        }

        private ArcBuilder addArc(Condition existingCondition, String direction, Event existingEvent) throws IllegalArgumentException {

//        The direction depends on event, for example:
//        event -> condition        Direction.OUTGOING
//        condition -> event        Direction.INCOMMING

            Arc arc;

            if (!cePetriNetBuilder.getBuildResult().getConditionSet().contains(existingCondition))
                throw new IllegalArgumentException("CE Petri Net doesn't contain selected condition: " + existingCondition.getName());

            if (!cePetriNetBuilder.getBuildResult().getEventSet().contains(existingEvent))
                throw new IllegalArgumentException("CE Petri Net doesn't contain selected event: " + existingEvent.getName());

            switch (direction) {
                case "->":
                    arc = new Arc(existingCondition, existingEvent, Direction.INCOMMING);
                    arc.getCondition().getArcSet().add(arc);
                    arc.getEvent().getArcSet().add(arc);
                    cePetriNetBuilder.getBuildResult().getArcSet().add(arc);
//                    cePetriNetBuilder.getBuildResult().addArc(arc);
                    return this;

                case "<-" :
                    arc = new Arc(existingCondition, existingEvent, Direction.OUTGOING);
                    arc.getCondition().getArcSet().add(arc);
                    arc.getEvent().getArcSet().add(arc);
                    cePetriNetBuilder.getBuildResult().getArcSet().add(arc);
//                    cePetriNetBuilder.getBuildResult().addArc(arc);
                    return this;

                default:
                    throw new IllegalArgumentException("Invalid direction");
            }
        }

        public CEPetriNetBuilder endArcs() {
            return cePetriNetBuilder;
        }
    }

}
