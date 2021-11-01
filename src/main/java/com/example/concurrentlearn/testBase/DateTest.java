package com.example.concurrentlearn.testBase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * @Author: wangyu
 * @Date: Created 2020-11-02 11:02
 * @Description: java 8 的日期 使用
 * @Modified By:
 */
public class DateTest {
    public static void main(String[] args) {
        getCurrent();
        getDetailCurrentDate();
        getCurrentTime();
    }

    // 获取当前日期的 yyyy-MM-dd
    public static void getCurrent() {
        LocalDate date = LocalDate.now();
        System.out.println("Today's local date: " + date);

        LocalTime time = LocalTime.now();
        System.out.println("Today's local time: " + time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Today's local dateTime: " + dateTime);

    }

    //获取 当前日期的 详细
    public static void getDetailCurrentDate() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        System.out.printf("Year :%d ,Mouth :%d, day :%d %n", year, month, day);
    }


    public static void getCurrentTime(){
        String  date ="20201102";
        LocalDate parse = LocalDate.parse(date, DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(parse);


    }

}
