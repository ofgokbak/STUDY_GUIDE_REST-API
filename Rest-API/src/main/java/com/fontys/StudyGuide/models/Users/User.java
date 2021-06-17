package com.fontys.StudyGuide.models.Users;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "`user`")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pcn;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int isAdmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPcn(){
        return pcn;
    }
    public void setPcn(int pcn) {this.pcn = pcn;}

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setPassword(String pass){
        password = pass;
    }
    public String getPassword(){
        return this.password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    // constructor


    public User(int id, int pcn, String firstName, String lastName, String email, String password, int isAdmin) {
        this.id = id;
        this.pcn = pcn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(int id, int pcn, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.pcn = pcn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "pcn=" + pcn +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
