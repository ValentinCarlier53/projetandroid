package fr.eseo.carlieva.android_app.pojo;

import com.google.firebase.firestore.Exclude;

import java.util.ArrayList;

public class Team {

    @Exclude
    private String id;

    private String nom;

    private ArrayList<String> users = new ArrayList<String>();

    private ArrayList<String> us = new ArrayList<String>();

    public Team( String nom, ArrayList<String> users, ArrayList<String> us) {
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

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public ArrayList<String> getUs() {
        return us;
    }

    public void setUs(ArrayList<String> us) {
        this.us = us;
    }

}
