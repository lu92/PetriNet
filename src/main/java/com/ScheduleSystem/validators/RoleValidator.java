package com.ScheduleSystem.validators;

import com.ScheduleSystem.domain.employees.Privilege;
import com.ScheduleSystem.domain.employees.Role;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by SG0222895 on 8/4/2015.
 */
public class RoleValidator implements Validator
{
    private Validator privilegeValidator;

    public void setPrivilegeValidator(Validator privilegeValidator)
    {
        this.privilegeValidator = privilegeValidator;
    }

    public RoleValidator()
    {
    }

    public RoleValidator(Validator privilegeValidator)
    {
        if (privilegeValidator == null)
            throw new IllegalArgumentException("The supplied [Validator] is required and must not be null");
        if (!privilegeValidator.supports(Privilege.class))
            throw new IllegalArgumentException("The supplied [Validator] must support the validation of [Privilege] instances");

        this.privilegeValidator = privilegeValidator;
    }

    @Override public boolean supports(Class<?> aClass)
    {
        return Role.class.equals(aClass);
    }

    @Override public void validate(Object target, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "role.name");
        Role role = (Role) target;

        int index = 0;
        for (Privilege privilege : role.getPrivilegeStorage()) {
            errors.pushNestedPath("privilegeStorage[" + index++ + "]");
            ValidationUtils.invokeValidator(this.privilegeValidator, privilege, errors);
            errors.popNestedPath();
        }
    }
}
