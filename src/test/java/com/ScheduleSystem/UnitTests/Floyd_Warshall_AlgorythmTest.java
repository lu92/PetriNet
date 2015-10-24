package com.ScheduleSystem.UnitTests;

import com.ScheduleSystem.domain.taskmanagment.graph.AbstractGraph;
import com.ScheduleSystem.domain.taskmanagment.graph.GraphAlgorythmsImpl;
import com.ScheduleSystem.domain.taskmanagment.graph.Node;
import com.ScheduleSystem.domain.taskmanagment.graph.Path;
import com.ScheduleSystem.domain.taskmanagment.graph.factory.GraphFactory;
import com.ScheduleSystem.domain.taskmanagment.graph.factory.GraphType;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by SG0222895 on 7/27/2015.
 */
@Ignore
public class Floyd_Warshall_AlgorythmTest
{
    private AbstractGraph graph;
    private Node node0, node1, node2, node3, node4;

    @Before
    public void init() {
        graph = GraphFactory.getGraph(GraphType.DIRECTED, "", "", new GraphAlgorythmsImpl());
        node0 = new Node("0");
        node1 = new Node("1");
        node2 = new Node("2");
        node3 = new Node("3");
        node4 = new Node("4");

        graph.addNodes(node0, node1, node2, node3, node4);

        graph.addRelationship(node0, node1, 5);
        graph.addRelationship(node0, node3, 8);
        graph.addRelationship(node0, node2, 4);

        graph.addRelationship(node1, node0, -4);
        graph.addRelationship(node1, node4, 5);
        graph.addRelationship(node1, node2, -2);

        graph.addRelationship(node2, node3, 5);
        graph.addRelationship(node2, node4, 2);

        graph.addRelationship(node3, node0, -1);
        graph.addRelationship(node3, node4, -1);
        graph.addRelationship(node3, node1, 2);

        graph.addRelationship(node4, node2, 4);
        graph.addRelationship(node4, node3, 2);

        Assert.assertEquals(5, graph.getNumberOfNodes());
        Assert.assertEquals(13, graph.getNumberOfRelationships());
    }

    @Test
    public void FloydWarshallAlgorythm_Test() {
        Assert.assertEquals(new Path(node4, node3, node1, node2), graph.getShortestPathBetweenTwoNodes(node4, node2));
        Assert.assertEquals(null, graph.getShortestPathBetweenTwoNodes(node3, node3));
    }

}
