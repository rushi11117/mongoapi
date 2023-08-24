package com.example.GameSchedule.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public Date stringToDate(String datestr) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(datestr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}
