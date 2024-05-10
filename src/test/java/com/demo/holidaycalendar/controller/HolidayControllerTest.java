package com.demo.holidaycalendar.controller;

import com.demo.holidaycalendar.entity.Holiday;
import com.demo.holidaycalendar.service.CanadaHolidayService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(HolidayController.class)
public class HolidayControllerTest {

    @MockBean
    private CanadaHolidayService canadaHolidayService;

    @Autowired
    MockMvc mockMvc;

    @Test
   public void testSaveHolidays() throws Exception {

        Holiday holiday = new Holiday("CANADA_DAY","2024-05-05","CANADA");
        when(canadaHolidayService.addHoliday(holiday)).thenReturn(holiday);
        mockMvc.perform(post("/holidays/saveHolidays").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(holiday))).andExpect(status().isOk());
    }


    @Test
    public void testgetHolidays() throws Exception {

        Holiday holiday = new Holiday("CANADA_DAY","2024-05-05","CANADA");
        List<Holiday> lst = new ArrayList<>();
        lst.add(holiday);
        when(canadaHolidayService.getAllHolidays("CANADA")).thenReturn(lst);
        mockMvc.perform(get("/holidays/holidaysByCountry/CANADA").
                contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void testUpdateHolidays() throws Exception {

        Holiday holidayForUpdate = new Holiday("CANADA_DAY","2024-05-05","CANADA");

        when(canadaHolidayService.updateHoliday(1L,holidayForUpdate)).thenReturn(holidayForUpdate);
        mockMvc.perform(put("/holidays/1").
                contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(holidayForUpdate)))
                .andExpect(status().isOk());
    }


}
