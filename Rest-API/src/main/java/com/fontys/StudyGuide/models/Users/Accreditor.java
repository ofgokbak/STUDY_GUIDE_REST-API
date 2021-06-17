package com.fontys.StudyGuide.models.Users;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "accreditor")
public class Accreditor extends User
{
    public Accreditor(int id,int pcn, String firstName, String lastName, String email, String password) {
        super(id,pcn, firstName, lastName, email, password);
    }
    public Accreditor(){

    }
}
