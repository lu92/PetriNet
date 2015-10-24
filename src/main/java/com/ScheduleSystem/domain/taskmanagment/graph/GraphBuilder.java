package com.ScheduleSystem.domain.taskmanagment.graph;

import com.ScheduleSystem.domain.taskmanagment.graph.factory.GraphFactory;
import com.ScheduleSystem.domain.taskmanagment.graph.factory.GraphType;

/**
 * Created by SG0222895 on 10/24/2015.
 */
public class GraphBuilder <T> {
    protected AbstractGraph graph;
    protected RelationshipBuilder relationshipBuilder;

    public GraphBuilder(GraphType graphType, String name, String description) {
        graph = GraphFactory.getGraph(graphType, name, description);
        relationshipBuilder = new RelationshipBuilder(this, graph);
    }

    public GraphBuilder addNodes(Node ... nodes) {
        for (Node node : nodes) {
            node.setGraph(graph);
            graph.getNodeStorage().add(node);
        }
        return this;
    }

    public RelationshipBuilder setUpRelations() {
        return relationshipBuilder;
    }

    public AbstractGraph build() {
        return graph;
    }

    public class RelationshipBuilder {

        private GraphBuilder graphBuilder;
        private AbstractGraph graph;

        public RelationshipBuilder(GraphBuilder graphBuilder, AbstractGraph graph) {
            this.graphBuilder = graphBuilder;
            this.graph = graph;
        }

        public RelationshipBuilder addRelationship(Node beginNode, Node endNode) {
            addRelationship(beginNode, endNode, 0);
            return this;
        }

         public RelationshipBuilder addRelationship(Node beginNode, Node endNode, int weight) {
             Relationship relationShip = new Relationship(beginNode, endNode, weight);
             beginNode.addOutgoingRelationShip(relationShip);
             beginNode.addNeighBourNode(endNode);

             endNode.addIncommingRelationShip(relationShip);
             endNode.addNeighBourNode(beginNode);
             graph.getRelationshipStorage().add(relationShip);
             return this;
        }

        public GraphBuilder end() {
            return graphBuilder;
        }
    }
}
