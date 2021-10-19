package fr.eseo.carlieva.android_app.service;

import android.util.Log;

import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.eseo.carlieva.android_app.pojo.Message;
import fr.eseo.carlieva.android_app.pojo.User;

public class UserService {

    String s;
    User user1;



    public ArrayList<User> users = new ArrayList<User>();

    public UserService() {
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "DocSnippets";

    public void addUser(User user) {

        Map<String, Object> users = new HashMap<>();
        users.put("Nom", user.getNom());
        users.put("Prenom", user.getPrenom());
        users.put("Mail", user.getMail());

        db.collection("User")
                .add(users);
    }


    public User getUser(String mail) {



        List<DocumentSnapshot> list = new ArrayList<DocumentSnapshot>();


        db.collection("User").whereEqualTo("Mail", "v.calier610@laposte.net")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshots,
                                        @Nullable FirebaseFirestoreException e) {


                        List<DocumentSnapshot> list = snapshots.getDocuments();

                        user1 = new User(list.get(0).get("Mail").toString(), list.get(0).get("Prenom").toString(), list.get(0).get("Nom").toString());

                    }

                });

        return user1;
    }



    public ArrayList<User> getAllUser(){
        db.collection("User").get()

                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                        if (!queryDocumentSnapshots.isEmpty()) {

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();



                            for (int i=0; i<list.size();i++) {

                                users.add(new User(list.get(i).get("Mail").toString(),list.get(i).get("Prenom").toString(),list.get(i).get("Nom").toString()));

                            setUsers(users);


                            }



                        }
                    }


                });

        Log.d(TAG,"hey je suis la2"+getUsers().size());
            return this.getUsers();

    }


    public String getCurrentUser() {
        //final String s = "";
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {

            db.collection("User").get()

                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                            if (!queryDocumentSnapshots.isEmpty()) {

                                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                                for (int i = 0; i < list.size(); i++) {

                                    if (mAuth.getCurrentUser().getEmail().equals(list.get(i).get("Mail").toString())) {
                                        s= String.valueOf(2);
                                        //s[0] =list.get(i).get("Prenom").toString() + list.get(i).get("Nom").toString();
                                    }


                                }


                            }
                        }


                    });

        }
        return s;
    }
}



