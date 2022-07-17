package com.sxi.lab.fizzbus.api.vo.response;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.time.LocalDate;

@JsonRootName("Customer")
public record CustomerView(long id, String name, LocalDate birthdate) {
}
