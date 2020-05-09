package com.zsn.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 16:39
 * @Version 1.0
 **/
public class DateUtils {

    public static Date getDateBefore(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - day);
        return calendar.getTime();
    }
}
