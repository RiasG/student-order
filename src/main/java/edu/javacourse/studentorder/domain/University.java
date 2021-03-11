package edu.javacourse.studentorder.domain;

public class University {
    private Long universityId;
    private String univesrsityName;


    public University() {
    }

    public University(Long universityId, String univesrsityName) {
        this.universityId = universityId;
        this.univesrsityName = univesrsityName;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public String getUnivesrsityName() {
        return univesrsityName;
    }

    public void setUnivesrsityName(String univesrsityName) {
        this.univesrsityName = univesrsityName;
    }
}
