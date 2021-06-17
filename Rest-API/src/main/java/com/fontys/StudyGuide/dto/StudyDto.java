package com.fontys.StudyGuide.dto;

import java.util.List;

public class StudyDto {
    private int id;
    private String name;
    private List<Integer> academicYearPlan_idList;

    public StudyDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getAcademicYearPlan_idList() {
        return academicYearPlan_idList;
    }

    public void setAcademicYearPlan_idList(List<Integer> academicYearPlan_idList) {
        this.academicYearPlan_idList = academicYearPlan_idList;
    }
}
