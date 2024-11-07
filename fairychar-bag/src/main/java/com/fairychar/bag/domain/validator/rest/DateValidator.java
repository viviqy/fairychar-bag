package com.fairychar.bag.domain.validator.rest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * 日期范围校验器
 *
 * @author chiyo
 * @since 1.3.2
 */
public class DateValidator implements ConstraintValidator<DateBetween, String> {

    private String pattern;
    private String min;
    private String max;

    private static final String NOW = "now";

    @Override
    public void initialize(DateBetween dateBetween) {
        ConstraintValidator.super.initialize(dateBetween);
        this.pattern = dateBetween.pattern();
        this.min = dateBetween.min();
        this.max = dateBetween.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate requestDate = LocalDate.parse(value, dateTimeFormatter);
        LocalDate minDate = NOW.equals(this.min) ? LocalDate.now() : LocalDate.parse(this.min, dateTimeFormatter);
        LocalDate maxDate = NOW.equals(this.max) ? LocalDate.now() : LocalDate.parse(this.max, dateTimeFormatter);
        if (minDate.isBefore(requestDate) && requestDate.isBefore(maxDate)) {
            return true;
        }
        return false;
    }

}
