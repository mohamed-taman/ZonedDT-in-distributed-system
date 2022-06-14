package com.sxi.lab.fizzbus.domain.vo.response;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Driver")
public record DriverView(long id, String name, String licenseNumber) {
}
