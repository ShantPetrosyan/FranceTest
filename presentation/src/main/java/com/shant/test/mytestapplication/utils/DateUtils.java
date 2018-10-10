package com.shant.test.mytestapplication.utils;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {

    public static final DateFormat REVIEW_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.FRANCE);

    public static final DateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);

    public static final DateFormat SIMPLE_TIME_FORMAT = new SimpleDateFormat("HH:mm", Locale.FRANCE);

    public static final DateFormat SIMPLE_TIME_FORMAT_TIMEZONE = new SimpleDateFormat("HH:mm a", Locale.FRANCE);

    /**
     * Setting time zone to the following formats. Make sure you do this to maintain timezone
     * consistency.
     */
    static {
        final TimeZone timeZone = TimeZone.getTimeZone("UTC");
        REVIEW_DATE_FORMAT.setTimeZone(timeZone);
        SIMPLE_DATE_FORMAT.setTimeZone(timeZone);
        SIMPLE_TIME_FORMAT.setTimeZone(timeZone);
        SIMPLE_TIME_FORMAT_TIMEZONE.setTimeZone(timeZone);
    }

    public static String getDayOfWeekName(Long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        Date date = calendar.getTime();
        return SIMPLE_TIME_FORMAT_TIMEZONE.format(date);
    }

    /**
     * Convert a date String coming from the server to a Calendar object.
     */
    public static String getDayOfWeekName(String time) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(REVIEW_DATE_FORMAT.parse(time));
        } catch (ParseException e) {
            System.out.print("Unable to format date");
        }

        int day = calendar.get(Calendar.DAY_OF_WEEK);

        return getWeekName(day);
    }

    /**
     * Convert a date String coming from the server to a Calendar object.
     */
    public static String getDayOfWeekName(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        return getWeekName(day);
    }

    private static String getWeekName(int day) {
        switch (day) {
            case Calendar.SUNDAY:
                return "Sun";
            case Calendar.MONDAY:
                return "Mon";
            case Calendar.TUESDAY:
                return "Tue";
            case Calendar.WEDNESDAY:
                return "Wed";
            case Calendar.THURSDAY:
                return "Thu";
            case Calendar.FRIDAY:
                return "Fri";
            default:
            case Calendar.SATURDAY:
                return "Sat";
        }
    }

    /**
     * Receives a String representing a date, and formats it to dd MMM yyyy.
     *
     * @param date a String representing the date.
     * @return a String representing the date in a different format.
     */
    public static String formatDateFromStringWithOffset(String date, DateFormat inFormat,
            DateFormat outFormat) {

        try {
            final Date inputDate = inFormat.parse(date);
            final int offsetFromUTC = TimeZone.getDefault().getOffset(inputDate.getTime());
            final Date bstTime = new Date(inputDate.getTime() + offsetFromUTC);
            return outFormat.format(bstTime);
        } catch (Exception e) {
            Log.e(date, "Unable to format date");
        }

        return "";
    }

    public static long getMilliseconds(final String date) {
        try {
            final Date inputDate = REVIEW_DATE_FORMAT.parse(date);
            return inputDate.getTime();
        } catch (Exception e) {
            Log.e(date, "Unable to format date");
        }

        return -1;
    }
}
