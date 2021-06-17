package com.fontys.StudyGuide.dto;

import java.util.List;

public class Yearly_planDto {
    private int id;
    private int yearNumber;
    private int study_variant_id;
    private List<Integer> period_idList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public int getStudy_variant_id() {
        return study_variant_id;
    }

    public void setStudy_variant_id(int study_variant_id) {
        this.study_variant_id = study_variant_id;
    }

    public List<Integer> getPeriod_idList() {
        return period_idList;
    }

    public void setPeriod_idList(List<Integer> period_idList) {
        this.period_idList = period_idList;
    }
}
