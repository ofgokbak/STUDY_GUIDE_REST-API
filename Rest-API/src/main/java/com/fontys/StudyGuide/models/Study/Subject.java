package com.fontys.StudyGuide.models.Study;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;
    private String vakCode;
    private String objectives;
    private String didacticElements;
    private String research;
    private String performanceIndicators;
    private String resources;
    private String classTime;
    private int ec;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subject")
    private List<Subject_competency> competencies = new ArrayList<>();
    @ManyToMany
    private List<Assessment> assessments = new ArrayList<>();

    public Subject(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setVakCode(String vakCode) {
        this.vakCode = vakCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getEc() {
        return ec;
    }

    public void setEc(int ec) {
        this.ec = ec;
    }

    public List<Subject_competency> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(List<Subject_competency> competencies) {
        this.competencies = competencies;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }
}
