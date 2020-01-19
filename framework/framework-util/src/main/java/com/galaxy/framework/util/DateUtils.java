package com.galaxy.framework.util;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author aaron.pan
 * @date 2018/5/23
 */
public class DateUtils {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    public static final String DEFAULT_SHORT_DATE_FORMAT = "yyyyMMdd";


    /**
     * 构建DateTime
     *
     * @param date
     * @return
     */
    private static DateTime getDateTime(Date date) {
        return new DateTime(date);
    }

    /**
     * 构建当前时间的DateTime
     *
     * @return
     */
    private static DateTime getDateTime() {
        return getDateTime(null);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date currentDate() {
        return getDateTime().toDate();
    }

    /**
     * 格式化时间
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        return getDateTime(date).toString(format);
    }

    /**
     * 格式化日期格式:yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return format(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 格式化日期时间格式:yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String formatDateTime(Date date) {
        return format(date, DEFAULT_DATE_TIME_FORMAT);
    }

    /**
     * 格式化日期时间格式:yyyy-MM-dd HH:mm
     *
     * @param date
     * @return
     */
    public static String formatDateMinute(Date date) {
        return format(date, DEFAULT_DATE_MINUTE_FORMAT);
    }

    /**
     * 格式化时间格式:HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String formatTime(Date date) {
        return format(date, DEFAULT_TIME_FORMAT);
    }


    /**
     * 格式化当前日期
     *
     * @param format
     * @return
     */
    public static String formateCurrent(String format) {
        return format(currentDate(), format);
    }

    /**
     * 格式化当前日期为日期
     *
     * @return
     */
    public static String formateShortCurrent() {
        return formateCurrent(DEFAULT_SHORT_DATE_FORMAT);
    }

    /**
     * 格式化当前日期的日期格式
     *
     * @return
     */
    public static String formatDateCurrent() {
        return formatDate(currentDate());
    }

    /**
     * 格式化当前日期的日期时间格式
     *
     * @return
     */
    public static String formatDateTimeCurrent() {
        return formatDateTime(currentDate());
    }

    /**
     * 格式化当前日期的时间格式
     *
     * @return
     */
    public static String formatTimeCurrent() {
        return formatTime(currentDate());
    }

    /**
     * 根据格式解析字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static Date parse(String date, String format) {
        return DateTime.parse(date, DateTimeFormat.forPattern(format)).toDate();
    }

    /**
     * 解析成日期格式:yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
        return DateTime.parse(date, DateTimeFormat.forPattern(DEFAULT_DATE_FORMAT)).toDate();
    }

    /**
     * 解析成日期时间格式:yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static Date parseDateTime(String date) {
        return DateTime.parse(date, DateTimeFormat.forPattern(DEFAULT_DATE_TIME_FORMAT)).toDate();
    }

    /**
     * 解析成日期时间格式:yyyy-MM-dd HH:mm
     *
     * @param date
     * @return
     */
    public static Date parseDateMinute(String date) {
        return DateTime.parse(date, DateTimeFormat.forPattern(DEFAULT_DATE_MINUTE_FORMAT)).toDate();
    }


    /**
     * 解析成时间格式:HH:mm:ss
     *
     * @param date
     * @return
     */
    public static Date parseTime(String date) {
        return DateTime.parse(date, DateTimeFormat.forPattern(DEFAULT_TIME_FORMAT)).toDate();
    }

    /**
     * 计算两个时间相隔的秒数
     *
     * @param
     * @return
     */

    public static String compareDate(Date d1, Date d2) {
        long dif = d1.getTime() - d2.getTime();
        long day = dif / (24 * 60 * 60 * 1000);
        long hour = (dif / (60 * 60 * 1000) - day * 24);
        long min = ((dif / (60 * 1000)) - day * 24 * 60 - hour * 60);
        String seconds = Long.toString(dif/1000);
        return seconds;
    }


    public static void main(String[] args) {
        System.out.println(isAm("2018-10-20 17:12:44"));
    }

    public static List<String> findDates(Date dBegin, Date dEnd) {
        List<String> lDate = new ArrayList<String>();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        lDate.add(sd.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (dEnd.after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(sd.format(calBegin.getTime()));
        }
        return lDate;
    }

    public static boolean isAm(String thisDate) {
        Date date = parseDateTime(thisDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour < 12) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAm(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour < 12) {
            return true;
        } else {
            return false;
        }
    }
}
