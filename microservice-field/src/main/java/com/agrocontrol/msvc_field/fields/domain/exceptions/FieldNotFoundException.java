package com.agrocontrol.msvc_field.fields.domain.exceptions;

public class FieldNotFoundException extends RuntimeException {
    public FieldNotFoundException(Long fieldId) {
        super("Field with ID %s not found".formatted(fieldId));
    }
}
