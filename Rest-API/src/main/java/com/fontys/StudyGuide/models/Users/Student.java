package com.fontys.StudyGuide.models.Users;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends User
{
    public Student(int id,int pcn, String firstName, String lastName, String email, String password) {
        super(id,pcn, firstName, lastName, email, password);
    }
    public Student(){

    }

}
