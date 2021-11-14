package fr.eseo.carlieva.android_app.fragments;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.eseo.carlieva.android_app.R;

public class FragmentResultats extends Fragment {

    public FragmentResultats() {
        // Required empty public constructor
    }

    private Button buttonAjouterMembre;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ListView listUserStoryVote;
    private View root;
    private static final String TAG = "DocSnippets";

    public String getArgument(){
        Bundle b = getArguments();
        if(b==null){
            return "Application Android";
        }
        else{
            return b.getString("arg");
        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_resultats, container, false);



        db.collection("Vote").document(getArgument()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                List<String> group1 = (List<String>) document.get("Note");
                List<String> group2= (List<String>) document.get("User");
                String [] resultsItems = new String[group1.size()];
                if (task.isSuccessful()) {


                    for(int i=0;i<group1.size();i++){
                        resultsItems[i] = String.valueOf(group1.get(i)).toString()+group2.get(i).toString();
                    }

                    listUserStoryVote=(ListView) root.findViewById(R.id.ListResultatsDef);

                    ArrayAdapter<String> listViewAdapter= new ArrayAdapter<String>(
                            getActivity(),
                            android.R.layout.simple_list_item_1,
                            resultsItems
                    );
                    listUserStoryVote.setAdapter(listViewAdapter);

                }
            }
        });
        return root;
    }


}

