package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.eseo.carlieva.android_app.R;


public class FragmentAjouterMembre extends Fragment {
    public FragmentAjouterMembre() {
        // Required empty public constructor
    }
    private ListView listMembers;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


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

        View root = inflater.inflate(R.layout.fragment_ajouter_membre, container, false);

        db.collection("User").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {

                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String[] membersItems = new String[queryDocumentSnapshots.getDocuments().size()];
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        if (!queryDocumentSnapshots.isEmpty()) {

                            for (int i = 0; i < list.size(); i++) {
                                membersItems[i] = "Ajouter"+ list.get(i).get("Prenom").toString()+ list.get(i).get("Nom").toString();
                            }

                            listMembers=(ListView) root.findViewById(R.id.ListMembers);


                            ArrayAdapter<String> listViewAdapter= new ArrayAdapter<String>(
                                    getActivity(),
                                    android.R.layout.simple_list_item_1,
                                    membersItems
                            );

                            listMembers.setAdapter(listViewAdapter);
                            listMembers.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    MainActivity main = (MainActivity) getActivity();
                                    Map<String, Object> user = new HashMap<>();
                                    user.put("Team", FieldValue.arrayUnion(getArgument()));
                                    list.get(position).getReference().update(user);
                                    //pareil côté équipe
                                    Map<String, Object> team = new HashMap<>();
                                    team.put("Users", FieldValue.arrayUnion(FirebaseAuth.getInstance().getCurrentUser().getEmail()));
                                    db.collection("Team").document(getArgument()).update(team);
                                    Toast.makeText(getActivity(),"User added", Toast.LENGTH_SHORT).show();





                                }
                            });
                        }
                    }
                });
        return root;
    }
}