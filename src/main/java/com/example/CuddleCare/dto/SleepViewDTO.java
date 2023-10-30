package com.example.CuddleCare.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class SleepViewDTO {
    private String date;
    private BigInteger sleepDuration;
}
