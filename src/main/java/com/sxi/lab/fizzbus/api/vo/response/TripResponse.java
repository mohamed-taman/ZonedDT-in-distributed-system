package com.sxi.lab.fizzbus.api.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxi.lab.fizzbus.infra.common.Status;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public record TripResponse(long id,
                           @JsonProperty("record_timezone") String timezone,
                           @JsonProperty("start_on") String startOn,
                           @JsonProperty("end_at") String endAt,
                           @JsonProperty("record_age") String recordAge,
                           double distance,
                           Status status,
                           CarView car,
                           DriverView driver,
                           CustomerView customer) {
}
