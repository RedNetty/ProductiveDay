package com.rednetty.utils;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static Date getCurrentDate() {
        return Date.from(Instant.now());
    }

    public static Time getCurrentTime() {
        return Time.valueOf(LocalTime.now());
    }
}
