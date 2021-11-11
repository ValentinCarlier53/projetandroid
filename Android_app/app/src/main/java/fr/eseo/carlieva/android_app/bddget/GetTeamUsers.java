package fr.eseo.carlieva.android_app.bddget;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import fr.eseo.carlieva.android_app.R;

public class GetTeamUsers  extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "DocSnippets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_data_message);

        db.collection("Team").document("jj").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    List<String> group = (List<String>) document.get("Users");
                    for(int i=0;i<group.size();i++){
                        Log.d(TAG, String.valueOf(group.get(i).toString()));
                    }


                }
            }
        });
    }
}
