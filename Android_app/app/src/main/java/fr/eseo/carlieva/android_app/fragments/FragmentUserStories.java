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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import fr.eseo.carlieva.android_app.R;






public class FragmentUserStories extends Fragment implements View.OnClickListener{
    public FragmentUserStories() {
    }
    private ListView listUserStory;
    private Button buttonAjouterMembre;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "DocSnippets";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String team =  getArguments().getString("arg");
        Log.d(TAG,"le nom de l'équipe"+team);

        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_user_stories, container, false);

        db.collection("Team").document(team).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                List<String> group = (List<String>) document.get("us");
                String [] userStoryItems = new String[group.size()];
                if (task.isSuccessful()) {


                    for (int i = 0; i < group.size(); i++) {
                        userStoryItems[i] = group.get(i).toString();
                    }
                }
                ArrayAdapter<String> listViewAdapter= new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1,
                        userStoryItems
                );

                listUserStory.setAdapter(listViewAdapter);


              }
        });

        buttonAjouterMembre = root.findViewById(R.id.buttonCréerEquipe);
        buttonAjouterMembre.setOnClickListener((View.OnClickListener) this);



        listUserStory=(ListView) root.findViewById(R.id.ListUserStory);


        // Log.d(TAG,menuItems[0]);
        listUserStory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity main = (MainActivity) getActivity();
                if (position == 0) {
                    Toast.makeText(getActivity(), "us1", Toast.LENGTH_SHORT).show();
                    main.displayScreen(IdScreen.FRAGMENT_VOTE);
                } else if (position == 1) {
                    Toast.makeText(getActivity(), "us2", Toast.LENGTH_SHORT).show();
                    main.displayScreen(IdScreen.FRAGMENT_VOTE);
                }
            }
        });




        return root;
    }


}
