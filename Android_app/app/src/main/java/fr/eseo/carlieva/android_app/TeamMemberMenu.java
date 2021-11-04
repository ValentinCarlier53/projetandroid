package fr.eseo.carlieva.android_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeamMemberMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamMemberMenu extends Fragment {
    ListView listView;
    public TeamMemberMenu() {
    }

    private View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_team_member_menu, container, false);
        String [] menuItems={"Équipe 1",
                "Équipe 2",
                "Équipe 3",
                "Équipe 4",
                "Équipe 5",
                "Équipe 6"
        };
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
                if (position==0){
                    Toast.makeText(getActivity(),"first team", Toast.LENGTH_SHORT).show();
                    main.displayScreen(IdScreen.FRAGMENT_USER_STORIES);
                }
                else if (position ==1){
                    Toast.makeText(getActivity(),"second team", Toast.LENGTH_SHORT).show();
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