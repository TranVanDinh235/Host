package com.example.host.utils;

import com.aminography.primecalendar.PrimeCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateTimeUtils {

    public static Long getCurrentTimeSecond(){
        return System.currentTimeMillis()/1000;
    }

    public static String timeReview(String time){
        long timeL = Long.parseLong(time);
        long now = getCurrentTimeSecond();
        long timeDiff = now - timeL;
        if (timeDiff < 0) return "";
        if (timeDiff > 86400 * 7) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(timeL*1000);
            return "Cập nhật lần cuối " + calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR);
        }
        if (timeDiff > 86400) {
            return "Cập nhật lần cuối " + timeDiff/86400 + " ngày trước";
        }
        if (timeDiff > 3600) {
            return "Cập nhật lần cuối " + timeDiff/3600 + " giờ trước";
        }
        return "Cập nhật lần cuối " + timeDiff/60 + " phút trước";
    }

    public static List<Long> calendarToHouseDate(List<Calendar> calendars){
        List<Long> houseDates = new ArrayList<>();
        for(int i = 0; i < calendars.size(); i ++){
            long sec = calendars.get(i).get(Calendar.MILLISECOND);
            houseDates.add(sec);
        }
        return houseDates;
    }

    public static String dayOfWeekString(int day){
        if(day == 1) return "CN";
        else return "Th" + day;
    }

    public static String calendarToString(Calendar calendar){
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        return dayOfWeekString(calendar.get(Calendar.DAY_OF_WEEK)) + " " + String.format("%02d", day) + "/" + String.format("%02d", month);
    }

    public static String houseDateToString(int houseDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis((long) houseDate * 1000);
        return calendarToString(calendar);
    }

    public static List<Long> primeCalendarToHouseDate(List<PrimeCalendar> calendars){
        List<Long> houseDates = new ArrayList<>();
        for(int i = 0; i < calendars.size(); i ++){
            long sec = calendars.get(i).getTime().getTime()/1000;
            houseDates.add(sec);
        }
        return houseDates;
    }
}

