package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import fr.eseo.carlieva.android_app.R;

public class FragmentVoirResultats extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListView listView;
    private View root;
    

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root= inflater.inflate(R.layout.fragment_voir_resultats, container, false);

        db.collection("Vote").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String[] resultsItems = new String[queryDocumentSnapshots.getDocuments().size()];
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                            for (int i = 0; i < list.size(); i++) {
                                resultsItems[i] = list.get(i).get("Nom").toString();
                            }
                            listView=(ListView) root.findViewById(R.id.ListResultats);

                            ArrayAdapter<String> listViewAdapter= new ArrayAdapter<String>(
                                    getActivity(),
                                    android.R.layout.simple_list_item_1,
                                    resultsItems
                            );


                            listView.setAdapter(listViewAdapter);
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                MainActivity main = (MainActivity) getActivity();
                                main.displayScreen2(IdScreen.FRAGMENT_RESULTATS, resultsItems[position]);

                            }
                            });
                        }


                    }





                });
        return root;

    }
}