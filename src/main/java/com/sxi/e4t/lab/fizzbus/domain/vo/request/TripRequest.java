package com.sxi.e4t.lab.fizzbus.domain.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record TripRequest(@JsonProperty("timezone") String timezone,
                          @JsonProperty("startOn") LocalDateTime startOn,
                          @JsonProperty("endAt") LocalDateTime endAt,
                          @JsonProperty("distance") double distance,
                          @JsonProperty("status") String status,
                          @JsonProperty("carId") long carId,
                          @JsonProperty("driverId") long driverId,
                          @JsonProperty("customerId") long customerId) {

}
