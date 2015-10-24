package com.ScheduleSystem.domain.taskmanagment.graph;


/**
 * Created by SG0222895 on 7/23/2015.
 */
public interface GraphAlgorithms
{
    void setGraph(AbstractGraph graph);
    Path getLightestPathBetweenTwoNodes(Node beginNode, Node endNode);
    boolean isTwoNodesAreConnectedInSelectedDirection(Node beginNode, Node endNode);

    boolean isCyclic();
    Graph getTransposition();
    Path doDFS(Node beginNode);
    void doBFS(Node beginNode);
}
