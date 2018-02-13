package cn.com.zs.permissions.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 标题: 时间工具类
 * <p>
 * 描述: 时间工具类
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/12-12:00
 */
public class DateTimeUtils {

    private static final DateTimeFormatter DATE_TIME_FORMAT = TimeFormat.YYYY_MM_DD_HH_MM_SS.formatter;


    public static String now(){
        return LocalDateTime.now().format(DATE_TIME_FORMAT);
    }

    public static LocalDateTime parserDateTime(){
        return parserDateTime(now());
    }

    public static LocalDateTime parserDateTime(String timeStr){
        return LocalDateTime.parse(timeStr,DATE_TIME_FORMAT);
    }

    public static LocalDateTime parserDateTime(String timeStr,TimeFormat timeFormat){
        return LocalDateTime.parse(timeStr,timeFormat.formatter);
    }

    public static Date convertLDTToDate(){
        return Date.from(parserDateTime().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static long convertLDTToLong(){
        return convertLDTToDate().getTime();
    }


    public enum TimeFormat{
        MM_DD("MM-dd"),
        YYYY_MM("yyyy-MM"),
        YYYY_MM_DD("yyyy-MM-dd"),
        MM_DD_HH_MM("MM-dd HH:mm"),
        MM_DD_HH_MM_SS("MM-dd HH:mm:ss"),
        YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm"),
        YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss"),

        MM_DD_EN("MM/dd"),
        YYYY_MM_EN("yyyy/MM"),
        YYYY_MM_DD_EN("yyyy/MM/dd"),
        MM_DD_HH_MM_EN("MM/dd HH:mm"),
        MM_DD_HH_MM_SS_EN("MM/dd HH:mm:ss"),
        YYYY_MM_DD_HH_MM_EN("yyyy/MM/dd HH:mm"),
        YYYY_MM_DD_HH_MM_SS_EN("yyyy/MM/dd HH:mm:ss"),

        MM_DD_CN("MM月dd日"),
        YYYY_MM_CN("yyyy年MM月"),
        YYYY_MM_DD_CN("yyyy年MM月dd日"),
        MM_DD_HH_MM_CN("MM月dd日 HH:mm"),
        MM_DD_HH_MM_SS_CN("MM月dd日 HH:mm:ss"),
        YYYY_MM_DD_HH_MM_CN("yyyy年MM月dd日 HH:mm"),
        YYYY_MM_DD_HH_MM_SS_CN("yyyy年MM月dd日 HH:mm:ss"),

        HH_MM("HH:mm"),
        HH_MM_SS("HH:mm:ss");



        private transient DateTimeFormatter formatter;

        TimeFormat(String pattern) {
            formatter = DateTimeFormatter.ofPattern(pattern);
        }

    }
}
