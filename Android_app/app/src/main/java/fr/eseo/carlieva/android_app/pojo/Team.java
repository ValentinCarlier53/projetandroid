package fr.eseo.carlieva.android_app.pojo;

import com.google.firebase.firestore.Exclude;

import java.util.ArrayList;

public class Team {

    @Exclude
    private String id;

    private String nom;

    private ArrayList<User> users = new ArrayList<User>();

    private ArrayList<UserStory> us = new ArrayList<UserStory>();

    public Team(String id, String nom, ArrayList<User> users, ArrayList<UserStory> us) {
        this.id = id;
        this.nom = nom;
        this.users = users;
        this.us = us;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<UserStory> getUs() {
        return us;
    }

    public void setUs(ArrayList<UserStory> us) {
        this.us = us;
    }

}
