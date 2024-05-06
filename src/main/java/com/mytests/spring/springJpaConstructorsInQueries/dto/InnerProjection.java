package com.mytests.spring.springJpaConstructorsInQueries.dto;

/**
 * *
 * <p>Created by irina on 5/6/2024.</p>
 * <p>Project: spring-jpa-constructors-in-queries</p>
 * *
 */
public class InnerProjection {

    public class InnerDTO{
        String arg1;

        public InnerDTO(String arg1) {
            this.arg1 = arg1;
        }

        public String getArg1() {
            return arg1;
        }

        public void setArg1(String arg1) {
            this.arg1 = arg1;
        }

        @Override
        public String toString() {
            return "InnerDTO{" +
                   "arg1='" + arg1 + '\'' +
                   '}';
        }
    }
}
