package fr.eseo.carlieva.android_app.pojo;

import com.google.firebase.firestore.Exclude;

public class User {

    @Exclude
    private String id;

    private String mail;

    private String prenom;

    private String nom;

    private boolean responsible;

    public User(){}
    
    public User(String mail, String prenom, String nom) {
        this.mail = mail;
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isResponsible() {
        return responsible;
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    public String toString(){
        return getMail()+getPrenom()+getNom();
    }

}
