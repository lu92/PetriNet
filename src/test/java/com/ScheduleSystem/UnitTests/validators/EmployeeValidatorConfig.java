package com.ScheduleSystem.UnitTests.validators;

import com.ScheduleSystem.validators.AddressValidator;
import com.ScheduleSystem.validators.EmployeeValidator;
import com.ScheduleSystem.validators.PrivilegeValidator;
import com.ScheduleSystem.validators.RoleValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by SG0222895 on 8/5/2015.
 */
@Configuration
public class EmployeeValidatorConfig
{
    @Bean
    public EmployeeValidator getEmployeeValidator() {
        EmployeeValidator employeeValidator = new EmployeeValidator();
        employeeValidator.setAddressValidator(getAddressValidator());
        employeeValidator.setRoleValidator(getRoleValidator());
        return employeeValidator;
    }

    @Bean
    public PrivilegeValidator getPrivilegeValidator() {
        return new PrivilegeValidator();
    }

    @Bean
    public AddressValidator getAddressValidator() {
        return new AddressValidator();
    }

    @Bean
    public RoleValidator getRoleValidator() {
        RoleValidator roleValidator = new RoleValidator();
        roleValidator.setPrivilegeValidator(getPrivilegeValidator());
        return roleValidator;
    }
}
