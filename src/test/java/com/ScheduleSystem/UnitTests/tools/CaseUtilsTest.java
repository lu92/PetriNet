package com.ScheduleSystem.UnitTests.tools;

import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.Case;
import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.Condition;
import com.ScheduleSystem.tools.CaseUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by SG0222895 on 10/22/2015.
 */
public class CaseUtilsTest {

    Condition b1 = new Condition("b1");
    Condition b2 = new Condition("b2");
    Condition b3 = new Condition("b3");
    Condition b4 = new Condition("b4");
    Condition b5 = new Condition("b5");
    Condition b6 = new Condition("b6");

    @Test
    public void unionTest() {
        Case firstCase = new Case(b1, b2, b3, b4);
        Case secondCase = new Case(b4, b5);

        Case union = CaseUtils.union(firstCase, secondCase);
        Assert.assertNotNull(union);
        Assert.assertEquals(5, union.size());
        Assert.assertTrue(union.getConditionSet().contains(b1));
        Assert.assertTrue(union.getConditionSet().contains(b2));
        Assert.assertTrue(union.getConditionSet().contains(b3));
        Assert.assertTrue(union.getConditionSet().contains(b4));
        Assert.assertTrue(union.getConditionSet().contains(b5));
    }

    @Test
    public void intersectionTest() {
        Case firstCase = new Case(b1, b2, b3, b4);
        Case secondCase = new Case(b3, b4, b5, b6);

        Case intersection = CaseUtils.intersection(firstCase, secondCase);
        Assert.assertNotNull(intersection);
        Assert.assertEquals(2, intersection.size());
        Assert.assertTrue(intersection.getConditionSet().contains(b3));
        Assert.assertTrue(intersection.getConditionSet().contains(b4));
    }



}
