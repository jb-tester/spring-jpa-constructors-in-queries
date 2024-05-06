package com.mytests.spring.springJpaConstructorsInQueries.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public class LombokProjection {
    String arg1;

    @Override
    public String toString() {
        return "LombokProjection{" +
               "arg1='" + arg1 + '\'' +
               '}';
    }
}
