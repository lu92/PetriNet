package com.ScheduleSystem.UnitTests.BeanConfigurations;

import com.ScheduleSystem.repositories.AddressRepository;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by SG0222895 on 8/7/2015.
 */
@Configuration
public class HibernateConfiguration
{
    @Bean
    public SessionFactory getSessionFactory() {
        SessionFactory sessionFactory;
        try{
            sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            System.out.println("creating sessionFactory");
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return sessionFactory;
    }

    @Bean
    public AddressRepository getAddressRepository() {
        return new AddressRepository(getSessionFactory());
    }
}
