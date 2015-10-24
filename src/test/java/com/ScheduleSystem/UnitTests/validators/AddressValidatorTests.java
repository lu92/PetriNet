package com.ScheduleSystem.UnitTests.validators;

import com.ScheduleSystem.domain.employees.Address;
import com.ScheduleSystem.validators.AddressValidator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Created by SG0222895 on 8/3/2015.
 */
public class AddressValidatorTests
{

    @Test
    public void ValidAddressTest() {
        Address invalidAddress = new Address("Poland", "Warsaw", "Wiejska", "23-990");
        AddressValidator addressValidator = new AddressValidator();
        Errors errors = new BeanPropertyBindingResult(invalidAddress, "invalidAddress");
        ValidationUtils.invokeValidator(addressValidator, invalidAddress, errors);
        Assert.assertFalse(errors.hasErrors());
    }

    @Test
    public void InvalidAddressWithoutCountryTest() {
        Address invalidAddress = new Address("", "Warsaw", "Wiejska", "23-990");
        AddressValidator addressValidator = new AddressValidator();
        Errors errors = new BeanPropertyBindingResult(invalidAddress, "invalidAddress");
        ValidationUtils.invokeValidator(addressValidator, invalidAddress, errors);
        Assert.assertTrue(errors.hasErrors());
        Assert.assertEquals(1, errors.getErrorCount());
        Assert.assertEquals("country", errors.getFieldError().getField());
    }

    @Test
    public void InvalidAddressWithoutAnyFieldsTest() {
        Address invalidAddress = new Address("", "", "", "");
        AddressValidator addressValidator = new AddressValidator();
        Errors errors = new BeanPropertyBindingResult(invalidAddress, "invalidAddress");
        ValidationUtils.invokeValidator(addressValidator, invalidAddress, errors);
        Assert.assertTrue(errors.hasErrors());
        Assert.assertEquals(4, errors.getFieldErrorCount());
        Assert.assertEquals("country", errors.getFieldError("country").getField());
        Assert.assertEquals("city", errors.getFieldError("city").getField());
        Assert.assertEquals("street", errors.getFieldError("street").getField());
        Assert.assertEquals("zipCode", errors.getFieldError("zipCode").getField());
    }
}
