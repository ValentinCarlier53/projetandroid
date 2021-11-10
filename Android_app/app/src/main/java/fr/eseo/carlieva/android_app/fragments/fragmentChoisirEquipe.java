package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.carlieva.android_app.R;
import fr.eseo.carlieva.android_app.pojo.Team;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class fragmentChoisirEquipe extends Fragment {
    private View root;
    ListView listTeam;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<Team> teams = new ArrayList<Team>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        db.collection("Team").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (int i=0; i<list.size();i++) {
                                teams.add(new Team(list.get(i).get("Nom").toString(),new ArrayList<String>((List)list.get(i).get("Users")),new ArrayList<String>((List)list.get(i).get("us"))));
                            }
                        }
                    }


                });
        Log.d("TAG","onCreateView CreationEquipe");
        root = inflater.inflate(R.layout.fragment_creation_equipe, container, false);
        String [] menuItems={};
        listTeam=(ListView) root.findViewById(R.id.ListTeam);
        ArrayAdapter<String> listViewAdapter= new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listTeam.setAdapter(listViewAdapter);
        listTeam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity main = (MainActivity) getActivity();
                if (position==0){
                    Toast.makeText(getActivity(),"first team", Toast.LENGTH_SHORT).show();
                    main.displayScreen(IdScreen.FRAGMENT_VOTE);
                }
                else if (position ==1){
                    Toast.makeText(getActivity(),"second team", Toast.LENGTH_SHORT).show();
                    main.displayScreen(IdScreen.FRAGMENT_VOTE);
                }
                else if (position ==2){
                    Toast.makeText(getActivity(),"third team", Toast.LENGTH_SHORT).show();
                }
                else if (position ==3){
                    Toast.makeText(getActivity(),"fourth team", Toast.LENGTH_SHORT).show();
                }
                else if (position ==4){
                    Toast.makeText(getActivity(),"fifth team", Toast.LENGTH_SHORT).show();
                }
                else if (position ==5){
                    Toast.makeText(getActivity(),"sixth team", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return root;
    }

}