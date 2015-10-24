package com.ScheduleSystem.domain.employees;

import lombok.Data;
import org.joda.time.LocalDate;

/**
 * Created by SG0222895 on 7/28/2015.
 */
@Data
public class Leave
{
    private Long Id;
    private LocalDate beginLeaveDate;
    private LocalDate endLeaveDate;
    private Employee employee;

    public Leave()
    {
    }

    public Leave(LocalDate beginLeaveDate, LocalDate endLeaveDate, Employee employee)
    {
        this.beginLeaveDate = beginLeaveDate;
        this.endLeaveDate = endLeaveDate;
        this.employee = employee;
    }
}
