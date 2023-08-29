package com.example.GameSchedule.Models;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.GameSchedule.util.DateTimeUtil;
import com.example.GameSchedule.util.Hash;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Document(collection = "users")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    private String name;
    private String email;
    private String password;
    private String DOB;
    private LocalTime LastModified;



    public User(String name, String email, String password, String DOB, LocalTime LastModified) throws ParseException  {

        this.name = name;
        this.email = email;
        this.DOB = DOB;
        this.password = password;
        this.LastModified = setLastModified();
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

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
    	this.password = password;
    }

    public LocalTime getLastModified() {
        return LastModified;
    }

    public LocalTime setLastModified() {
    	return LocalTime.now();
    }
    
    public Date getParsedBirthDate(String strDOB) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(strDOB);
    }

}
