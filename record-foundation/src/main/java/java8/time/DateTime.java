package java8.time;

import domain.BigDog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTime extends BigDog{
    public static void main(String[] args) {
        remainTime();
    }

    public static void strToTime() {
        String timeStr = "2019-10-01 00:00:00";
        LocalDateTime time = LocalDateTime.parse(timeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(time);
    }

    public static void timeToStr() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeStr = "2019-10-01 00:00:00";
        LocalDateTime time = LocalDateTime.parse(timeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String format = time.format(dateTimeFormatter);
        System.out.println(format);
    }

    /**
     * 两个日期的间距
     */
    public static void getDaysDiff() {
        LocalDateTime start = LocalDateTime.of(2019, 8, 6, 14, 11, 20);
        LocalDateTime end = LocalDateTime.of(2019, 8, 7, 14, 11, 19);
        long daysDiff = ChronoUnit.DAYS.between(start, end);
        System.out.println(daysDiff);
    }

    /**
     * 当天剩余时间
     */
    public static void remainTime() {
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        System.out.println(midnight);
        long millSeconds = ChronoUnit.MILLIS.between(LocalDateTime.now(),midnight);
        System.out.println(millSeconds);
    }
}
