package com.ScheduleSystem.UnitTests.petriNet;

import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.CEPetriNet;
import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.CEPetriNetBuilder;
import org.junit.Test;

/**
 * Created by SG0222895 on 10/21/2015.
 */
public abstract class CEPetriNetSpecification {

    protected CEPetriNet cePetriNet;
    protected CEPetriNet cePetriNet2;

    public CEPetriNetSpecification() {
        buildFirstPetriNet();
        buildSecondPetriNet();
    }

    private void buildFirstPetriNet() {
        CEPetriNetBuilder cePetriNetBuilder = new CEPetriNetBuilder();
        cePetriNet = cePetriNetBuilder.
                addConditions("b1", "b2", "b3", "b4", "b5").
                addEvent("e1", "e2", "e3", "e4", "e5").
                setUpArcs().
                addArc("b1", "->", "e1").
                addArc("b1", "<-", "e2").
                addArc("b1", "<-", "e5").

                addArc("b2", "->", "e2").
                addArc("b2", "->", "e3").
                addArc("b2", "<-", "e1").

                addArc("b3", "->", "e2").
                addArc("b3", "->", "e4").
                addArc("b3", "<-", "e1").

                addArc("b4", "->", "e5").
                addArc("b4", "<-", "e3").

                addArc("b5", "->", "e5").
                addArc("b5", "<-", "e4").
                endArcs().
                build();
    }

    private void buildSecondPetriNet() {
        CEPetriNetBuilder cePetriNetBuilder = new CEPetriNetBuilder("CE Net", "");
        cePetriNet2 = cePetriNetBuilder.
                addConditions("b1", "b2", "b3", "b4", "b5", "b6").
                addEvent("e0", "e1", "e2", "e3", "e4").
                setUpArcs().
                addArc("b1", "<-", "e0").
                addArc("b1", "->", "e2").
                addArc("b2", "<-", "e0").
                addArc("b2", "->", "e1").
                addArc("b3", "<-", "e2").
                addArc("b3", "->", "e3").
                addArc("b4", "<-", "e3").
                addArc("b4", "->", "e4").
                addArc("b5", "<-", "e1").
                addArc("b5", "->", "e4").
                addArc("b6", "<-", "e4").
                addArc("b6", "->", "e0").
                endArcs().
                build();
    }

    @Test
    public abstract void test();
}
