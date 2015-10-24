package com.ScheduleSystem.domain.taskmanagment.graph;

/**
 * Created by SG0222895 on 7/25/2015.
 */
public class UndirectedGraph extends AbstractGraph
{

    public UndirectedGraph()
    {
    }

    public UndirectedGraph(String name)
    {
        super(name);
    }

    public UndirectedGraph(String name, String description)
    {
        super(name, description);
    }

    public UndirectedGraph(String name, String description, GraphAlgorithms graphAlgorithms)
    {
        super(name, description, graphAlgorithms);
    }

    @Override public void addRelationship(Node beginNode, Node endNode)
    {

    }

    @Override public void addRelationship(Node beginNode, Node endNode, int weight)
    {

    }

    @Override public void removeRelationship(Relationship relationship)
    {

    }

    @Override public void removeRelationship(Node beginNode, Node endNode)
    {

    }
}
