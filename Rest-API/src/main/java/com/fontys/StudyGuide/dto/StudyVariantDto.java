package com.fontys.StudyGuide.dto;

import java.util.List;

public class Study_variantDto {
    private int id;
    private String variant;
    private List<Integer> yearly_plan_idList;
    private int academicYearPlanId;
    private List<String> competencies;

    public Study_variantDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcademicYearPlanId() {
        return academicYearPlanId;
    }

    public void setAcademicYearPlanId(int academicYearPlanId) {
        this.academicYearPlanId = academicYearPlanId;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public List<String> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(List<String> competencies) {
        this.competencies = competencies;
    }

    public List<Integer> getYearly_plan_idList() {
        return yearly_plan_idList;
    }

    public void setYearly_plan_idList(List<Integer> yearly_plan_idList) {
        this.yearly_plan_idList = yearly_plan_idList;
    }
}
