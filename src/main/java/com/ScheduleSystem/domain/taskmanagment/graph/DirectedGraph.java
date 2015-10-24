package com.ScheduleSystem.domain.taskmanagment.graph;

/**
 * Created by SG0222895 on 7/25/2015.
 */
public class DirectedGraph extends AbstractGraph
{
    public DirectedGraph()
    {
    }

    public DirectedGraph(String name)
    {
        super(name);
    }

    public DirectedGraph(String name, String description)
    {
        super(name, description);
    }

    public DirectedGraph(String name, String description, GraphAlgorithms graphAlgorithms)
    {
        super(name, description, graphAlgorithms);
    }

    @Override public void addRelationship(Node beginNode, Node endNode) {
        addRelationship(beginNode, endNode, 0);
    }

    @Override public void addRelationship(Node beginNode, Node endNode, int weight) {
        Relationship relationShip = new Relationship(beginNode, endNode, weight);
        beginNode.addOutgoingRelationShip(relationShip);
        beginNode.addNeighBourNode(endNode);

        endNode.addIncommingRelationShip(relationShip);
        endNode.addNeighBourNode(beginNode);
        relationshipStorage.add(relationShip);
    }

    @Override public void removeRelationship(Relationship relationship) {
        if (relationship == null)
            throw new IllegalArgumentException("relationship cannot be null");
        else
            this.removeRelationship(relationship.getBeginNode(), relationship.getEndNode());
    }

    @Override public void removeRelationship(Node beginNode, Node endNode) {
        if (isTwoNodeAreConnected(beginNode, endNode))
        {
            Relationship relationship = new Relationship(beginNode, endNode);
            beginNode.getOutGoingRelationShipStorage().remove(relationship);
            beginNode.getNeighbourNodeStorage().remove(endNode);

            endNode.getInCommingRelationShipStorage().remove(relationship);
            endNode.getNeighbourNodeStorage().remove(beginNode);
            relationshipStorage.remove(relationship);
        }
        else
            throw new IllegalArgumentException("selected relationship doesn't exist");
    }
}
