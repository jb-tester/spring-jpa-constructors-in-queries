package com.mytests.spring.springJpaConstructorsInQueries.dto;

/**
 * *
 * <p>Created by irina on 5/6/2024.</p>
 * <p>Project: spring-jpa-constructors-in-queries</p>
 * *
 */
public class UsedDTO {

    Double arg1;

    public UsedDTO(Double arg1) {
        this.arg1 = arg1;
    }

    public Double getArg1() {
        return arg1;
    }

    public void setArg1(Double arg1) {
        this.arg1 = arg1;
    }

    @Override
    public String toString() {
        return "UsedDTO(" +
               arg1 +
               ')';
    }
}
