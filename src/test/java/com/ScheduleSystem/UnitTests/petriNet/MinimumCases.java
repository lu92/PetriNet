package com.ScheduleSystem.UnitTests.petriNet;

import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.Case;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by SG0222895 on 10/21/2015.
 */
public class MinimumCases extends CEPetriNetSpecification {

    @Override
    public void test() {
        Assert.assertEquals(new Case(cePetriNet.findConditions("b1").get()), cePetriNet.findEvent("e1").get().getMinimumCase());
        Assert.assertEquals(new Case(cePetriNet.findConditions("b2", "b3").get()), cePetriNet.findEvent("e2").get().getMinimumCase());
        Assert.assertEquals(new Case(cePetriNet.findConditions("b2").get()), cePetriNet.findEvent("e3").get().getMinimumCase());
        Assert.assertEquals(new Case(cePetriNet.findConditions("b3").get()), cePetriNet.findEvent("e4").get().getMinimumCase());
        Assert.assertEquals(new Case(cePetriNet.findConditions("b4", "b5").get()), cePetriNet.findEvent("e5").get().getMinimumCase());
    }
}
