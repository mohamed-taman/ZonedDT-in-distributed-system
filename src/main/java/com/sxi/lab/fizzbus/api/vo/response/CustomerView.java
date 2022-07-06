package com.sxi.lab.fizzbus.api.vo.response;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Customer")
public record CustomerView(long id, String name) {
}
