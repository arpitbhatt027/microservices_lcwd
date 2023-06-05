package com.rating.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String id) {
        super("Recource Not Found with given id " + id);
    }
}
