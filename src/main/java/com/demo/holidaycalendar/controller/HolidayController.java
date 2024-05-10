package com.demo.holidaycalendar.controller;

import com.demo.holidaycalendar.entity.Holiday;
import com.demo.holidaycalendar.service.HolidayService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;


    @Operation(tags="Add Holiday Calendar",description = "Add Holiday Calendar")
    @PostMapping("/saveHolidays")
    public ResponseEntity<Holiday> addHoliday(@RequestBody Holiday holiday){
          holidayService.addHoliday(holiday);
          return ResponseEntity.ok(holiday);
    }


    @Operation(tags="Fetch Holiday Calendar",description = "Fetch All Holiday Calendar for a Country")
    @GetMapping("/holidaysByCountry/{country}")
    public ResponseEntity<List<Holiday>> getAllHolidays(@PathVariable String country){
        List<Holiday> listOfHolidays = holidayService.getAllHolidays(country);
        if(!listOfHolidays.isEmpty()){
        return ResponseEntity.ok(listOfHolidays);}
        else{
            throw new RuntimeException("Error");
        }
    }


    @Operation(tags="Update Holiday Calendar",description = "Update a specific Holiday Calendar by Id")
    @PutMapping("/{id}")
    public ResponseEntity<Holiday> updateHoliday(@PathVariable Long id, @RequestBody Holiday holiday)
    {
        Holiday holidayUpdated =  holidayService.updateHoliday(id,holiday);
        return ResponseEntity.ok(holidayUpdated);
    }

}
