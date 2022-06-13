package com.sxi.e4t.lab.fizzbus.domain.vo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TripRequest(@NotBlank String timezone,
                          @NotNull @FutureOrPresent LocalDateTime startOn,
                          @NotNull @Future LocalDateTime endAt,
                          @Positive double distance,
                          @NotBlank String status,
                          @NotNull @Positive long carId,
                          @NotNull @Positive long driverId,
                          @NotNull @Positive long customerId) {

}
