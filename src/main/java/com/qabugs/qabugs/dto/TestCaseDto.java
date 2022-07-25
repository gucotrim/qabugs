package com.qabugs.qabugs.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TestCaseDto {

    private String description;
    private boolean tested;
    private boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
