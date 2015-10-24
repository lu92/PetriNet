package com.ScheduleSystem.UnitTests;

import com.ScheduleSystem.domain.employees.Address;
import com.ScheduleSystem.domain.employees.Person;
import junit.framework.Assert;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SG0222895 on 7/21/2015.
 */
public class PersonTest
{
    private Person firstPerson;
    private Person secondPerson;
    private Person thirdPerson;

    @Before
    public void init() {
        firstPerson = new Person(1L, "Jan", "Kowalski", new LocalDate(1990, 10, 12), "123456789", new Address("Poland", "Warsaw", "wiejska", "00-902"));
        secondPerson = new Person(2L, "Jan", "Kowalski", new LocalDate(1990, 10, 12), "123456789", new Address("Poland", "Warsaw", "wiejska", "00-902"));
        thirdPerson = new Person(3L, "Tomasz", "Kowalski", new LocalDate(1980, 7, 22), "123456789", new Address("Poland", "Warsaw", "wiejska", "00-902"));
    }

    @Test
    public void createPersonTest() {
        Assert.assertNotNull(firstPerson);
        Assert.assertNotNull(secondPerson);
        Assert.assertNotNull(thirdPerson);
    }

    @Test
    public void equalsAndHashCodeTest() {
        Assert.assertNotSame(firstPerson, secondPerson);
        Assert.assertFalse(firstPerson.equals(secondPerson));
        Assert.assertFalse(firstPerson.equals(thirdPerson));


        Assert.assertEquals(firstPerson, firstPerson);
        Assert.assertTrue(firstPerson.equals(firstPerson));

        Assert.assertTrue(firstPerson.hashCode() == firstPerson.hashCode());
        Assert.assertFalse(firstPerson.hashCode() == secondPerson.hashCode());
    }
}
