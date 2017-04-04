package com.etermax.flickr.utils;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Luis Tundisi on 04/04/2017.
 */

public class DateUtils {

    public static String getDateByTimeStamp(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis((time * 1000L));
        String date = DateFormat.format("yyyy-MM-dd hh:mm:ss", cal).toString();
        return date;
    }
}
