package com.sxi.lab.fizzbus.infra.exception;

import static java.lang.String.format;
import static java.lang.String.valueOf;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Class<?> clazz, long id) {
        this(clazz, valueOf(id));
    }

    public NotFoundException(Class<?> clazz, String id) {
        super(getFormattedMessage(clazz.getSimpleName(), id));
    }

    private static String getFormattedMessage(String entity, String id) {
        return format("%s with id %s not found", entity, id);
    }
}
