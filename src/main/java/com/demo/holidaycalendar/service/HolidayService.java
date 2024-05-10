package com.demo.holidaycalendar.service;

import com.demo.holidaycalendar.entity.Holiday;

import java.util.List;

public interface HolidayService {
    List<Holiday> getAllHolidays(String country);
    Holiday addHoliday(Holiday holiday);
    Holiday updateHoliday(Long id,Holiday holiday);
}
