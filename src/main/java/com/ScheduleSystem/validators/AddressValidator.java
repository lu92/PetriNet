package com.ScheduleSystem.validators;

import com.ScheduleSystem.domain.employees.Address;
import org.springframework.validation.*;

/**
 * Created by SG0222895 on 8/3/2015.
 */
public class AddressValidator implements Validator
{
    @Override public boolean supports(Class<?> aClass)
    {
        return Address.class.equals(aClass);
    }

    @Override public void validate(Object o, Errors errors)
    {
        Address address = (Address) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "address.country");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "address.city");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "address.street");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "address.zipCode");
    }
}
