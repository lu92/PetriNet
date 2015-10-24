package com.ScheduleSystem.domain.taskmanagment.graph;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by SG0222895 on 7/26/2015.
 */
public class GraphAlgorythmsImpl implements GraphAlgorithms
{
    private AbstractGraph graph;

    @Override public void setGraph(AbstractGraph graph)
    {
        this.graph = graph;
    }

    @Override
    public Path getLightestPathBetweenTwoNodes(Node beginNode, Node endNode) {
        return null;
    }

//    @Override public Path getLightestPathBetweenTwoNodes(Node beginNode, Node endNode)
//    {
//        int N = graph.getNumberOfNodes();
//        RealMatrix matrix = MatrixUtils.createRealMatrix(N, N);
//
//
//        // initiating the matrix
//        for (int i=0; i<N; i++) {
//            for (int j=0; j<N; j++) {
//                if (i == j) matrix.setEntry(i, j, 0);
//                else matrix.setEntry(i, j, Integer.MAX_VALUE);
//            }
//        }
//
//        RealMatrix p = MatrixUtils.createRealMatrix(N, N);
//        // filling the prevoius matrix
//        for (int i=0; i<N; i++)
//            for (int j=0; j<N; j++)
//                p.setEntry(i, j, -1);
//
//        // setting the weights between every nodes
//        List<Node> nodeList = new ArrayList<>(graph.getNodeStorage());
//        nodeList.sort(new Comparator<Node>()
//        {
//            @Override public int compare(Node node1, Node node2)
//            {
//                return node1.getName().compareTo(node2.getName());
//            }
//        });
//
////        System.out.print("nodeList ");
////        for (Node node : nodeList)
////            System.out.print(node.getName() + "\t");
////        System.out.print("\n\n");
//
//        for (int i=0; i<N; i++) {
//            Node selectedNode = nodeList.get(i);
//            for (Relationship outgoingRelationship : selectedNode.getOutGoingRelationShipStorage())
//            {
//                matrix.setEntry(i, nodeList.indexOf(outgoingRelationship.getEndNode()), outgoingRelationship.getWeight());
//                p.setEntry(i, nodeList.indexOf(outgoingRelationship.getEndNode()), i);
//            }
//        }
//
////        algorithm
//        for (int k=0; k<N; k++) {
//            for (int i=0; i<N; i++) {
//                for (int j=0; j<N; j++) {
//
////                    if (matrix.getEntry(i, k) == Integer.MAX_VALUE || matrix.getEntry(k, j) == Integer.MAX_VALUE) continue;
////                    w = d[i][k] + d[k][j];
//
//                    if (matrix.getEntry(i, j) > matrix.getEntry(i, k) + matrix.getEntry(k, j)) {
////                        d[i][j] = w;
//                        matrix.setEntry(i, j, matrix.getEntry(i, k) + matrix.getEntry(k, j));
////                        p[i][j] = p[k][j];
//                        p.setEntry(i, j, p.getEntry(k, j));
//                    }
//                }
//            }
//        }
//
//
//        //  show the matrix
////        for (int i=0; i<N; i++) {
////            for (int j=0; j<N; j++) {
////                if (matrix.getEntry(i, j) == Integer.MAX_VALUE) System.out.print("INF\t");
////                else System.out.print(matrix.getEntry(i, j) + "\t");
////            }
////            System.out.println();
////        }
////
////        System.out.print("\n\np:\n");
////
////        //  show the p
////        for (int i=0; i<N; i++) {
////            for (int j=0; j<N; j++) {
////                if (p.getEntry(i, j) == Integer.MAX_VALUE) System.out.print("INF\t");
////                else System.out.print(p.getEntry(i, j) + "\t");
////            }
////            System.out.println();
////        }
//
//
//
//        Stack pathStack = new Stack();
//        int i = nodeList.indexOf(beginNode);    // 4
//        int j = nodeList.indexOf(endNode);      // 2
////        System.out.println("searching the best path from [" + i + "]" + nodeList.get(i).getName() + " to " + j);
//
//        Path path = null;
//
//        if (p.getEntry(i, j) != -1)
//        {
//            path = new Path();
//
//            pathStack.push(endNode);
//            while (i != p.getEntry(i, j))
//            {
//                j = (int) p.getEntry(i, j);
//                //            System.out.println("current " + j);
//                pathStack.push(nodeList.get(j));
//            }
//
//            pathStack.push(beginNode);
//
//            //  wypisywanie
////            System.out.print("pathStack : ");
//            while (!pathStack.isEmpty())
//            {
//                Node node = (Node) pathStack.pop();
//                //            System.out.print(node.getName() + " ");
//                path.addNodes(node);
//            }
//        }
//        return path;
//    }

    @Override public boolean isTwoNodesAreConnectedInSelectedDirection(Node beginNode, Node endNode)
    {
        return false;
    }

    @Override
    public boolean isCyclic() {
        return false;
    }

//    @Override public boolean isCyclic()
//    {
//        if (graph.nodeStorage.size() < 3)
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
//                    node.setVisited(Visited.BLACK);
//                    for (Node neighbour : node.getOutGoingNeighbours())
//                        if (neighbour.getVisited() == Visited.BLACK)
//                            return true;
//                        else
//                            nodeStack.push(neighbour);
//                }
//            }
//
//            //            restoring the default visiting
//            for (Node node : graph.nodeStorage)
//                node.setVisited(Visited.WHITE);
//
//            return false;
//        }
//    }

    @Override public Graph getTransposition()
    {
        Graph transposition = new Graph(graph.name, graph.description);
        for (Node node : graph.nodeStorage)
            transposition.addNodes(new Node(node));

        for (Relationship relationship : graph.relationshipStorage) {
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

    @Override public Path doDFS(Node beginNode)
    {
        return null;
    }

    @Override public void doBFS(Node beginNode)
    {

    }

    private Set<Node> getNotVisitedNodes() {
        Set<Node> notVisitedNodes = new HashSet<>();
        for (Node node : graph.nodeStorage)
            if (node.getVisited() == Visited.WHITE)
                notVisitedNodes.add(node);
        return notVisitedNodes;
    }
}
