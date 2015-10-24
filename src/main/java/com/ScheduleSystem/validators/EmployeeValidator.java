package com.ScheduleSystem.validators;

import com.ScheduleSystem.domain.employees.Employee;
import com.ScheduleSystem.domain.employees.Role;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by SG0222895 on 8/4/2015.
 */
public class EmployeeValidator implements Validator
{
    private AddressValidator addressValidator;
    private RoleValidator roleValidator;

    public void setAddressValidator(AddressValidator addressValidator)
    {
        this.addressValidator = addressValidator;
    }

    public void setRoleValidator(RoleValidator roleValidator)
    {
        this.roleValidator = roleValidator;
    }


    @Override public boolean supports(Class<?> aClass)
    {
        return Employee.class.equals(aClass);
    }

    @Override public void validate(Object target, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "employee.name invalid");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "employee.lastname invalid");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "employee.username invalid");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "employee.password invalid");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephoneNumber", "employee.telephoneNumber invalid");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birth", "employee.birth invalid");

        Employee employee = (Employee) target;

        if (employee.getBirth() == null)
            errors.rejectValue("birth", "birth is null");


        if (employee.getLeaveDays() < 0)
            errors.rejectValue("leaveDays", "number of leave days is negative");

        errors.pushNestedPath("address");
        ValidationUtils.invokeValidator(addressValidator, employee.getAddress(), errors);
        errors.popNestedPath();


        if (employee.getRoleStorage().isEmpty())
            errors.rejectValue("roleStorage", "employee haven't got any role");
        else
        {
            int index = 0;
            for (Role role : employee.getRoleStorage())
            {
                errors.pushNestedPath("roleStorage[" + index++ + "]");
                ValidationUtils.invokeValidator(roleValidator, role, errors);
                errors.popNestedPath();
            }
        }
    }
}
