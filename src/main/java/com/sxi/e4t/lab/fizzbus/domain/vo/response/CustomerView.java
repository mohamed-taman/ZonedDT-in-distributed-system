package com.sxi.e4t.lab.fizzbus.domain.vo.response;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Customer")
public record CustomerView(long id, String name) {
}
