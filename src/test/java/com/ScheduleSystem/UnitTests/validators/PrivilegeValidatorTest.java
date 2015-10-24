package com.ScheduleSystem.UnitTests.validators;

import com.ScheduleSystem.domain.employees.Privilege;
import com.ScheduleSystem.validators.PrivilegeValidator;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Created by SG0222895 on 8/3/2015.
 */
public class PrivilegeValidatorTest
{

    @Test
    public void correctPrivilegeTest() {
        Privilege validPrivilege = new Privilege("create projects");
        PrivilegeValidator privilegeValidator = new PrivilegeValidator();

        Errors errors = new BeanPropertyBindingResult(validPrivilege, "validPrivilege");
        ValidationUtils.invokeValidator(privilegeValidator, validPrivilege, errors);
        Assert.assertEquals(0, errors.getErrorCount());
        Assert.assertEquals(0, errors.getFieldErrorCount());
    }

    @Test
    public void NullFieldTest() {
        Privilege invalidPrivilege = new Privilege(null);
        PrivilegeValidator privilegeValidator = new PrivilegeValidator();

        Errors errors = new BeanPropertyBindingResult(invalidPrivilege, "invalidPrivilege");
        ValidationUtils.invokeValidator(privilegeValidator, invalidPrivilege, errors);
        Assert.assertEquals(1, errors.getFieldErrorCount());
        Assert.assertEquals("privilege", errors.getFieldError("privilege").getField());
    }

    @Test
    public void EmptyFieldTest() {
        Privilege invalidPrivilege = new Privilege("");
        PrivilegeValidator privilegeValidator = new PrivilegeValidator();

        Errors errors = new BeanPropertyBindingResult(invalidPrivilege, "invalidPrivilege");
        ValidationUtils.invokeValidator(privilegeValidator, invalidPrivilege, errors);
        Assert.assertEquals(1, errors.getFieldErrorCount());
        Assert.assertEquals("privilege", errors.getFieldError("privilege").getField());
    }

}
