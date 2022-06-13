package com.sxi.e4t.lab.fizzbus.domain.vo.response;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Car")
public record CarView(long id, String model,
                      String color, String chassisNumber,
                      String branch, String company) {
}
