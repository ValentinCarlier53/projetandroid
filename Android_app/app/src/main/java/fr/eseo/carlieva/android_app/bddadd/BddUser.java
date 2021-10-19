package fr.eseo.carlieva.android_app.bddadd;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import fr.eseo.carlieva.android_app.R;

public class BddUser extends AppCompatActivity {

    private static final String TAG = "DocSnippets";

    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scrum_master_menu);
        Map<String, Object> user = new HashMap<>();
        user.put("Nom", "Carlier");
        user.put("Prenom", "Valentin");
        user.put("Mail","v.carlier610@laposte.net");

        db.collection("User")
                .add(user);


    }

}
