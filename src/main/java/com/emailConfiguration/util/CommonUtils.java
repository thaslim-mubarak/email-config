package com.emailConfiguration.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommonUtils {
    public static String getCurrentTime(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        var date = ZonedDateTime.now();
        return date.format(dtf);
    }

}
