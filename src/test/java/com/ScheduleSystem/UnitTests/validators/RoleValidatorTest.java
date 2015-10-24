package com.ScheduleSystem.UnitTests.validators;

import com.ScheduleSystem.domain.employees.Role;
import com.ScheduleSystem.validators.PrivilegeValidator;
import com.ScheduleSystem.validators.RoleValidator;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Created by SG0222895 on 8/4/2015.
 */
public class RoleValidatorTest
{
    @Test
    public void validRoleTest() {
        Role role = new Role("Java Developer");
        role.addPrivilege("Spring Framework", "JSP", "Java 8");
        RoleValidator roleValidator = new RoleValidator(new PrivilegeValidator());
        Errors errors = new BeanPropertyBindingResult(role, "role validation");
        ValidationUtils.invokeValidator(roleValidator, role, errors);
        Assert.assertEquals(0, errors.getErrorCount());
    }
}
