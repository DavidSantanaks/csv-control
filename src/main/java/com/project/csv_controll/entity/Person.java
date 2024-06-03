package com.project.csv_controll.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.csv_controll.constant.PersonConstant;
import jakarta.persistence.*;

@Entity
@Table(name = PersonConstant.TABLE)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = PersonConstant.ID)
    @JsonProperty(PersonConstant.ID)
    private Integer personId;

    @Column(name = PersonConstant.FIRST_NAME)
    @JsonProperty(PersonConstant.FIRST_NAME)
    private String firstName;

    @Column(name = PersonConstant.SURNAME)
    @JsonProperty(PersonConstant.SURNAME)
    private String surname;

    @Column(name = PersonConstant.EMAIL)
    @JsonProperty(PersonConstant.EMAIL)
    private String email;

    @Column(name = PersonConstant.GENDER)
    @JsonProperty(PersonConstant.GENDER)
    private String gender;

    @Column(name = PersonConstant.ACCESS_IP)
    @JsonProperty(PersonConstant.ACCESS_IP)
    private String accessIp;

    @Column(name = PersonConstant.AGE)
    @JsonProperty(PersonConstant.AGE)
    private Integer age;

    @Column(name = PersonConstant.BIRTH_DATE)
    @JsonProperty(PersonConstant.BIRTH_DATE)
    private String birthDate;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
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
