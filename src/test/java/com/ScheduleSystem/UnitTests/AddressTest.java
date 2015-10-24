package com.ScheduleSystem.UnitTests;

import com.ScheduleSystem.domain.employees.Address;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by SG0222895 on 7/21/2015.
 */
public class AddressTest
{
    @Test
    public void test() {
        Address address = new Address("Poland", "Warsaw","Wiejska", "00-902");

        Assert.assertEquals("Poland", address.getCountry());
        Assert.assertEquals("Warsaw", address.getCity());
        Assert.assertEquals("Wiejska", address.getStreet());
        Assert.assertEquals("00-902", address.getZipCode());


        Assert.assertEquals(address, new Address("Poland", "Warsaw", "Wiejska", "00-902"));
        Assert.assertTrue(new Address("Poland", "Warsaw", "Wiejska", "00-902").equals(new Address("Poland", "Warsaw", "Wiejska", "00-902")));
        Assert.assertFalse(new Address("Poland", "Warsaw", "Wiejska", "00-902") == new Address("Poland", "Warsaw", "Wiejska", "00-902"));
        Assert.assertTrue(new Address("Poland", "Warsaw", "Wiejska", "00-902").hashCode() == new Address("Poland", "Warsaw", "Wiejska", "00-902").hashCode());
    }
}
