package com.ScheduleSystem.tools;

import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.Case;
import com.ScheduleSystem.domain.taskmanagment.petrinet.CE.Condition;

import java.util.stream.Collectors;

/**
 * Created by SG0222895 on 10/17/2015.
 */
public class CaseUtils {

    //  suma
    public static Case union(Case firstCase, Case secondCase) {
        Case union = new Case();
        firstCase.getConditionSet().stream().forEach(condition -> union.addCondition(condition));
        secondCase.getConditionSet().stream().forEach(condition -> union.addCondition(condition));
        return union;
    }
    //  czesc wspolna
    public static Case intersection(Case firstCase, Case secondCase) {
        Case intersection = new Case();
        for (Condition condition : firstCase.getConditionSet())
            if (secondCase.getConditionSet().contains(condition))
                intersection.addCondition(condition);
        return intersection;
    }

    //  roznica
    public static Case relativeComplement(Case firstCase, Case secondCase) {
        Case relativeComplement = new Case();
        for (Condition condition : secondCase.getConditionSet())
            if (!firstCase.getConditionSet().contains(condition))
                relativeComplement.addCondition(condition);
        return relativeComplement;
    }

//    //  dopelnienie
//    public static Case complement(Case firstCase, Case secondCase) {
//        Case intersection = new Case();
//        return intersection;
//    }


}
