package com.fontys.StudyGuide.models.Users;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fontys.StudyGuide.models.Study.Period_subject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "teacher")
public class Teacher extends User {

    public Teacher(int id,int pcn, String firstName, String lastName, String email, String password,int isAdmin) {
        super(id, pcn, firstName, lastName, email, password, isAdmin);
    }

    @JsonBackReference
    @ManyToMany(mappedBy = "teachers")
    private List<Period_subject> subjects= new ArrayList<>();

    public Teacher() {
    }

    public List<Period_subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Period_subject> subjects) {
        this.subjects = subjects;
    }
}
