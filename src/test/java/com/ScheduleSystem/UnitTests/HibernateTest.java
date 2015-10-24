package com.ScheduleSystem.UnitTests;

import com.ScheduleSystem.UnitTests.BeanConfigurations.HibernateConfiguration;
import com.ScheduleSystem.domain.employees.Address;
import com.ScheduleSystem.repositories.AddressRepository;
import junit.framework.Assert;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SG0222895 on 8/7/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
@Transactional
@Ignore
public class HibernateTest
{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void saveAddress()
    {
        Assert.assertNotNull(addressRepository);
        Assert.assertNotNull(sessionFactory);
        Address address = new Address("Poland", "Warsaw", "Wiejska", "30-290 Warsaw");
        addressRepository.save(address);
        Assert.assertNotNull(addressRepository.get(3l));
        System.out.println("wartosc z optional dla zmiennej address " + addressRepository.get(3l));
        for (Address addressDb : addressRepository.findAll())
            System.out.println(addressDb);
    }
}
