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
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.List;
import fr.eseo.carlieva.android_app.R;

public class FragmentLancerVote extends Fragment implements View.OnClickListener {

    public FragmentLancerVote() {
        // Required empty public constructor
    }
    private Button buttonAjouterMembre;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ListView listUserStoryVote;
    private View root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_lancer_vote, container, false);
        buttonAjouterMembre = root.findViewById(R.id.buttonAjouterMembre);
        buttonAjouterMembre.setOnClickListener((View.OnClickListener) this);



        db.collection("UserStory").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {

                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String[] userStoryItems = new String[queryDocumentSnapshots.getDocuments().size()];
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (int i = 0; i < list.size(); i++) {
                                userStoryItems[i] = "lancer vote "+ list.get(i).get("Nom").toString();
                            }
                        }
                        listUserStoryVote=(ListView) root.findViewById(R.id.ListUserStoryVote);

                        ArrayAdapter<String> listViewAdapter= new ArrayAdapter<String>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                userStoryItems
                        );
                        listUserStoryVote.setAdapter(listViewAdapter);
                        // Log.d(TAG,menuItems[0]);
                        listUserStoryVote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                MainActivity main = (MainActivity) getActivity();
                                if (position == 0) {
                                    Toast.makeText(getActivity(), "lancement vote us1", Toast.LENGTH_SHORT).show();
                                    //to do mettre le bouleen du lancement su vote à true ;
                                } else if (position == 1) {
                                    Toast.makeText(getActivity(), "lancement vote us2", Toast.LENGTH_SHORT).show();
                                    //to do mettre le bouleen du lancement su vote à true ;
                                }

                            }
                        });
                    }
                });
        return root;
    }
    @Override
    public void onClick(View root) {
        MainActivity main = (MainActivity) getActivity();
        switch (root.getId()) {
            case R.id.buttonAjouterMembre:
                main.displayScreen(IdScreen.FRAGMENT_AJOUTER_MEMBRE);
                Log.d("TAG","SECONDE ENTREE");
                break;
            default:
                break;
        }
    }
}
