package com.project.csv_controll.handler;

import com.project.csv_controll.dto.PersonDTO;

import java.util.List;

public class PersonCsvHandlerProcessor {

    private static void countGendersAndCalculateAverageAge(List<PersonDTO> people) {
        int maleCount = 0;
        int femaleCount = 0;
        int maleAgeSum = 0;
        int femaleAgeSum = 0;
        int maleAgeCount = 0;
        int femaleAgeCount = 0;

        for (PersonDTO personDTO : people) {
            if (personDTO.getGender().equalsIgnoreCase("male")) {
                maleCount++;
                maleAgeSum += personDTO.getAge();
                maleAgeCount++;
            } else if (personDTO.getGender().equalsIgnoreCase("female")) {
                femaleCount++;
                femaleAgeSum += personDTO.getAge();
                femaleAgeCount++;
            }
        }

        double maleAverageAge = maleAgeCount > 0 ? (double) maleAgeSum / maleAgeCount : 0;
        double femaleAverageAge = femaleAgeCount > 0 ? (double) femaleAgeSum / femaleAgeCount : 0;

        System.out.println("Número de homens: " + maleCount);
        System.out.println("Número de mulheres: " + femaleCount);
        System.out.println("Média de idade dos homens: " + maleAverageAge);
        System.out.println("Média de idade das mulheres: " + femaleAverageAge);
    }
}
