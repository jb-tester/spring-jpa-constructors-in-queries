package com.mytests.spring.springJpaConstructorsInQueries.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "uuid_entity")
public class UuidEntity {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "foo", length = 50)
    private String foo;

    @Column(name = "flag1", nullable = false)
    private Boolean flag1 = false;

    @Column(name = "flag2")
    private Boolean flag2;

    @Column(name = "flag3", length = 1)
    private String flag3;

    @Column(name = "date1")
    private LocalDate date1;

    @Column(name = "date2")
    private Instant date2;

    @Column(name = "time1")
    private LocalTime time1;

    @Column(name = "time2")
    private Instant time2;

    @Column(name = "num1")
    private Integer num1;

    @Column(name = "num2")
    private Double num2;

    @Column(name = "num3")
    private Float num3;

    @Column(name = "char1", length = 1)
    private String char1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public Boolean getFlag1() {
        return flag1;
    }

    public void setFlag1(Boolean flag1) {
        this.flag1 = flag1;
    }

    public Boolean getFlag2() {
        return flag2;
    }

    public void setFlag2(Boolean flag2) {
        this.flag2 = flag2;
    }

    public String getFlag3() {
        return flag3;
    }

    public void setFlag3(String flag3) {
        this.flag3 = flag3;
    }

    public LocalDate getDate1() {
        return date1;
    }

    public void setDate1(LocalDate date1) {
        this.date1 = date1;
    }

    public Instant getDate2() {
        return date2;
    }

    public void setDate2(Instant date2) {
        this.date2 = date2;
    }

    public LocalTime getTime1() {
        return time1;
    }

    public void setTime1(LocalTime time1) {
        this.time1 = time1;
    }

    public Instant getTime2() {
        return time2;
    }

    public void setTime2(Instant time2) {
        this.time2 = time2;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public Float getNum3() {
        return num3;
    }

    public void setNum3(Float num3) {
        this.num3 = num3;
    }

    public String getChar1() {
        return char1;
    }

    public void setChar1(String char1) {
        this.char1 = char1;
    }

}