package com.sxi.e4t.lab.uber.repository;

import com.sxi.e4t.lab.uber.domain.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findAllByStartOnIsBetween(ZonedDateTime firstDate, ZonedDateTime secondDate);
}