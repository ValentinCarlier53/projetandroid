package fr.eseo.carlieva.android_app.pojo;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.PropertyName;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {



    @Exclude
    private String id;

    private String text;
    private String mail;
    private Date date;

    public Message(String id, String text, String mail, Date date) {
        this.id=id;
        this.text = text;
        this.mail = mail;
        this.date = date;
    }

    public Message() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @PropertyName("Text")
    public String getText() {
        return text;
    }

    @PropertyName("Text")
    public void setText(String text) {
        this.text = text;
    }

    @PropertyName("Mail")
    public String getMail() {
        return mail;
    }

    @PropertyName("Mail")
    public void setMail(String mail) {
        this.mail = mail;
    }

    @PropertyName("Hour")
    public Date getDate() {
        return date;
    }

    @PropertyName("Hour")
    public void setDate(Date date) {
        this.date = date;
    }





}