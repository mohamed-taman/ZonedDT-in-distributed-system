package com.sxi.e4t.lab.uber.domain.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

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
