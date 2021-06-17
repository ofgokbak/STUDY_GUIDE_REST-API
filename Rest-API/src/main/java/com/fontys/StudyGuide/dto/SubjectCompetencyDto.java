package com.fontys.StudyGuide.dto;

public class Subject_competencyDto {
    private int id;
    private int level;
    private int subject_id;
    private int competency_id;

    public Subject_competencyDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getCompetency_id() {
        return competency_id;
    }

    public void setCompetency_id(int competency_id) {
        this.competency_id = competency_id;
    }
}
