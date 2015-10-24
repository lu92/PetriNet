package com.ScheduleSystem.UnitTests;

import com.ScheduleSystem.domain.taskmanagment.Task;
import com.ScheduleSystem.domain.taskmanagment.TaskScheduler;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by SG0222895 on 7/23/2015.
 */
@Ignore
public class TaskSchedulerTest
{
    private TaskScheduler taskScheduler;
    private Task task1, task2, task3, task4, task5, task6;

    @Before
    public void init() {
        taskScheduler = new TaskScheduler("tworzenie projektu", "projekt sklada sie z bazy danych i warstwy wizualnej");
        task1 = new Task("Projektowanie aplikacji", new DateTime(2015, 7, 1, 0, 0), new DateTime(2015, 7, 2, 0, 0));
        task2 = new Task("Implementacja bazy danych", new DateTime(2015, 7, 2, 0, 0), new DateTime(2015, 7, 6, 0, 0));
        task3 = new Task("Testowanie bazy danych", new DateTime(2015, 7, 6, 0, 0), new DateTime(2015, 7, 10, 0, 0));
        task4 = new Task("Tworzenie backend", new DateTime(2015, 7, 2, 0, 0), new DateTime(2015, 7, 10, 0, 0));
        task5 = new Task("tworzenie UI", new DateTime(2015, 7, 4, 0, 0), new DateTime(2015, 7, 8, 0, 0));
        task6 = new Task("skladanie projektu", new DateTime(2015, 7, 10, 0, 0), new DateTime(2015, 7, 12, 0, 0));
    }

    @Test
    public void createTaskScheduler() {
//        taskScheduler.addTasks(task1, task2, task3, task4, task5, task6);
        Assert.assertEquals(6, taskScheduler.getNumberOfTasks());

        taskScheduler.connectTasks(task1, task2);
        taskScheduler.connectTasks(task1, task4);
        taskScheduler.connectTasks(task1, task5);
        taskScheduler.connectTasks(task2, task3);
        taskScheduler.connectTasks(task3, task6);
        taskScheduler.connectTasks(task4, task6);
        taskScheduler.connectTasks(task5, task6);

        Assert.assertEquals(7, taskScheduler.getNumberOfConnections());

    }

}
