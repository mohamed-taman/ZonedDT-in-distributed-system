package com.sxi.lab.fizzbus.api.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Driver")
public record DriverView(long id, String name, @JsonProperty("license_number") String licenseNumber) {
}
