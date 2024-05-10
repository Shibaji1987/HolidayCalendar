package com.demo.holidaycalendar.repository;

import com.demo.holidaycalendar.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HolidayRepository extends JpaRepository<Holiday,Long> {
    List<Holiday> findAllByCountry(String country);
}
