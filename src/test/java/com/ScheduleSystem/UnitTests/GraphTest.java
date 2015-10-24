package com.ScheduleSystem.UnitTests;

import com.ScheduleSystem.domain.taskmanagment.graph.AbstractGraph;
import com.ScheduleSystem.domain.taskmanagment.graph.DirectedGraph;
import com.ScheduleSystem.domain.taskmanagment.graph.Graph;
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
 * Created by SG0222895 on 7/21/2015.
 */
@Ignore
public class GraphTest
{
    private AbstractGraph graph;
    private Node nodeA, nodeB, nodeC, nodeD, nodeE, nodeF;

    @Before
    public void initGraph() {

//        graph = new DirectedGraph("my graph", "directed graph", new GraphAlgorythmsImpl());

        graph = GraphFactory.getGraph(GraphType.DIRECTED, "my graph", "directed graph", new GraphAlgorythmsImpl());

        nodeA = new Node("A");
        nodeB = new Node("B");
        nodeC = new Node("C");
        nodeD = new Node("D");
        nodeE = new Node("E");
        nodeF = new Node("F");

        graph.addNodes(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF);

        graph.addRelationship(nodeA, nodeC, 1);
        graph.addRelationship(nodeA, nodeD);
        graph.addRelationship(nodeA, nodeE);
        graph.addRelationship(nodeB, nodeD);
        graph.addRelationship(nodeC, nodeD);

        Assert.assertEquals(6, graph.getNumberOfNodes());
        Assert.assertEquals(5, graph.getNumberOfRelationships());
    }

    @Test
    public void checkIsolationOfNodes() {
        Assert.assertFalse(nodeA.isIsolated());
        Assert.assertFalse(nodeB.isIsolated());
        Assert.assertFalse(nodeC.isIsolated());
        Assert.assertFalse(nodeD.isIsolated());
        Assert.assertFalse(nodeE.isIsolated());
        Assert.assertTrue(nodeF.isIsolated());
    }

    @Test
    public void checkNeighbourhoodOfNodes()
    {
        Assert.assertEquals(3, nodeA.getNumberOfNeighbours());
        Assert.assertEquals(0, nodeA.getNumberOfInCommingRelationShips());
        Assert.assertEquals(3, nodeA.getNumberOfOutGoingRelationShips());

        Assert.assertEquals(1, nodeB.getNumberOfNeighbours());
        Assert.assertEquals(0, nodeB.getNumberOfInCommingRelationShips());
        Assert.assertEquals(1, nodeB.getNumberOfOutGoingRelationShips());

        Assert.assertEquals(2, nodeC.getNumberOfNeighbours());
        Assert.assertEquals(1, nodeC.getNumberOfInCommingRelationShips());
        Assert.assertEquals(1, nodeC.getNumberOfOutGoingRelationShips());

        Assert.assertEquals(3, nodeD.getNumberOfNeighbours());
        Assert.assertEquals(3, nodeD.getNumberOfInCommingRelationShips());
        Assert.assertEquals(0, nodeD.getNumberOfOutGoingRelationShips());

        Assert.assertEquals(1, nodeE.getNumberOfNeighbours());
        Assert.assertEquals(1, nodeE.getNumberOfInCommingRelationShips());
        Assert.assertEquals(0, nodeE.getNumberOfOutGoingRelationShips());

        Assert.assertEquals(0, nodeF.getNumberOfNeighbours());
        Assert.assertEquals(0, nodeF.getNumberOfInCommingRelationShips());
        Assert.assertEquals(0, nodeF.getNumberOfOutGoingRelationShips());
    }

    @Test
    public void removeRelationshipTest()
    {
        graph.removeRelationship(nodeA, nodeC);
        Assert.assertEquals(4, graph.getNumberOfRelationships());

        Assert.assertEquals(2, nodeA.getNumberOfNeighbours());
        Assert.assertEquals(2, nodeA.getNumberOfOutGoingRelationShips());
        Assert.assertEquals(0, nodeA.getNumberOfInCommingRelationShips());

        Assert.assertEquals(1, nodeC.getNumberOfNeighbours());
        Assert.assertEquals(1, nodeC.getNumberOfOutGoingRelationShips());
        Assert.assertEquals(0, nodeC.getNumberOfInCommingRelationShips());
    }

    @Test
    public void makeSomeNodeIsolated() {
        graph.removeAllRelationshipsOnSelectedNode(nodeA);
        Assert.assertTrue(nodeA.isIsolated());
        Assert.assertEquals(0, nodeA.getNumberOfInCommingRelationShips());
        Assert.assertEquals(0, nodeA.getNumberOfOutGoingRelationShips());
        Assert.assertEquals(0, nodeA.getNumberOfNeighbours());

        Assert.assertEquals(2, graph.getNumberOfRelationships());
        Assert.assertEquals(6, graph.getNumberOfNodes());
    }

    @Test
    public void deleteNodeWithRelationshipsTest() {
        graph.removeNodeRegardlessOfRelationShips(nodeA);
        Assert.assertEquals(2, graph.getNumberOfRelationships());
        Assert.assertEquals(5, graph.getNumberOfNodes());
    }

    @Test
    public void hasCycle() {
        Assert.assertTrue(graph.isCyclic());
    }

    @Test
    public void clearTest() {
        graph.clear();
        Assert.assertTrue(graph.isClear());
    }

    @Test
    public void transpositionOfGraphTest() {
        Graph transposition = graph.getTransposition();
//        transposition.showAllNodes();
        Assert.assertEquals(graph.getNumberOfNodes(), transposition.getNumberOfNodes());
//        transposition.showAllRelationShips();
        Assert.assertEquals(graph.getNumberOfRelationships(), transposition.getNumberOfRelationships());
    }

//    @Test
//    public void getPath() {
//        Path path = graph.getLightestPathBetweenTwoNodes(nodeA, nodeE);
//        System.out.println(path);
//        Assert.assertEquals(1, path.length());
//    }
}
