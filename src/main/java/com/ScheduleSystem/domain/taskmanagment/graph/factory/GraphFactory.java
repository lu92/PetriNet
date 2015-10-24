package com.ScheduleSystem.domain.taskmanagment.graph.factory;

import com.ScheduleSystem.domain.taskmanagment.graph.AbstractGraph;
import com.ScheduleSystem.domain.taskmanagment.graph.DirectedGraph;
import com.ScheduleSystem.domain.taskmanagment.graph.GraphAlgorithms;
import com.ScheduleSystem.domain.taskmanagment.graph.UndirectedGraph;

/**
 * Created by SG0222895 on 7/26/2015.
 */
public class GraphFactory
{
    private static GraphFactory graphFactory = new GraphFactory();

    private GraphFactory()
    {
    }

    public static AbstractGraph getGraph(GraphType graphType) {
        switch (graphType) {
            case DIRECTED:
                return new DirectedGraph();

            case UNDIRECTED:
                return new UndirectedGraph();
        }
        return null;
    }

    public static AbstractGraph getGraph(GraphType graphType, String name, String description) {
        switch (graphType) {
            case DIRECTED:
                return new DirectedGraph(name, description);

            case UNDIRECTED:
                return new UndirectedGraph(name, description);
        }
        return null;
    }

    public static AbstractGraph getGraph(GraphType graphType, String name, String description, GraphAlgorithms graphAlgorithms) {
        switch (graphType) {
            case DIRECTED:
                return new DirectedGraph(name, description, graphAlgorithms);

            case UNDIRECTED:
                return new UndirectedGraph(name, description, graphAlgorithms);
        }
        return null;
    }
}
