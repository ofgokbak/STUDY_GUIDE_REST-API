package com.fontys.StudyGuide.models.Study;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class AcademicYearPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private int academicYear;
    @JsonBackReference
    @ManyToOne
    private Study study;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "academicYearPlan")
    private List<Study_variant> variants;
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "academic_year_plan_competency",
//            joinColumns = @JoinColumn(name = "academic_year_plan_id"),
//            inverseJoinColumns = @JoinColumn(name = "competency_id")
//    )
//    private List<Competency> competencies;


    public AcademicYearPlan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }

    public List<Study_variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Study_variant> variants) {
        this.variants = variants;
    }

    //    public List<Competency> getCompetencies() {
//        return competencies;
//    }
}
