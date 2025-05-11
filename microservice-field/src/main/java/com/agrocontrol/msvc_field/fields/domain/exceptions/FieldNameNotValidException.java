package com.agrocontrol.msvc_field.fields.domain.exceptions;

public class FieldNameNotValidException extends RuntimeException {
    public FieldNameNotValidException(String name) {
        super("Field Name %s is not valid".formatted(name));
    }
}
