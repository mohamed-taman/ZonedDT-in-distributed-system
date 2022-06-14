package com.sxi.lab.fizzbus.domain.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public record TripResponse(long id,
                           @JsonProperty("record_timezone") String timezone,
                           String startOn,
                           String endAt,
                           String recordAge,
                           double distance,
                           String status,
                           CarView car,
                           DriverView driver,
                           CustomerView customer) {
}
