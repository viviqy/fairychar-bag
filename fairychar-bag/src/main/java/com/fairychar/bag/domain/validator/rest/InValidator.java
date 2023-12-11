package com.fairychar.bag.domain.validator.rest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author chiyo <br>
 * @since 1.0.2
 */
public class InValidator implements ConstraintValidator<In, String> {
    private String[] array;

    @Override
    public void initialize(In constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.array = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (String item : array) {
            if (item.equals(value)) {
                return true;
            }
        }
        return false;
    }

}
