package com.sxi.lab.fizzbus.domain.vo.response;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Customer")
public record CustomerView(long id, String name) {
}
