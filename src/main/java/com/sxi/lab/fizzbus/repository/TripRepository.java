package com.sxi.lab.fizzbus.repository;

import com.sxi.lab.fizzbus.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findAllByStartOnIsBetween(ZonedDateTime firstDate, ZonedDateTime secondDate);
}