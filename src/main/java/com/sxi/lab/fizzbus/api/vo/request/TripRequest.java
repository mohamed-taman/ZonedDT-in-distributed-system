package com.sxi.lab.fizzbus.api.vo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxi.lab.fizzbus.infra.common.Status;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TripRequest(@NotBlank String timezone,
                          @JsonProperty("start_on") @NotNull @FutureOrPresent LocalDateTime startOn,
                          @JsonProperty("end_at") @NotNull @Future LocalDateTime endAt,
                          @Positive double distance,
                          Status status,
                          @JsonProperty("car_id") @NotNull @Positive long carId,
                          @JsonProperty("driver_id") @NotNull @Positive long driverId,
                          @JsonProperty("customer_id") @NotNull @Positive long customerId) {

}
