package cn.tommyyang.calctool.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by TommyYang on 2018/2/7.
 */
public class DateTimeUtils {

    /**
     *
     * @param format str的date格式 例如:yyyy-MM-dd
     * @param dateStr 例如:2018-02-07
     *
     * @return date
     * */
    public static Date strToDate(String format, String dateStr) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(dateStr);
    }

    /**
     *
     * @param format str的date格式 例如:yyyy-MM-dd
     * @param date 时间
     *
     * @return date
     * */
    public static String dateToStr(String format, Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
}
