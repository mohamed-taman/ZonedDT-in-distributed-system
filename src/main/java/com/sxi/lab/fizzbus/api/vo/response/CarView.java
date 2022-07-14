package com.sxi.lab.fizzbus.api.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Car")
public record CarView(long id, String model,
                      String color, @JsonProperty("chassis_number") String chassisNumber,
                      String branch, String company) {
}
