package com.ScheduleSystem.domain.taskmanagment.graph;

import lombok.Data;

/**
 * Created by SG0222895 on 7/21/2015.
 */
@Data
public final class Relationship
{
    private Long id;
    private Node beginNode;
    private Node endNode;
    private int weight;
    private boolean visited = false; // for DFS

    public Relationship()
    {
    }

    public Relationship(Node beginNode, Node endNode)
    {
        this.beginNode = beginNode;
        this.endNode = endNode;
    }

    public Relationship(Node beginNode, Node endNode, int weight)
    {
        this(beginNode, endNode);
        this.weight = weight;
    }

    public Relationship(Node beginNode, Node endNode, int weight, boolean visited)
    {
        this(beginNode, endNode, weight);
        this.visited = visited;
    }

    public Relationship(Node beginNode, Node endNode, boolean visited)
    {
        this(beginNode, endNode);
        this.visited = visited;
    }

    public static Relationship getReversedRelationShip(Relationship relationShip) {
        Relationship reversedRelationShip = new Relationship(relationShip.getEndNode(), relationShip.getBeginNode());
        return reversedRelationShip;
    }

    public Relationship getReversedRelationShip() {
        Relationship reversedRelationShip = new Relationship(getEndNode(), getBeginNode());
        return reversedRelationShip;
    }

    public void show() {
        System.out.println("Relationship : " + beginNode.getName() + " -> " + endNode.getName());
    }

    @Override public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Relationship that = (Relationship) o;
        if (!beginNode.equals(that.beginNode))
            return false;
        return endNode.equals(that.endNode);
    }

    @Override public int hashCode()
    {
        int result = beginNode.hashCode();
        result = 31 * result + endNode.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "id=" + id +
                ", beginNode=" + beginNode.getName() +
                ", endNode=" + endNode.getName() +
                ", isVisited=" + visited +
                '}';
    }
}
