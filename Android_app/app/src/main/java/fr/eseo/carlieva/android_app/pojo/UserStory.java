package fr.eseo.carlieva.android_app.pojo;

import com.google.firebase.firestore.Exclude;

import java.util.ArrayList;

public class UserStory {

    @Exclude
    private String id;

    private String intitule;

    private int value;

    private ArrayList<Vote> votes = new ArrayList<Vote>();

    public UserStory(String intitule, int value, ArrayList<Vote> votes) {
        this.intitule = intitule;
        this.value = value;
        this.votes = votes;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Vote> getVotes() {
        return votes;
    }

    public void setVotes(ArrayList<Vote> votes) {
        this.votes = votes;
    }

}
