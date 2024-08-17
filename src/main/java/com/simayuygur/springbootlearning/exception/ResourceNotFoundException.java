package com.simayuygur.springbootlearning.exception;

import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException implements Serializable {

    private static final Long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);

    }
}
