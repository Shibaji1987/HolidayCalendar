package com.demo.holidaycalendar.service;

import com.demo.holidaycalendar.entity.Holiday;
import com.demo.holidaycalendar.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanadaHolidayService implements HolidayService{

    @Autowired
    private HolidayRepository holidayRepository;

    @Override
    public List<Holiday> getAllHolidays(String country) {
        return holidayRepository.findAllByCountry(country);
    }

    @Override
    public Holiday addHoliday(Holiday holiday) {
     return  holidayRepository.save(holiday);
    }

    @Override
    public Holiday updateHoliday(Long id, Holiday holiday) {
        Holiday existingHoliday = holidayRepository.findById(id).orElse(null);
        if(existingHoliday != null){
            existingHoliday.setName(holiday.getName());
            existingHoliday.setDate(holiday.getDate());
            holidayRepository.save(existingHoliday);
        }
        return existingHoliday;
    }
}
