package com.fontys.StudyGuide.models.Study;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "period")
public class Period
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "period")
    private List<Period_subject> subjects;
    @JsonBackReference
    @ManyToOne
    private Yearly_plan yearInPlan;

    public Period() {
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

    public List<Period_subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Period_subject> subjects) {
        this.subjects = subjects;
    }

    public Yearly_plan getYearInPlan() {
        return yearInPlan;
    }

    public void setYearInPlan(Yearly_plan yearInPlan) {
        this.yearInPlan = yearInPlan;
    }
}