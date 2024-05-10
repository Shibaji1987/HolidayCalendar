package com.demo.holidaycalendar.repository;

import com.demo.holidaycalendar.entity.Holiday;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

public class HolidayRepositoryTest {

    @Mock
    private HolidayRepository holidayRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllByCountry(){

        Holiday holiday = new Holiday("CANADA_DAY","2024-05-05","CANADA");
        List<Holiday> listOfHoliday = new ArrayList<>();
        listOfHoliday.add(holiday);
        when(holidayRepository.findAllByCountry("CANADA")).thenReturn(listOfHoliday);
        List<Holiday> listOfHolidayActual = holidayRepository.findAllByCountry("CANADA");
        Assertions.assertEquals(listOfHoliday,listOfHolidayActual);

    }

}
