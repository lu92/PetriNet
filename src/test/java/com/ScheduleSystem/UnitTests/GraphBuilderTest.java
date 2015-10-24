package com.ScheduleSystem.UnitTests;

import com.ScheduleSystem.domain.taskmanagment.graph.GraphBuilder;
import com.ScheduleSystem.domain.taskmanagment.graph.factory.GraphType;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by SG0222895 on 10/24/2015.
 */
public class GraphBuilderTest {

    @Test
    public void test() {
        GraphBuilder graphBuilder = new GraphBuilder(GraphType.DIRECTED, "simple graph", "some description");
        Assert.assertNotNull(graphBuilder);

        graphBuilder.
                addNodes().
                setUpRelations().
                    addRelationship(null, null).
                    end().
                build();
    }

}
