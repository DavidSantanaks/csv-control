package com.project.csv_controll.dto;

public class StatisticsAveragePersonDTO {

    private Integer maleCount;
    private Integer femaleCount;
    private Integer maleAgeSum;
    private Integer femaleAgeSum;
    private Integer maleAgeCount;
    private Integer femaleAgeCount;
    private double maleAverageAge;
    private double femaleAverageAge;

    public StatisticsAveragePersonDTO(){}

    public StatisticsAveragePersonDTO(Integer maleCount, Integer femaleCount, Integer maleAgeSum, Integer femaleAgeSum, Integer maleAgeCount, Integer femaleAgeCount, double maleAverageAge, double femaleAverageAge) {
        this.maleCount = maleCount;
        this.femaleCount = femaleCount;
        this.maleAgeSum = maleAgeSum;
        this.femaleAgeSum = femaleAgeSum;
        this.maleAgeCount = maleAgeCount;
        this.femaleAgeCount = femaleAgeCount;
        this.maleAverageAge = maleAverageAge;
        this.femaleAverageAge = femaleAverageAge;
    }

    public Integer getMaleCount() {
        return maleCount;
    }

    public void setMaleCount(Integer maleCount) {
        this.maleCount = maleCount;
    }

    public Integer getFemaleCount() {
        return femaleCount;
    }

    public void setFemaleCount(Integer femaleCount) {
        this.femaleCount = femaleCount;
    }

    public Integer getMaleAgeSum() {
        return maleAgeSum;
    }

    public void setMaleAgeSum(Integer maleAgeSum) {
        this.maleAgeSum = maleAgeSum;
    }

    public Integer getFemaleAgeSum() {
        return femaleAgeSum;
    }

    public void setFemaleAgeSum(Integer femaleAgeSum) {
        this.femaleAgeSum = femaleAgeSum;
    }

    public Integer getMaleAgeCount() {
        return maleAgeCount;
    }

    public void setMaleAgeCount(Integer maleAgeCount) {
        this.maleAgeCount = maleAgeCount;
    }

    public Integer getFemaleAgeCount() {
        return femaleAgeCount;
    }

    public void setFemaleAgeCount(Integer femaleAgeCount) {
        this.femaleAgeCount = femaleAgeCount;
    }

    public double getMaleAverageAge() {
        return maleAverageAge;
    }

    public void setMaleAverageAge(double maleAverageAge) {
        this.maleAverageAge = maleAverageAge;
    }

    public double getFemaleAverageAge() {
        return femaleAverageAge;
    }

    public void setFemaleAverageAge(double femaleAverageAge) {
        this.femaleAverageAge = femaleAverageAge;
    }
}
