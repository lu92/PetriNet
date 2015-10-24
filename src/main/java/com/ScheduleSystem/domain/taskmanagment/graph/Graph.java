package com.ScheduleSystem.domain.taskmanagment.graph;

import lombok.Data;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by SG0222895 on 7/21/2015.
 */
@Data
public class Graph extends AbstractGraph implements GraphAlgorithms
{
    protected Long id;
    protected String name;
    protected String description;
    protected Set<Node> nodeStorage = new HashSet<>();
    protected Set<Relationship> relationshipStorage = new HashSet<>();

    public Graph()
    {
    }

    public Graph(String name)
    {
        this.name = name;
    }

    public Graph(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public void addNodes(Node ... nodes) {
        for (Node node : nodes) {
            node.setGraph(this);
            nodeStorage.add(node);
        }
    }

    public void addRelationship(Node beginNode, Node endNode) {
        Relationship relationShip = new Relationship(beginNode, endNode);
        beginNode.addOutgoingRelationShip(relationShip);
        beginNode.addNeighBourNode(endNode);

        endNode.addIncommingRelationShip(relationShip);
        endNode.addNeighBourNode(beginNode);
        relationshipStorage.add(relationShip);
    }

    @Override public void addRelationship(Node beginNode, Node endNode, int weight)
    {

    }

    public void removeNode(Node node) {
        if (!node.isIsolated())
            throw new IllegalArgumentException("cannot remove connected node");
        else {
            nodeStorage.remove(node);
        }
    }

    public void removeRelationship(Relationship relationship) {
        if (relationship == null)
            throw new IllegalArgumentException("relationship cannot be null");
        else
            this.removeRelationship(relationship.getBeginNode(), relationship.getEndNode());
    }

    public void removeRelationship(Node beginNode, Node endNode) {
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


    public void addUndirectedRelationShip(Node beginNode, Node endNode) {
        addRelationship(beginNode, endNode);
        addRelationship(endNode, beginNode);
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

    public boolean isEveryNodeIsIsolated() {
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

//    public Path getPathBetweenTwoNodes(Node beginNode, Node endNode)
//    {
//        int N = nodeStorage.size();
//        RealMatrix matrix = MatrixUtils.createRealMatrix(N, N);
////        matrix.add
//
//        Path path = new Path();
//        path.addNodes(Node.getNullNode());
//        Stack<Node> nodeStack = new Stack<>();
//
//        beginNode.setVisited(Visited.BLACK);
//        nodeStack.push(beginNode);
//        while (!nodeStack.isEmpty()) {
//            Node currentNode = nodeStack.pop();
//            if (currentNode.equals(endNode))
//                break;
//
//            for(Node neighbour : currentNode.getNeighbourNodeStorage()) {
//                if (neighbour.getVisited() == Visited.WHITE)
//                {
//                    path.addNodes(currentNode);
//                    neighbour.setVisited(Visited.BLACK);
//                    nodeStack.push(neighbour);
//                }
//            }
//        }
//
//        path.removeNodes(Node.getNullNode());
//        return path.reversePath();
//    }

    @Override public void setGraph(AbstractGraph graph)
    {

    }

    @Override public Path getLightestPathBetweenTwoNodes(Node beginNode, Node endNode)
    {
//        Dijkstra's Algorythm

//        Path path;
//        if (beginNode.equals(endNode))
//            path = new Path(beginNode);
//        else {
//
//
//
//            path = new Path();
//            Stack<Node> nodeStack = new Stack<>();
//            nodeStack.push(beginNode);
//            while (!nodeStack.isEmpty()) {
//                Node node = nodeStack.pop();
//                node.setVisited(true);
////
////                for (Node neighbour : node.getOutGoingNeighbours())
////                    if (neighbour.isVisited())
////                        return true;
////                    else
////                        nodeStack.push(neighbour);
//            }
//        }
//        return path;
        return null;
    }

    public Set<Path> getAllPathsBetweenTwoNodes(Node beginNode, Node endNode)
    {
        return null;
    }

    public Set<Path> getTheShortestPathsBetweenTwoNodes(Node beginNode, Node endNode)
    {
/*
        int numberOfNodes = getNumberOfNodes();

//        Set<Node> S = new HashSet<>(nodeStorage.size());    //  performed nodes
//        Set<Node> Q = new HashSet<>(nodeStorage.size());    //  nodes who are waiting to perform

        List<Node> S = new ArrayList<>(nodeStorage);            //  performed nodes
        List<Node> Q = new ArrayList<>(nodeStorage.size());     //  nodes who are waiting to perform

        List<Integer> d = new ArrayList<>(nodeStorage.size());
        List<Integer> p = new ArrayList<>(nodeStorage.size());

        for (int i=0; i<nodeStorage.size(); i++) {
            d.add(i, Integer.MAX_VALUE);
            p.add(i, -1);
        }

        d.add(S.indexOf(beginNode),0);
*/

        return null;

    }

    @Override public boolean isTwoNodesAreConnectedInSelectedDirection(Node beginNode, Node endNode)
    {
        return false;
    }

//    @Override public boolean isCyclic()
//    {
//        if (nodeStorage.size() < 3)
//            return false;
//        else
//        {
//            Stack<Node> nodeStack = new Stack<>();
//            while (!getNotVisitedNodes().isEmpty())
//            {
//                nodeStack.push(getNotVisitedNodes().iterator().next());  // first node in nodeStorage
//
//                while (!nodeStack.isEmpty())
//                {
//                    Node node = nodeStack.pop();
////                    node.setVisited(true);
//                    node.setVisited(Visited.BLACK);
//                    for (Node neighbour : node.getOutGoingNeighbours())
//                        if (neighbour.getVisited() == Visited.BLACK)
//                            return true;
//                        else
//                            nodeStack.push(neighbour);
//                }
//            }
//
////            restoring the default visiting
//            for (Node node : nodeStorage)
//            {
//                //                node.setVisited(false);
//                node.setVisited(Visited.WHITE);
//            }
//            return false;
//        }
//    }

    @Override public Graph getTransposition()
    {
        Graph transposition = new Graph(name, description);
        for (Node node : nodeStorage)
            transposition.addNodes(new Node(node));

        for (Relationship relationship : relationshipStorage) {
            transposition.addRelationship(
                    transposition.findNodeBySHACode(relationship.getEndNode().getSHA256Code()),
                    transposition.findNodeBySHACode(relationship.getBeginNode().getSHA256Code())
            );
        }

        //  refreshing sha codes for new nodes
        for (Node node : transposition.nodeStorage)
            node.generateSHACode();

        return transposition;
    }

    private Set<Node> getNotVisitedNodes() {
        Set<Node> notVisitedNodes = new HashSet<>();
        for (Node node : nodeStorage)
            if (node.getVisited() == Visited.WHITE)
                notVisitedNodes.add(node);
        return notVisitedNodes;
    }


    @Override public Path doDFS(Node beginNode)
    {
        /*
        Stack<Node> nodeStack = new Stack<>();
        Path path = new Path();
        nodeStack.push(beginNode);

        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();

            node.setVisited(true);
            System.out.println("added node " + node.getName());
            path.addNodes(node);


            for (Node neighbour : node.getOutGoingNeighbours())
                if (neighbour.isVisited() == false)
                    nodeStack.push(neighbour);

//            if (nodeStack.isEmpty())
//                for (Node notVisitedNode : getNotVisitedNodes())
//                    nodeStack.push(notVisitedNode);

        }

        return path;

        */
        return null;
    }

    @Override public void doBFS(Node beginNode)
    {

    }
}
