package com.ScheduleSystem.domain.taskmanagment;

import com.ScheduleSystem.domain.taskmanagment.graph.Node;
import com.ScheduleSystem.domain.employees.Person;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.joda.time.DateTime;
import org.joda.time.Period;

/**
 * Created by SG0222895 on 7/21/2015.
 */
@Data
public class Task
{
    protected Long id;
    protected String name;
    protected double weight;
    protected DateTime startTime;
    protected DateTime endTime;
    protected DateTime desiredEndTime;
    protected @Setter(AccessLevel.NONE) Period executionTime;
    protected @Setter(AccessLevel.NONE) TaskState taskState;
    protected TaskDifficulty taskDifficulty;


    protected Node node;
    protected Person person;

    public Task()
    {
    }

    public Task(String name, DateTime startTime, DateTime desiredEndTime)
    {
        this.name = name;
        this.weight = 1;
        this.startTime = startTime;
        this.desiredEndTime = desiredEndTime;
    }

    public Task(String name, double weight, DateTime startTime, DateTime desiredEndTime)
    {
        this(name, startTime, desiredEndTime);
        this.weight = weight;
    }

    public void executeTask() {
        endTime = DateTime.now();
        executionTime = new Period(startTime, endTime);
    }

    public void executeTaskWithTime(DateTime dateTime) {
        endTime = dateTime;
        executionTime = new Period(startTime, endTime);
    }

    @Override public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Task task = (Task) o;

        if (Double.compare(task.weight, weight) != 0)
            return false;
        if (name != null ? !name.equals(task.name) : task.name != null)
            return false;
        if (startTime != null ? !startTime.equals(task.startTime) : task.startTime != null)
            return false;
        if (desiredEndTime != null ? !desiredEndTime.equals(task.desiredEndTime) : task.desiredEndTime != null)
            return false;
        if (executionTime != null ? !executionTime.equals(task.executionTime) : task.executionTime != null)
            return false;
        return !(node != null ? !node.equals(task.node) : task.node != null);

    }

    @Override public int hashCode()
    {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (desiredEndTime != null ? desiredEndTime.hashCode() : 0);
        result = 31 * result + (executionTime != null ? executionTime.hashCode() : 0);
        result = 31 * result + (node != null ? node.hashCode() : 0);
        return result;
    }
}
