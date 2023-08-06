package com.example.CuddleCare.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserException {
    private boolean error;
    private String result;
}
