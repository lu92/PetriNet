package com.ScheduleSystem.UnitTests.petriNet;

import org.junit.Assert;

/**
 * Created by SG0222895 on 10/21/2015.
 */
public class ReferencesTest extends CEPetriNetSpecification {

    @Override
    public void test() {
        org.junit.Assert.assertEquals(cePetriNet.getNumberOfConditions(), 5);
        org.junit.Assert.assertEquals(cePetriNet.getNumberOfEvents(), 5);

        org.junit.Assert.assertEquals(cePetriNet.getNumberOfArcs(), 13);

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
}
