package com.example.demo.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private ResponseStatus status;
    private String message;

}
