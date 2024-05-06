package com.mytests.spring.springJpaConstructorsInQueries.dto;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

/**
 * *
 * <p>Created by irina on 5/6/2024.</p>
 * <p>Project: spring-jpa-constructors-in-queries</p>
 * *
 */
public class ClassProjection {
    String arg1;
    Integer arg2;
    Float arg3;
    LocalDate arg4;
    Duration arg5;
    Double arg6;
    Boolean arg7;

    public ClassProjection(String arg1, Integer arg2, Float arg3, LocalDate arg4, Duration arg5, Double arg6, Boolean arg7) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.arg4 = arg4;
        this.arg5 = arg5;
        this.arg6 = arg6;
        this.arg7 = arg7;
    }

    public Boolean getArg7() {
        return arg7;
    }

    public void setArg7(Boolean arg7) {
        this.arg7 = arg7;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public Integer getArg2() {
        return arg2;
    }

    public void setArg2(Integer arg2) {
        this.arg2 = arg2;
    }

    public Float getArg3() {
        return arg3;
    }

    public void setArg3(Float arg3) {
        this.arg3 = arg3;
    }

    public LocalDate getArg4() {
        return arg4;
    }

    public void setArg4(LocalDate arg4) {
        this.arg4 = arg4;
    }

    public Duration getArg5() {
        return arg5;
    }

    public void setArg5(Duration arg5) {
        this.arg5 = arg5;
    }

    public Double getArg6() {
        return arg6;
    }

    public void setArg6(Double arg6) {
        this.arg6 = arg6;
    }

    @Override
    public String toString() {
        return "ClassProjection{" +
               "arg1='" + arg1 + '\'' +
               ", arg2=" + arg2 +
               ", arg3=" + arg3 +
               ", arg4=" + arg4 +
               ", arg5=" + arg5 +
               ", arg6=" + arg6 +
               ", arg7=" + arg7 +
               '}';
    }
}
