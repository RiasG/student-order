package edu.javacourse.studentorder.domain;

import java.time.LocalDate;

public abstract class Person {
    private String surName;
    private String givenName;
    private String patronymic;
    private LocalDate dateOfBird;
    private Address address;

    public Person(String surName, String givenName, String patronymic, LocalDate dateOfBird, Address address) {
        this.surName = surName;
        this.givenName = givenName;
        this.patronymic = patronymic;
        this.dateOfBird = dateOfBird;
        this.address = address;
    }

    public Person(String surName, String givenName, String patronymic, LocalDate dateOfBird) {
        this.surName = surName;
        this.givenName = givenName;
        this.patronymic = patronymic;
        this.dateOfBird = dateOfBird;
    }

    public Person() {
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBird() {
        return dateOfBird;
    }

    public void setDateOfBird(LocalDate dateOfBird) {
        this.dateOfBird = dateOfBird;
    }

    public Address getAddres() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
