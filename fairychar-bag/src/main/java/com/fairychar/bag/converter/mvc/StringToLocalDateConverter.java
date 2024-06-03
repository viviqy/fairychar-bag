package com.fairychar.bag.converter.mvc;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * <p>spring mvc {@link String}转{@link LocalDate}</p>
 * 日期格式为yyyy-MM-dd
 *
 * @author chiyo
 * @since 0.0.1-SNAPSHOT
 */
public class StringToLocalDateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String s) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TemporalAccessor parse = dateTimeFormatter.parse(s);
        LocalDate localDate = LocalDate.from(parse);
        return localDate;
    }
}
