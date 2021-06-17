package com.fontys.StudyGuide.models.Study;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Study_variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Variant variant;
    @JsonBackReference
    @ManyToOne
    private AcademicYearPlan academicYearPlan;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "variant")
    private List<Yearly_plan> yearly_plans;
    @ManyToMany
    private List<Competency> competencies;

    public Study_variant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AcademicYearPlan getAcademicYearPlan() {
        return academicYearPlan;
    }

    public void setAcademicYearPlan(AcademicYearPlan academicYearPlan) {
        this.academicYearPlan = academicYearPlan;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public List<Yearly_plan> getYearly_plans() {
        return yearly_plans;
    }

    public void setYearly_plans(List<Yearly_plan> yearly_plans) {
        this.yearly_plans = yearly_plans;
    }

    public List<Competency> getCompetencies() {
        List<Competency> competencyList = new ArrayList<>();
        yearly_plans.forEach(yearly_plan -> {
            if (yearly_plan.getPeriods() != null) {
                yearly_plan.getPeriods().forEach(period -> {
                    if (period.getSubjects() != null) {
                        period.getSubjects().forEach(period_subject -> {
                            if (period_subject.getSubject().getCompetencies() != null) {
                                period_subject.getSubject().getCompetencies().forEach(subject_competency -> {
                                    if (!competencyList.contains(subject_competency.getCompetency())) {
                                        competencyList.add(subject_competency.getCompetency());
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
        return competencyList;
    }

    public void setCompetencies(List<Competency> competencies) {
        this.competencies = competencies;
    }
}

