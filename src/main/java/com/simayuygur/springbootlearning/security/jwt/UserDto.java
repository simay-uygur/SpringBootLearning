package com.simayuygur.springbootlearning.security.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    //login/register
    private String username;
    private String password;
}
