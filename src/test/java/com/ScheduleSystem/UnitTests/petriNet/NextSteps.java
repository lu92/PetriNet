package com.ScheduleSystem.UnitTests.petriNet;

import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SG0222895 on 10/21/2015.
 */
public class NextSteps extends CEPetriNetSpecification{

    @Test
    public void singleEventAsStep() throws Exception {
        Event e1 = cePetriNet2.findEvent("e1").get();

        Condition b2 = cePetriNet2.findCondition("b2").get();
        Condition b5 = cePetriNet2.findCondition("b5").get();

        Case preCase = new Case(b2);
        Case postCase = new Case(b5);

        Step step = new Step(preCase, postCase, e1);

        Assert.assertNotNull(step);
        Assert.assertTrue(step.getBeginCase().getConditionSet().contains(b2));
        Assert.assertTrue(step.getEndCase().getConditionSet().contains(b5));
        Assert.assertEquals(1, step.getNumberOfEvents());
        Assert.assertTrue(step.getEventList().contains(e1));
    }

    @Test
    public void twiceEventAsStep() throws Exception {
        Event e1 = cePetriNet2.findEvent("e1").get();
        Event e2 = cePetriNet2.findEvent("e2").get();

        Condition b1 = cePetriNet2.findCondition("b1").get();
        Condition b2 = cePetriNet2.findCondition("b2").get();
        Condition b3 = cePetriNet2.findCondition("b3").get();
        Condition b5 = cePetriNet2.findCondition("b5").get();

        Case preCase = new Case(b1, b2);
        Case postCase = new Case(b3, b5);

        Step step = new Step(preCase, postCase, e1, e2);

        Assert.assertNotNull(step);

        Assert.assertEquals(2, step.getBeginCase().size());
        Assert.assertTrue(step.getBeginCase().getConditionSet().contains(b1));
        Assert.assertTrue(step.getBeginCase().getConditionSet().contains(b2));

        Assert.assertEquals(2, step.getEndCase().size());
        Assert.assertTrue(step.getEndCase().getConditionSet().contains(b3));
        Assert.assertTrue(step.getEndCase().getConditionSet().contains(b5));

        Assert.assertEquals(2, step.getNumberOfEvents());
        Assert.assertTrue(step.getEventList().contains(e1));
        Assert.assertTrue(step.getEventList().contains(e2));
    }

    @Override
    public void test() {

    }
}
