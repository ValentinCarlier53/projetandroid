package fr.eseo.carlieva.android_app.bddadd;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import fr.eseo.carlieva.android_app.R;

public class BddMessage extends AppCompatActivity {

    private static final String TAG = "DocSnippets";

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scrum_master_menu);
        Map<String, Object> message = new HashMap<>();
        message.put("Text", "Hello2");
        message.put("Mail", "v.carlier610@laposte.fr");
        message.put("Hour", Timestamp.now());

        db.collection("Message")
                .add(message);

    }
}
