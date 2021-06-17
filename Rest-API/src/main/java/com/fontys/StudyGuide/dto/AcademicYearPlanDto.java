package com.fontys.StudyGuide.dto;

import java.util.List;

public class AcademicYearPlanDto {
    private int id;
    private String study;
    private int year;
    private List<Integer> study_variant_idList;
//    private List<Integer> competency_idList;

    public AcademicYearPlanDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Integer> getStudy_variant_idList() {
        return study_variant_idList;
    }

    public void setStudy_variant_idList(List<Integer> study_variant_idList) {
        this.study_variant_idList = study_variant_idList;
    }
    //    public List<Integer> getCompetency_idList() {
//        return competency_idList;
//    }

}
