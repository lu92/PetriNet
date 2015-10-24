package com.ScheduleSystem.validators;

import com.ScheduleSystem.domain.employees.Privilege;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by SG0222895 on 8/3/2015.
 */
public class PrivilegeValidator implements Validator
{
    @Override public boolean supports(Class<?> aClass)
    {
        return Privilege.class.equals(aClass);
    }

    @Override public void validate(Object o, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "privilege", "privilege.privilege");
    }
}
