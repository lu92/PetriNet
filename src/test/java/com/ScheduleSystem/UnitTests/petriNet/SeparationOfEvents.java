package com.ScheduleSystem.UnitTests.petriNet;

import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.Event;
import org.junit.Assert;
import org.junit.Before;

/**
 * Created by SG0222895 on 10/21/2015.
 */
public class SeparationOfEvents extends CEPetriNetSpecification {

    private Event e1, e2, e3, e4, e5;

    @Before
    public void setUp() {
        e1 = cePetriNet.findEvent("e1").get();
        e2 = cePetriNet.findEvent("e2").get();
        e3 = cePetriNet.findEvent("e3").get();
        e4 = cePetriNet.findEvent("e4").get();
        e5 = cePetriNet.findEvent("e5").get();
    }


    @Override
    public void test() {
        Assert.assertTrue(e1.isSeparatedWithOtherEvent(e2));
        Assert.assertTrue(e1.isSeparatedWithOtherEvent(e3));
        Assert.assertTrue(e1.isSeparatedWithOtherEvent(e4));
        Assert.assertTrue(e1.isSeparatedWithOtherEvent(e5));

        Assert.assertFalse(e2.isSeparatedWithOtherEvent(e3));
        Assert.assertFalse(e2.isSeparatedWithOtherEvent(e4));
        Assert.assertFalse(e2.isSeparatedWithOtherEvent(e5));

        Assert.assertTrue(e3.isSeparatedWithOtherEvent(e4));
        Assert.assertTrue(e3.isSeparatedWithOtherEvent(e5));

        Assert.assertTrue(e4.isSeparatedWithOtherEvent(e5));
    }
}
