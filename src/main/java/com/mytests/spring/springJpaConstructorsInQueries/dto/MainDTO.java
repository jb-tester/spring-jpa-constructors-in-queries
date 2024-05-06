package com.mytests.spring.springJpaConstructorsInQueries.dto;

/**
 * *
 * <p>Created by irina on 5/6/2024.</p>
 * <p>Project: spring-jpa-constructors-in-queries</p>
 * *
 */
public class MainDTO {

    int arg1;
    UsedDTO arg2;

    public MainDTO(int arg1, UsedDTO arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public int getArg1() {
        return arg1;
    }

    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    public UsedDTO getArg2() {
        return arg2;
    }

    public void setArg2(UsedDTO arg2) {
        this.arg2 = arg2;
    }

    @Override
    public String toString() {
        return "MainDTO{" +
               "arg1=" + arg1 +
               ", arg2=" + arg2 +
               '}';
    }
}
