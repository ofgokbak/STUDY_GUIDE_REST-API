package com.fontys.StudyGuide.models.Study;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fontys.StudyGuide.models.Users.Teacher;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Period_subject {
    @Id
    private int id;
    @JsonBackReference
    @ManyToOne
    private Period period;
    @ManyToOne
    private Subject subject;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "period_subject_teacher",
            joinColumns = @JoinColumn(name = "period_subject_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_pcn")
    )
    private List<Teacher> teachers;

    public Period_subject() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
