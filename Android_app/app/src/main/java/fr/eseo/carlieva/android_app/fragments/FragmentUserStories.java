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
public class FragmentUserStories extends Fragment{
    public FragmentUserStories() {
    }
    private ListView listUserStory;
    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_user_stories, container, false);

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
        listUserStory=(ListView) root.findViewById(R.id.ListUserStory);


        ArrayAdapter<String> listViewAdapter= new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                userStoryItems
        );

        listUserStory.setAdapter(listViewAdapter);
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
                    }
                });
        return root;
    }


}