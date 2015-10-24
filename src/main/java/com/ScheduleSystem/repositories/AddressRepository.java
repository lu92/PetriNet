package com.ScheduleSystem.repositories;

import com.ScheduleSystem.domain.employees.Address;
import org.hibernate.SessionFactory;

/**
 * Created by SG0222895 on 8/7/2015.
 */

public class AddressRepository extends AbstractRepository<Address, Long>
{
    public AddressRepository()
    {
    }

    public AddressRepository(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }
}
