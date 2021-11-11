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

import fr.eseo.carlieva.android_app.R;
public class FragmentUserStories extends Fragment implements View.OnClickListener{
    public FragmentUserStories() {
    }
    private ListView listUserStory;
    private Button buttonAjouterMembre;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_user_stories, container, false);

        String [] userStoryItems = {"us 1", "us 2","us 3"};
        listUserStory=(ListView) root.findViewById(R.id.ListUserStory);

        buttonAjouterMembre = root.findViewById(R.id.buttonCréerEquipe);
        buttonAjouterMembre.setOnClickListener((View.OnClickListener) this);
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
        return root;
    }

    @Override
    public void onClick(View root) {
        MainActivity main = (MainActivity) getActivity();
        switch (root.getId()) {
            case R.id.buttonAjouterMembre:
                main.displayScreen(IdScreen.FRAGMENT_AJOUTER_MEMBRE);
                break;
            default:
                break;
        }
    }
}