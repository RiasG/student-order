package edu.javacourse.studentorder.domain;

import java.time.LocalDate;

public class Child extends Person{
    private String certificateNumber;
    private LocalDate issueDate;
    private RegisterOffice issueDepartment;


    public Child(String surName, String givenName, String patronymic, LocalDate dateOfBird, Address address, String certificateNumber, LocalDate issueDate, RegisterOffice issueDepartment) {
        super(surName, givenName, patronymic, dateOfBird, address);
        this.certificateNumber = certificateNumber;
        this.issueDate = issueDate;
        this.issueDepartment = issueDepartment;
    }

    public Child(String surName, String givenName, String patronymic, LocalDate dateOfBird) {
        super(surName, givenName, patronymic, dateOfBird);
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public RegisterOffice getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(RegisterOffice issueDepartment) {
        this.issueDepartment = issueDepartment;
    }
}
