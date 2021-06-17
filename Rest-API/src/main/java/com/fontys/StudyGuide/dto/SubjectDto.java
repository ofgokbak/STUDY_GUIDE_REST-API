package com.fontys.StudyGuide.dto;

import java.util.List;

public class SubjectDto {
    private int id;
    private int ec;
    private String content;
    private String vakCode;
    private String name;
    private String objectives;
    private String didacticElements;
    private String research;
    private String performanceIndicators;
    private String resources;
    private String classTime;
    private List<Integer> subject_competencyIdList;
    private List<Integer> assessmentIdList;

    public SubjectDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEc() {
        return ec;
    }

    public void setEc(int ec) {
        this.ec = ec;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVakCode() {
        return vakCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVakCode(String vakCode) {
        this.vakCode = vakCode;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getDidacticElements() {
        return didacticElements;
    }

    public void setDidacticElements(String didacticElements) {
        this.didacticElements = didacticElements;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getPerformanceIndicators() {
        return performanceIndicators;
    }

    public void setPerformanceIndicators(String performanceIndicators) {
        this.performanceIndicators = performanceIndicators;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public List<Integer> getSubject_competencyIdList() {
        return subject_competencyIdList;
    }

    public void setSubject_competencyIdList(List<Integer> subject_competencyIdList) {
        this.subject_competencyIdList = subject_competencyIdList;
    }

    public List<Integer> getAssessmentIdList() {
        return assessmentIdList;
    }

    public void setAssessmentIdList(List<Integer> assessmentIdList) {
        this.assessmentIdList = assessmentIdList;
    }
}
