package com.fairychar.bag.utils;

import cn.hutool.core.lang.Assert;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/3/24 <br>
 * time: 12:14 <br>
 *
 * @author chiyo <br>
 * @since 0.0.1-SNAPSHOT
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateConvertUtil {
    private static Set<String> supportDateFormat = new HashSet<String>() {{
        add("yyyy-MM-dd");
        add("yyyyMMdd");
        add("yyyyMd");
        add("yyyy/M/d");
        add("yyyy/MM/dd");
    }};

    private static Set<String> supportDateTimeFormat = new HashSet<String>() {{
        add("yyyy-MM-dd HH:mm:ss");
        add("yyyyMMdd HH:mm:ss");
        add("yyyyMd HH:mm:ss");
        add("yyyy/M/d HH:mm:ss");
        add("yyyy/M/d HH/mm/ss");
        add("yyyy/MM/dd HH/mm/ss");
    }};


    public static LocalDateTime parseTime(String text) {
        Assert.notBlank(text);
        for (String format : supportDateTimeFormat) {
            if (text.length() == format.length()) {
                try {
                    return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(format));
                } catch (Exception e) {
                }
            }
        }
        return null;
    }

    public static LocalDate parseDate(String text) {
        Assert.notBlank(text);
        for (String format : supportDateFormat) {
            if (text.length() == format.length()) {
                try {
                    return LocalDate.parse(text, DateTimeFormatter.ofPattern(format));
                } catch (Exception e) {
                }
            }
        }
        return null;
    }


    public static LocalDateTime dateToLocaldateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    public static LocalDate dateToLocaldate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }


    public static Date localdateToDate(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

}
