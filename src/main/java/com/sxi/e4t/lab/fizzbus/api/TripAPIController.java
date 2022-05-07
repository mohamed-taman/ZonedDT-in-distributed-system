package com.sxi.e4t.lab.fizzbus.api;

import com.sxi.e4t.lab.fizzbus.domain.vo.request.TripRequest;
import com.sxi.e4t.lab.fizzbus.domain.vo.response.TripResponse;
import com.sxi.e4t.lab.fizzbus.service.TripService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Trip Manager",
        description = "A set of APIs, for exploring and managing Uber Trips.")
@RestController
@RequestMapping("trips")
@Log4j2
public class TripAPIController {

    private final TripService tripService;

    public TripAPIController(TripService tripService) {
        this.tripService = tripService;
    }

    @Operation(summary = "Get all trips.",
            description = """
                    An API call to get all the trips, and the
                    result is formatted according to a specific timezone.""")
    @GetMapping
    public List<TripResponse> allTrips(@Parameter(example = "Europe/Sofia") @RequestParam("tz") String timezone) {
        return tripService.getAll(timezone);
    }

    @Operation(summary = "Search all trips.",
            description = "An API call to search all the trips, between two dates, for a specific timezone.")
    @GetMapping("search")
    public List<TripResponse> search(@Parameter(example = "2022-07-15 01:01:01") @RequestParam("fromDate") String fromDate,
                                     @Parameter(example = "2022-07-20 01:01:01") @RequestParam("toDate") String toDate,
                                     @Parameter(example = "Europe/Sofia") @RequestParam("tz") String timezone) {

        log.info("Searching for trips in date range between [{}] and [{}] and timezone of [{}]",
                fromDate, toDate, timezone);

        return tripService.findBetween(fromDate, toDate, timezone);
    }

    @Operation(summary = "Get a specific trip.",
            description = "An API call to get trip by id, for a specific timezone.")
    @GetMapping("/{id}")
    public TripResponse getTrip(@Parameter(example = "1") @PathVariable String id,
                                @Parameter(example = "Europe/Sofia") @RequestParam("tz") String timezone) {
        return tripService.findById(Long.valueOf(id), timezone);
    }

    @Operation(summary = "Create a trip.",
            description = "An API call to create a trip, with user timezone.")
    @PostMapping
    public void addTrip(@RequestBody @Valid TripRequest trip) {
        tripService.add(trip);
    }

    @Operation(summary = "Create a multiple trips.",
            description = "An API call to create  multiple trip, with user timezone.")
    @PatchMapping
    public void addAllTrip(@RequestBody @Valid List<TripRequest> trips) {
        tripService.addAll(trips);
    }


    @Operation(summary = "Update a trip.",
            description = "An API call to update a trip, with user timezone.")
    @PutMapping("{id}")
    public void updateTrip(@PathVariable String id, @RequestBody @Valid TripRequest trip) {
        tripService.update(Long.valueOf(id), trip);
    }

    @Operation(summary = "Delete a trip.",
            description = "An API call to delete a trip by id.")
    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable String id) {
        tripService.delete(Long.valueOf(id));
    }

}