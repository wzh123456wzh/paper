package com.wzh.paper.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

    public static Date getDate(){
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        return time;
    }
}
