package fr.eseo.carlieva.android_app.bddadd;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import fr.eseo.carlieva.android_app.R;

public class RemplissageBdd extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scrum_master_menu);


        createTeam("Application web",null,null);
        createTeam("Application Android",null,null);
        createTeam("Projet IA",null,null);
        createTeam("Projet DevOps",null,null);
        createTeam("Projet Base de données",null,null);

        createUs("En tant que dev je dois faire la page d'accueil",null);
        createUs("En tant qu'admin je dois faire la bdd",null);
        createUs("En tant que resp. test je dois tester les fonctionnalités",null);
        createUs("En tant qu'admin je dois faire un backup des données",null);
        createUs("En tant qu'utilisateur je dois pouvoir me connecter",null);




    }

    public void createTeam(String nom,String users[], String us[]){
        Map<String, Object> team = new HashMap<>();
        team.put("Nom", nom);
        team.put("Users", FieldValue.arrayUnion());
        team.put("us", FieldValue.arrayUnion());
        team.put("votePossible",false);
        db.collection("Team").document(nom).set(team);
    }

    public void createUs(String nom,String votes[]){
        Map<String, Object> us = new HashMap<>();
        us.put("Nom", nom);
        us.put("Votes", FieldValue.arrayUnion());
        us.put("Note",0);

        db.collection("UserStory").document(nom).set(us);
    }

    public void createVote(String nom,int note, String votant){
        Map<String, Object> vote = new HashMap<>();
        vote.put("Nom", nom);
        vote.put("Note", note);
        vote.put("Votant", votant);
        db.collection("Vote").document(nom).set(vote);
    }

    public void createUser(String nom,String prenom, String mail, String role, String[] team){
        Map<String, Object> user = new HashMap<>();
        user.put("Nom", nom);
        user.put("Prenom", prenom);
        user.put("Role",role);
        user.put("Equipes", FieldValue.arrayUnion());
        db.collection("User").document(nom).set(user);
    }


}
