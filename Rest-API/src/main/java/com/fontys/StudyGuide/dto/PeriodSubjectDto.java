package com.fontys.StudyGuide.dto;

import java.util.List;

public class Period_subjectDto {
    private int id;
    private int period_id;
    private int subject_id;
    private String studyName;
    private List<Integer> teacherIdList;
    private List<String> teacherNameList;

    public Period_subjectDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(int period_id) {
        this.period_id = period_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public List<String> getTeacherNameList() {
        return teacherNameList;
    }

    public void setTeacherNameList(List<String> teacherNameList) {
        this.teacherNameList = teacherNameList;
    }

    public List<Integer> getTeacherIdList() {
        return teacherIdList;
    }

    public void setTeacherIdList(List<Integer> teacherIdList) {
        this.teacherIdList = teacherIdList;
    }
}
