package fr.eseo.carlieva.android_app.bddadd;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import fr.eseo.carlieva.android_app.R;

public class BddCreateUserStory extends AppCompatActivity {
    private static final String TAG = "DocSnippets";

    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scrum_master_menu);
        Map<String, Object> us = new HashMap<>();

        us.put("Nom", "En tant que lead");
        us.put("Votes", FieldValue.arrayUnion());
        us.put("Note", 0);

        db.collection("UserStory").document("En tant que lead").set(us);



    }

}
