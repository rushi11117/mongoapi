package com.example.GameSchedule.Models;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Document(collection = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private Date DOB;
    private String password;
    private ObjectId introId;
    private Date FirstModified;
    @LastModifiedDate
    private Date LastModified;




    public User(Long id, String name, String email, Date DOB, String password, ObjectId introId, Date FirstModified, Date LastModified) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.DOB = DOB;
        this.password = password;
        this.introId = introId;
        this.LastModified = LastModified;
        this.LastModified = LastModified;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ObjectId getIntroId() {
        return introId;
    }

    public void setIntroId(ObjectId introId) {
        this.introId = introId;
    }

    public Date getLastModified() {
        return LastModified;
    }

    public void setLastModified() {
        this.LastModified = new Date();
    }

    public Date getFirstModified() {
        return FirstModified;
    }

    public void setFirstModified() {
        this.FirstModified = new Date();
    }
}
