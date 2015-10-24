package com.ScheduleSystem.domain.taskmanagment.graph;

import com.ScheduleSystem.domain.taskmanagment.Task;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by SG0222895 on 7/21/2015.
 */

@Data
public class Node <T extends Serializable>
{
    protected Long id;
    protected String name;
    protected String SHA256Code;
    protected Set<Node> neighbourNodeStorage = new HashSet<>();
    protected Set<Relationship> outGoingRelationShipStorage = new HashSet<>();
    protected Set<Relationship> inCommingRelationShipStorage = new HashSet<>();
    protected AbstractGraph graph;
    protected Set<T> Objects = new HashSet<>();
//    protected Task task;

    protected Visited visited = Visited.WHITE;


    // coordinates for view
    private double x;
    private double y;

    public Node()
    {
        SHA256Code = UUID.randomUUID().toString();
    }

    public Node(String name)
    {
        this();
        this.name = name;
    }

//    public Node(Task task)
//    {
//        this();
//        task.setNode(this);
//        this.task = task;
//    }

//    public Node(String name, Task task)
//    {
//        this(name);
//        task.setNode(this);
//        this.task = task;
//    }

    public Node(Node node) {
//        create copy of node without relationships
        this.name = node.name;
        this.SHA256Code = node.SHA256Code;

    }

    public static Node getNullNode() {
        Node nullNode = new Node("null");
        nullNode.setSHA256Code("null");
        return nullNode;
    }

    public void addNeighBourNode(Node... neighbours) throws IllegalArgumentException {
        for (Node node : neighbours)
            if (node == null)
                throw new IllegalArgumentException("cannot add empty [null] node as neighbour");
            else
                this.neighbourNodeStorage.add(node);
    }

    public void addIncommingRelationShip(Relationship relationShip) {
        this.inCommingRelationShipStorage.add(relationShip);
    }

    public void addOutgoingRelationShip(Relationship relationShip) {
        this.outGoingRelationShipStorage.add(relationShip);
    }

    public void generateSHACode() {
        this.SHA256Code = UUID.randomUUID().toString();
    }

    public boolean isIsolated() {
        if (neighbourNodeStorage.isEmpty() &&
                outGoingRelationShipStorage.isEmpty() &&
                inCommingRelationShipStorage.isEmpty())
            return true;
        else return false;
    }

    public void showNeighbourNodes() {
        System.out.println("neighbours od node " + name);
        for (Node neighbour : neighbourNodeStorage)
            System.out.println(neighbour.getName());
    }

    public Set<Node> getOutGoingNeighbours() {
        Set<Node> outGoingNeighbours = new HashSet<>();
        for (Relationship relationship : outGoingRelationShipStorage)
            outGoingNeighbours.add(relationship.getEndNode());
        return outGoingNeighbours;
    }

    public int getNumberOfInCommingRelationShips() {
        return this.inCommingRelationShipStorage.size();
    }

    public int getNumberOfOutGoingRelationShips() {
        return this.outGoingRelationShipStorage.size();
    }

    public int getNumberOfNeighbours() {
        return this.neighbourNodeStorage.size();
    }

    public void showOutGoingRelationShips() {
        System.out.println("outgoing relationships from " + getName());
        for (Relationship relationShip : this.getOutGoingRelationShipStorage())
            System.out.println(relationShip.getBeginNode().getName() + " -> " + relationShip.getEndNode().getName());
    }

    public void showInCommingRelationShips() {
        System.out.println("incomming relationships to " + getName());
        for (Relationship relationShip : this.getInCommingRelationShipStorage())
            System.out.println(relationShip.getBeginNode().getName() + " -> " + relationShip.getEndNode().getName());
    }

    @Override public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Node node = (Node) o;
        return SHA256Code.equals(node.SHA256Code);
    }

    @Override public int hashCode()
    {
        return SHA256Code.hashCode();
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", SHA-Code='" + SHA256Code + '\'' +
//                ", neighbourNodeStorage=" + neighbourNodeStorage +
//                ", outGoingRelationShipStorage=" + outGoingRelationShipStorage +
//                ", inCommingRelationShipStorage=" + inCommingRelationShipStorage +
//                ", graph=" + graph.getName() +
//                ", x=" + x +
//                ", y=" + y +
                '}';
    }
}
