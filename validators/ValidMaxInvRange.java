package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {MaxInvValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidMaxInvRange {

    String message() default   "Inventory must be less than or equal to maximum inventory value";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}
