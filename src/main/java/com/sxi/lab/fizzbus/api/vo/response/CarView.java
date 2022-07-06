package com.sxi.lab.fizzbus.api.vo.response;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Car")
public record CarView(long id, String model,
                      String color, String chassisNumber,
                      String branch, String company) {
}
