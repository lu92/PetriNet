package com.ScheduleSystem.domain.taskmanagment;

import com.ScheduleSystem.domain.taskmanagment.graph.AbstractGraph;
import com.ScheduleSystem.domain.taskmanagment.graph.Graph;
import com.ScheduleSystem.domain.taskmanagment.graph.GraphAlgorythmsImpl;
import com.ScheduleSystem.domain.taskmanagment.graph.Node;
import com.ScheduleSystem.domain.employees.Person;
import com.ScheduleSystem.domain.taskmanagment.graph.factory.GraphFactory;
import com.ScheduleSystem.domain.taskmanagment.graph.factory.GraphType;
import lombok.Data;

import java.util.Set;

/**
 * Created by SG0222895 on 7/23/2015.
 */
@Data
public class TaskScheduler
{
    private String name;
    private String description;
    private AbstractGraph graph;

    public TaskScheduler()
    {
        graph = GraphFactory.getGraph(GraphType.DIRECTED, "", "", new GraphAlgorythmsImpl());
    }

    public TaskScheduler(String name, String description)
    {
        this();
        this.name = name;
        this.description = description;
    }

//    public void addTasks(Task ... tasks) {
//        for (Task task : tasks)
//        {
//            Node node = new Node(task);
//            graph.addNodes(node);
//        }
//    }

    public void removeTask(Task task) {
        if (task.getNode().isIsolated())
            graph.removeNode(task.getNode());
        else
            throw new IllegalArgumentException("cannot remove unisolated task");
    }

    public void connectTasks(Task beginTask, Task endTask) {
        graph.addRelationship(beginTask.getNode(), endTask.getNode());
    }

    public void disconnectTasks(Task beginTask, Task endTask) {
        graph.removeRelationship(beginTask.getNode(), endTask.getNode());
    }

    public long getNumberOfTasks() {
        return graph.getNumberOfNodes();
    }

    public long getNumberOfConnections(){
        return graph.getNumberOfRelationships();
    }

    public Set<Person> getWorkers() {
        return null;
    }
}
