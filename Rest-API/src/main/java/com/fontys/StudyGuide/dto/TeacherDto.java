package com.fontys.StudyGuide.dto;

import java.util.List;

public class TeacherDto {
    private int pcn;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
//    private String authorization;
    private int isAdmin;
    private List<Integer> period_subjectIdList;

    public TeacherDto() {
    }

    public int getPcn() {
        return pcn;
    }

    public void setPcn(int pcn) {
        this.pcn = pcn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getAuthorization() {
//        return authorization;
//    }
//
//    public void setAuthorization(String authorization) {
//        this.authorization = authorization;
//    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Integer> getPeriod_subjectIdList() {
        return period_subjectIdList;
    }

    public void setPeriod_subjectIdList(List<Integer> period_subjectIdList) {
        this.period_subjectIdList = period_subjectIdList;
    }
}
