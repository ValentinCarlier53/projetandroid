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
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.List;
import fr.eseo.carlieva.android_app.R;

public class FragmentTeamMemberMenu extends Fragment {
    public FragmentTeamMemberMenu() {
    }

    FirebaseFirestore db = FirebaseFirestore.getInstance();
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

        db.collection("User").document(FirebaseAuth.getInstance().getCurrentUser().getEmail()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                List<String> group = (List<String>) document.get("Team");
                String [] menuItems = new String[group.size()];
                if (task.isSuccessful()) {


                    for(int i=0;i<group.size();i++){
                        menuItems[i] = group.get(i).toString();
                    }
                        listView=(ListView) root.findViewById(R.id.ListTeam);

                        ArrayAdapter<String> listViewAdapter= new ArrayAdapter<String>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                menuItems
                        );


                        listView.setAdapter(listViewAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                MainActivity main = (MainActivity) getActivity();

                                    Toast.makeText(getActivity(),menuItems[position], Toast.LENGTH_SHORT).show();
                                    main.displayScreen2(IdScreen.FRAGMENT_USER_STORIES, menuItems[position]);

                            }
                        });
                    }


                }





    });
        return root;

}
}