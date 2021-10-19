package fr.eseo.carlieva.android_app.bddadd;


import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.eseo.carlieva.android_app.R;

public class BddAddUserTeam extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "DocSnippets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scrum_master_menu);

        CollectionReference teams = db.collection("Team");

        db.collection("Team") .whereEqualTo("Nom","LD")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshots,
                                        @Nullable FirebaseFirestoreException e) {
                        Log.d(TAG, "je suis passé là");
                        Map<String, Object> team = new HashMap<>();
                        team.put("Users", FieldValue.arrayUnion("rééssai"));

                        List<DocumentSnapshot> list = snapshots.getDocuments();
                        for(int i=0; i<list.size();i++){
                            list.get(0).getReference().update(team);
                        }

                    }
                });

    }
}
