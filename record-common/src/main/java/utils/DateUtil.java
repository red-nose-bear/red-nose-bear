package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

public class DateUtil {

    public static final String STANDARD_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间
     */
    public static String getCurrentDate(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate now = LocalDate.now();
        String dayStr = now.format(formatter);
        return dayStr;
    }

    /**
     * 获取当前是周几
     */
    public static int getDayOfWeek() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        return dayOfWeek.getValue();
    }


    /**
     * 获取传入日期和当前日期的间隔天数
     * 传入天数先于当前则返回正值，后于当前则返回负值
     */
    public static long getDaysDiff(Date startDate) {
        Objects.requireNonNull(startDate, "enter date can not be null");

        LocalDateTime start = Instant.ofEpochMilli(startDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime now = LocalDateTime.now();

        return ChronoUnit.DAYS.between(start, now);
    }

    /**
     * 计算传入的两个日期间隔
     */
    public static long getDaysDiff(Date startDate, Date endDate) {
        Objects.requireNonNull(startDate, "startDate can not be null");
        Objects.requireNonNull(endDate, "endDate can not be null");

        LocalDateTime start = Instant.ofEpochMilli(startDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime end = Instant.ofEpochMilli(endDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();

        return ChronoUnit.DAYS.between(start, end);
    }

    /**
     * @param dateStr
     * @return
     */
    public static Date getDateFromStr(String dateStr, String pattern) throws ParseException {
        Objects.requireNonNull(dateStr, "dateStr can not be null");
        Objects.requireNonNull(pattern, "pattern can not be null");

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateStr);
    }

}
