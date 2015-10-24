package com.ScheduleSystem.domain.taskmanagment.graph;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by SG0222895 on 7/26/2015.
 */
@Data
public abstract class AbstractGraph
{
    protected Long id;
    protected String name;
    protected String description;
    protected Set<Node> nodeStorage = new HashSet<>();
    protected Set<Relationship> relationshipStorage = new HashSet<>();

    protected GraphAlgorithms graphAlgorithms;

    public AbstractGraph() {
    }

    public AbstractGraph(String name) {
        this.name = name;
    }

    public AbstractGraph(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public AbstractGraph(String name, String description, GraphAlgorithms graphAlgorithms) {
        this(name, description);
        this.graphAlgorithms = graphAlgorithms;
        this.graphAlgorithms.setGraph(this);
    }

    public void addNodes(Node ... nodes) {
        for (Node node : nodes) {
            node.setGraph(this);
            nodeStorage.add(node);
        }
    }

    public abstract void addRelationship(Node beginNode, Node endNode);
    public abstract void addRelationship(Node beginNode, Node endNode, int weight);

    public void removeNode(Node node) {
        if (!node.isIsolated())
            throw new IllegalArgumentException("cannot remove connected node");
        else {
            nodeStorage.remove(node);
        }
    }

    public abstract void removeRelationship(Relationship relationship);

    public abstract void removeRelationship(Node beginNode, Node endNode);

    public void removeNodeRegardlessOfRelationShips(Node selectedNode) {
        if (nodeStorage.contains(selectedNode))
        {
            removeAllRelationshipsOnSelectedNode(selectedNode);
            if (selectedNode.isIsolated())
            {
                removeNode(selectedNode);
            }
            else
                throw new IllegalArgumentException("deletion of relationships on selected node failed");
        }
        else
            throw new IllegalArgumentException("Cannot remove doesn't exist node");
    }

    public Relationship findRelationshipByNodes(Node begiNode, Node endNode) {
        for (Relationship relationship : relationshipStorage) {
            if (relationship.getBeginNode().equals(begiNode) && relationship.getEndNode().equals(endNode))
                return relationship;
        }
        throw new IllegalArgumentException("can't find relationship between two Nodes");
    }

    public boolean isTwoNodeAreConnected(Node beginNode, Node endNode) {
        Relationship relationship = new Relationship(beginNode, endNode);
        return relationshipStorage.contains(relationship) ? true : false;
    }

    public void removeAllRelationshipsOnSelectedNode(Node selectedNode) {
        List<Node> neighbours = new ArrayList<>(selectedNode.neighbourNodeStorage);
        for (Node neighbour : neighbours) {
            removeRelationship(selectedNode, neighbour);
        }
    }


    public void showAllRelationShips() {
        for (Relationship relationShip : relationshipStorage) {
            relationShip.show();
        }
    }

    public void showAllNodes() {
        for (Node node : nodeStorage)
            System.out.println(node);
    }

    private boolean isEveryNodeIsIsolated() {
        for (Node node : nodeStorage)
            if (!node.isIsolated())
                return false;
        return true;
    }

    private void deleteAllNodes() {
        if (!isEveryNodeIsIsolated())
            throw new IllegalArgumentException("cannnot remove unisolated node");
        else
            nodeStorage.clear();
    }

    private void deleteAllRelationships() {
        List<Relationship> allRelationships = new ArrayList<>(relationshipStorage);
        for (Relationship relationship : allRelationships)
            removeRelationship(relationship);
    }

    public Node findNodeBySHACode(String SHACode) throws IllegalArgumentException{
        for (Node node : nodeStorage) {
            if (node.getSHA256Code().equals(SHACode))
                return node;
        }
        throw new IllegalArgumentException("Node with selected SHA code doesn't exists");
    }

    public int getNumberOfNodes() {
        return nodeStorage.size();
    }

    public int getNumberOfRelationships() {
        return relationshipStorage.size();
    }

    public void clear() {
        deleteAllRelationships();
        if (!isEveryNodeIsIsolated())
            throw new IllegalArgumentException("deletion of all relationships failed");
        deleteAllNodes();
    }

    public boolean isClear() {
        return nodeStorage.isEmpty() && relationshipStorage.isEmpty() ? true : false;
    }

    public Path getShortestPathBetweenTwoNodes(Node beginNode, Node endNode)
    {
        return graphAlgorithms.getLightestPathBetweenTwoNodes(beginNode, endNode);
    }

    public boolean isTwoNodesAreConnectedInSelectedDirection(Node beginNode, Node endNode)
    {
        return false;
    }

    public boolean isCyclic()
    {
        return graphAlgorithms.isCyclic();
    }

    public Graph getTransposition()
    {
        return graphAlgorithms.getTransposition();
    }

    public Path doDFS(Node beginNode)
    {
        return graphAlgorithms.doDFS(beginNode);
    }

    public void doBFS(Node beginNode)
    {
        graphAlgorithms.doBFS(beginNode);
    }
}
