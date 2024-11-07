package com.fairychar.bag.domain.validator.rest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * 时间范围校验器
 *
 * @author chiyo
 * @since 1.3.2
 */
public class TimeValidator implements ConstraintValidator<TimeBetween, String> {

    private String pattern;
    private String min;
    private String max;

    private static final String NOW = "now";

    @Override
    public void initialize(TimeBetween timeBetween) {
        ConstraintValidator.super.initialize(timeBetween);
        this.pattern = timeBetween.pattern();
        this.min = timeBetween.min();
        this.max = timeBetween.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime requestTime = LocalDateTime.parse(value, dateTimeFormatter);
        LocalDateTime minDate = NOW.equals(this.min) ? LocalDateTime.now() : LocalDateTime.parse(this.min, dateTimeFormatter);
        LocalDateTime maxDate = NOW.equals(this.max) ? LocalDateTime.now() : LocalDateTime.parse(this.max, dateTimeFormatter);
        if (minDate.isBefore(requestTime) && requestTime.isBefore(maxDate)) {
            return true;
        }
        return false;
    }

}
