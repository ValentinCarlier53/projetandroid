package fr.eseo.carlieva.android_app.bddadd;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import fr.eseo.carlieva.android_app.R;

public class CurrentUser extends AppCompatActivity {

    private static final String TAG = "DocSnippets";
    private FirebaseAuth mAuth= FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_data_message);

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {

            db.collection("User").get()

                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                            if (!queryDocumentSnapshots.isEmpty()) {

                                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                                for (int i=0; i<list.size();i++) {

                                    if(mAuth.getCurrentUser().getEmail().equals(list.get(i).get("Mail").toString())){
                                        Log.d(TAG, list.get(i).get("Prenom").toString()+list.get(i).get("Nom").toString());
                                    }

                                }
                            /*ArrayAdapter<Message> arrayAdapter
                                    = new ArrayAdapter<Message>(this, messageList);*/



                            }
                        }


                    });
        }

    }
}
