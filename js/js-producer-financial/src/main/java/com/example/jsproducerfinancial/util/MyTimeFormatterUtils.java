package com.example.jsproducerfinancial.util;

import com.google.common.collect.Maps;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @auther: 666先生的救赎
 * @date: 2019/1/6 17:04
 * 时间 <-----> 字符串转换
 */
public class MyTimeFormatterUtils {

    public static final String TIME_FORMAT_PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_PATTERN_YEARMONTHDAY = "yyyy-MM-dd";
    public static final String TIME_FORMAT_PATTERN_HOURMINSEC = "HH:mm:ss";
    public static final String TIME_FORMAT_PATTERN_SHORTDATE_TIME = "yyyy/MM/dd HH:mm:ss";
    public static final String TIME_FORMAT_PATTERN_SHORTDATE = "yyyy/MM/dd";
    public static final String TIME_FORMAT_PATTERN_LONGDATE = "yyyy/MM/dd EE";
    private static final Map<Locale,String> TIME_FORMAT_PATTERN_LOCAL = Maps.newHashMap();

    static {
        TIME_FORMAT_PATTERN_LOCAL.put(Locale.CHINA,"yyyy年MM月dd日 EE");
    }

    /**
     * 字符转换时间，默认转换器
     * @param dateStr
     * @return
     */
    public static Date String2Date(String dateStr){
        return String2Date(dateStr,TIME_FORMAT_PATTERN_DEFAULT);
    }

    /**
     * 字符转换时间，指定自定义转换器
     * @param dateStr
     * @param formatPattern
     * @return
     */
    public static Date String2Date(String dateStr, String formatPattern){
        DateTimeFormatter format = DateTimeFormat.forPattern(formatPattern);
        DateTime dateTime = DateTime.parse(dateStr, format);
        return dateTime.toDate();
    }

    /**
     * 时间转换字符，默认转换器
     * @param date
     * @return
     */
    public static String Date2String(Date date){
        return Date2String(date,TIME_FORMAT_PATTERN_DEFAULT);
    }

    /**
     * 时间转换字符，指定自定义转换器
     * @param date
     * @param formatPattern
     * @return
     */
    public static String Date2String(Date date, String formatPattern){
        return new DateTime(date).toString(formatPattern);
    }

    /**
     * 当前时间
     * @return 时间格式
     */
    public static Date nowDate(){
        return DateTime.now().toDate();
    }

    /**
     * 当前年月日
     * @return 时间格式
     */
    public static Date nowYearMonthDayDate(){
        return LocalDate
                .now()
                .toDate();
    }


    /**
     * 当前时间
     * @return 字符
     */
    public static String nowStr(){
        return DateTime
                .now()
                .toString(TIME_FORMAT_PATTERN_DEFAULT);
    }

    /**
     * 当前年月日
     * @return 字符
     */
    public static String nowYearMonthDayStr(){
        return LocalDate
                .now()
                .toString(TIME_FORMAT_PATTERN_YEARMONTHDAY);
    }

    /**
     * 当前时分秒
     * @return 字符
     */
    public static String nowHourMinutesSecondsStr(){
        return LocalTime
                .now()
                .toString(TIME_FORMAT_PATTERN_HOURMINSEC);
    }

    /**
     * 当前短日期
     * @return 字符
     */
    public static String nowShortDate(){
        return formatShortDate(LocalDate.now().toDate());
    }

    /**
     * 指定时间短日期
     * @param date
     * @return 字符
     */
    public static String formatShortDate(Date date){
        return new LocalDate(date).toString(TIME_FORMAT_PATTERN_SHORTDATE);
    }

    /**
     * 当前长日期
     * @return 字符
     */
    public static String nowLongDate(){
        return formatLongDate(LocalDate.now().toDate());
    }

    /**
     * 指定时间长日期
     * @param date
     * @return 字符
     */
    public static String formatLongDate(Date date){
        return new LocalDate(date).toString(TIME_FORMAT_PATTERN_LONGDATE);
    }

    /**
     * 返回本地时间
     * @param date
     * @return
     */
    public static String stringLocalDate(Date date){
        return Date2String(date,TIME_FORMAT_PATTERN_LOCAL.get(Locale.getDefault()));
    }

}
