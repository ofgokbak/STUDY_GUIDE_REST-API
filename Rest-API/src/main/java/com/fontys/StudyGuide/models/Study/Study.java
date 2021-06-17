package com.fontys.StudyGuide.models.Study;

import javax.persistence.*;
import java.util.List;

@Entity
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "study",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<AcademicYearPlan> academicYearPlans;

    public Study() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AcademicYearPlan> getAcademicYearPlanList() {
        return academicYearPlans;
    }

    public void setAcademicYearPlanList(List<AcademicYearPlan> academicYearPlans) {
        this.academicYearPlans = academicYearPlans;
    }
}
