package fr.eseo.carlieva.android_app.pojo;

import com.google.firebase.firestore.Exclude;

import java.util.ArrayList;

public class Vote {

    @Exclude
    private String id;

    private int value;

    private User user;

    private String message;

    public Vote(int value, User user) {
        this.value = value;
        this.user = user;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
