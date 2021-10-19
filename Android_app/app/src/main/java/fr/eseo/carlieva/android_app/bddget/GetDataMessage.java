package fr.eseo.carlieva.android_app.bddget;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.carlieva.android_app.R;
import fr.eseo.carlieva.android_app.pojo.Message;

public class GetDataMessage extends AppCompatActivity {


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "DocSnippets";
    private List<Message> messageList = new ArrayList<Message>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_data_message);

        db.collection("Message").get()

                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        Log.d(TAG,String.valueOf("salut"));
                        Log.d(TAG,String.valueOf("essai"+queryDocumentSnapshots.size()) );

                        if (!queryDocumentSnapshots.isEmpty()) {

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();



                            for (int i=0; i<list.size();i++) {

                                messageList.add(new Message(list.get(i).getId(),list.get(i).get("Text").toString(),list.get(i).get("Mail").toString(), ((Timestamp) list.get(0).get("Hour")).toDate()));

                            }
                            /*ArrayAdapter<Message> arrayAdapter
                                    = new ArrayAdapter<Message>(this, messageList);*/
                            Log.d(TAG, messageList.get(0).getText());


                        }
                    }


                });


    }
}
