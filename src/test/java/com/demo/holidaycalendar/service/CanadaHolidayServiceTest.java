package com.demo.holidaycalendar.service;

import com.demo.holidaycalendar.entity.Holiday;
import com.demo.holidaycalendar.repository.HolidayRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

public class CanadaHolidayServiceTest {

    @Mock
    private HolidayRepository holidayRepository;

    @InjectMocks
    private CanadaHolidayService canadaHolidayService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testgetAllHolidays(){
        Holiday holiday = new Holiday("CANADA_DAY","2024-05-05","CANADA");
        List<Holiday> listOfHoliday = new ArrayList<>();
        listOfHoliday.add(holiday);
        when(holidayRepository.findAllByCountry("CANADA")).thenReturn(listOfHoliday);
        List<Holiday> listOfHolidayActual = holidayRepository.findAllByCountry("CANADA");
        Assertions.assertEquals(listOfHoliday,listOfHolidayActual);

    }

    @Test
    public void testAddHoliday(){
        Holiday holiday = new Holiday("CANADA_DAY","2024-05-05","CANADA");
        when(holidayRepository.save(holiday)).thenReturn(holiday);
        Holiday holidayActual = holidayRepository.save(holiday);
        Assertions.assertEquals(holiday,holidayActual);
    }

    @Test
    public void testUpdateHoliday(){
        Holiday holiday = new Holiday("CANADA_DAY","2024-05-05","CANADA");
        when(holidayRepository.save(holiday)).thenReturn(holiday);
        Holiday holidayActual = holidayRepository.save(holiday);
        Assertions.assertEquals(holiday,holidayActual);
    }



}
