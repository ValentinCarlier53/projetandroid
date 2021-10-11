package fr.eseo.carlieva.android_app.bddadd;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import fr.eseo.carlieva.android_app.R;

public class BddCreateTeam extends AppCompatActivity {
    private static final String TAG = "DocSnippets";

    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scrum_master_menu);
        Map<String, Object> team = new HashMap<>();
        team.put("Nom", "LD");
        team.put("Users", FieldValue.arrayUnion("salut"));
        db.collection("Team")
                .add(team);

    }
}
