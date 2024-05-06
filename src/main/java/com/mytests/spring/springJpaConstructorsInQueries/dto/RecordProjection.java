package com.mytests.spring.springJpaConstructorsInQueries.dto;


public record RecordProjection(int arg1, String arg2) {
    @Override
    public String toString() {
        return "RecordProjection{" +
               "arg1=" + arg1 +
               ", arg2='" + arg2 + '\'' +
               '}';
    }
}
