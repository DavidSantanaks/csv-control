package com.project.csv_controll.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.csv_controll.constant.PersonConstant;

public class PersonDTO {

    @JsonProperty(PersonConstant.FIRST_NAME)
    private String firstName;

    @JsonProperty(PersonConstant.SURNAME)
    private String surname;

    @JsonProperty(PersonConstant.EMAIL)
    private String email;

    @JsonProperty(PersonConstant.GENDER)
    private String gender;

    @JsonProperty(PersonConstant.ACCESS_IP)
    private String accessIp;

    @JsonProperty(PersonConstant.AGE)
    private Integer age;

    @JsonProperty(PersonConstant.BIRTH_DATE)
    private String birthDate;

    public PersonDTO(){}

    public PersonDTO(String firstName, String surname, String email, String gender, String accessIp, Integer age, String birthDate) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
        this.accessIp = accessIp;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccessIp() {
        return accessIp;
    }

    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
