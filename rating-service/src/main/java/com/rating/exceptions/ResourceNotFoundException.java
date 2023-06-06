package com.rating.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String id) {
        super("Resource Not Found with given id " + id);
    }
}
