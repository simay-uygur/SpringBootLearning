package com.simayuygur.springbootlearning.security.jwt;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

public class JwtResponse implements Serializable {

    @Serial  //ide offered
    private static final long serialVersionUID = -809187909192404844L;

    @Getter
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

}
