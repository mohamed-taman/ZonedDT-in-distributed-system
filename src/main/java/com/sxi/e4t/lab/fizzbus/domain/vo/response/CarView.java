package com.sxi.e4t.lab.fizzbus.domain.vo.response;

public record CarView(long id, String model,
                      String color, String chassisNumber,
                      String branch, String company) {
}
