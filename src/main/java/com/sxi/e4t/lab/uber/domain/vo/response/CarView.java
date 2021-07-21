package com.sxi.e4t.lab.uber.domain.vo.response;

public record CarView(long id, String model,
                      String color, String chassisNumber,
                      String branch, String company) {
}
