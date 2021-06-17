package com.fontys.StudyGuide.dto;

import java.util.List;

public class PeriodDto {
    private int id;
    private List<Integer> period_subjectIdList;
    private String name;
    private int yearly_planId;

    public PeriodDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getPeriod_subjectIdList() {
        return period_subjectIdList;
    }

    public void setPeriod_subjectIdList(List<Integer> period_subjectIdList) {
        this.period_subjectIdList = period_subjectIdList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearly_planId() {
        return yearly_planId;
    }

    public void setYearly_planId(int yearly_planId) {
        this.yearly_planId = yearly_planId;
    }
}
