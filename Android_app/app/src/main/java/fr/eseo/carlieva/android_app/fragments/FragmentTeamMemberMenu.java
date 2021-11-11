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
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import fr.eseo.carlieva.android_app.R;
import fr.eseo.carlieva.android_app.pojo.Message;

public class FragmentTeamMemberMenu extends Fragment {
    public FragmentTeamMemberMenu() {
    }

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "DocSnippets";
    ListView listView;
    static String[] suffixes =
            {    "1st",  "2nd",  "3rd",  "4th",  "5th",  "6th",  "7th",  "8th",  "9th",
                    "10th", "11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th",
                    "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th",
                    "30th", "31st" };

    private View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_team_member_menu, container, false);


        db.collection("Team").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {

                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String [] menuItems = new String[ queryDocumentSnapshots.getDocuments().size()] ;
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                            for (int i=0; i<list.size();i++) {
                                menuItems[i]= list.get(i).get("Nom").toString();


                            }
                        }
                        listView=(ListView) root.findViewById(R.id.ListTeam);

                        ArrayAdapter<String> listViewAdapter= new ArrayAdapter<String>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                menuItems
                        );


                        listView.setAdapter(listViewAdapter);
                        Log.d(TAG,menuItems[0]);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Log.d(TAG,"passage2");
                                MainActivity main = (MainActivity) getActivity();

                                    Toast.makeText(getActivity(),suffixes [position] +" team", Toast.LENGTH_SHORT).show();
                                    main.displayScreen(IdScreen.FRAGMENT_USER_STORIES);

                            }
                        });
                    }


                });



        return root;
    }

}