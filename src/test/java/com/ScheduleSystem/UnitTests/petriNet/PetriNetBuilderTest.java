package com.ScheduleSystem.UnitTests.petriNet;

import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.CEPetriNet;
import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.CEPetriNetBuilder;
import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.Condition;
import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.Direction;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by SG0222895 on 10/21/2015.
 */
public class PetriNetBuilderTest {

    @Test
    public void createBuilder() {
        CEPetriNetBuilder cePetriNetBuilder = new CEPetriNetBuilder("simple Condition/Event petri net", "");
        CEPetriNet cePetriNet = cePetriNetBuilder.
                addConditions("b1", "b2", "b3", "b4", "b5").
                addEvent("e1", "e2").
                setUpArcs().
                    addArc("b1", "->", "e1").
                    addArc("b2", "->", "e1").
                    addArc("b3", "<-", "e1").
                    addArc("b4", "->", "e2").
                    addArc("b5", "<-", "e2").
                    endArcs().
                build();

        Assert.assertNotNull(cePetriNetBuilder);
        Assert.assertNotNull(cePetriNetBuilder.build());

        org.junit.Assert.assertEquals(cePetriNet.getNumberOfConditions(), 5);
        org.junit.Assert.assertEquals(cePetriNet.getNumberOfEvents(), 2);

        org.junit.Assert.assertEquals(cePetriNet.getNumberOfArcs(), 5);

        cePetriNet.getConditionSet().stream().forEach(condition -> {
            org.junit.Assert.assertNotNull(condition.getCePetriNet());
            org.junit.Assert.assertEquals(condition.getCePetriNet(), cePetriNet);
        });

        cePetriNet.getEventSet().stream().forEach(event -> {
            org.junit.Assert.assertNotNull(event.getCePetriNet());
            org.junit.Assert.assertEquals(event.getCePetriNet(), cePetriNet);
        });

        cePetriNet.getArcSet().stream().forEach(arc -> {
            org.junit.Assert.assertNotNull(arc.getCondition().getCePetriNet());
            org.junit.Assert.assertEquals(arc.getCondition().getCePetriNet(), cePetriNet);

            org.junit.Assert.assertNotNull(arc.getEvent().getCePetriNet());
            org.junit.Assert.assertEquals(arc.getEvent().getCePetriNet(), cePetriNet);
        });

    }

    @Test
    public void everyConditionIsIsolated() {
        CEPetriNetBuilder cePetriNetBuilder = new CEPetriNetBuilder("simple Condition/Event petri net", "");

        cePetriNetBuilder.addConditions("b1", "b2", "b3", "b4", "b5");
        CEPetriNet cePetriNet = cePetriNetBuilder.build();
        Assert.assertEquals(cePetriNet.getNumberOfConditions(), 5);
        cePetriNet.getConditionSet().stream().forEach(condition -> org.junit.Assert.assertTrue(condition.isIsolated()));
    }

    @Test
    public void _2ConditionsAreConnectedRestIsIsolated() {
        CEPetriNetBuilder cePetriNetBuilder = new CEPetriNetBuilder("simple Condition/Event petri net", "");
        CEPetriNet cePetriNet = cePetriNetBuilder.
                addConditions("b1", "b2", "b3", "b4", "b5").addEvent("e1").
                setUpArcs().
                    addArc("b1", "->", "e1").
                    addArc("b2", "<-", "e1").
                    endArcs().
                build();

        org.junit.Assert.assertEquals(cePetriNet.getNumberOfConditions(), 5);
        org.junit.Assert.assertEquals(cePetriNet.getNumberOfEvents(), 1);
        org.junit.Assert.assertEquals(cePetriNet.getNumberOfArcs(), 2);

        org.junit.Assert.assertFalse(cePetriNet.findCondition("b1").get().isIsolated());
        org.junit.Assert.assertFalse(cePetriNet.findCondition("b2").get().isIsolated());
        org.junit.Assert.assertTrue(cePetriNet.findCondition("b3").get().isIsolated());
        org.junit.Assert.assertTrue(cePetriNet.findCondition("b4").get().isIsolated());
        org.junit.Assert.assertTrue(cePetriNet.findCondition("b5").get().isIsolated());
    }

    @Test
    public void checkSingleReferenceToCondition() {
        CEPetriNetBuilder cePetriNetBuilder = new CEPetriNetBuilder("simple Condition/Event petri net", "");
        Condition condition = new Condition("b1");
        Assert.assertNotNull(cePetriNetBuilder.addConditions(condition).build().getConditionSet().iterator().next().getCePetriNet());
    }


}
