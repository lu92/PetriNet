package com.ScheduleSystem.tools;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by SG0222895 on 8/6/2015.
 */
public class StringToLocalDate implements Converter<String, LocalDate>
{
    @Override public LocalDate convert(String date)
    {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy/MM/dd");
        return dtf.parseLocalDate(date);
    }
    //    public static LocalDate convert(String date) {
//        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy/MM/dd");
//        return dtf.parseLocalDate(date);
//    }
}
