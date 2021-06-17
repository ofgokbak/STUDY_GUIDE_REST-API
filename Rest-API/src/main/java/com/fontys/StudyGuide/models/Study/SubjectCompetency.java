package com.fontys.StudyGuide.models.Study;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "subject_competency")
public class Subject_competency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int level;

    @JsonBackReference
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Competency competency;

    public Subject_competency() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Competency getCompetency() {
        return competency;
    }

    public void setCompetency(Competency competency) {
        this.competency = competency;
    }
}
