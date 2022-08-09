package com.inside.interview.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {
    private String name;
    private String password;
}