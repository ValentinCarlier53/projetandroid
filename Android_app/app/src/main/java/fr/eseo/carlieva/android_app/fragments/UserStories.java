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
public class UserStories extends Fragment {
    public UserStories() {
    }
    ListView listUserStory;
    private View root;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_user_stories, container, false);

        String [] userStoryItems = {"us 1", "us 2","us 3"};
        listUserStory=(ListView) root.findViewById(R.id.ListUserStory);

        ArrayAdapter<String> listViewAdapter= new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                userStoryItems
        );

        listUserStory.setAdapter(listViewAdapter);
        // Log.d(TAG,menuItems[0]);
        //listUserStory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        return root;
    }
/*
    @Override
    public void onClick(View v) {
        MainActivity main = (MainActivity) getActivity();
        switch (v.getId()) {
            case R.id.buttonUs1:
                Toast.makeText(getActivity(), "first team", Toast.LENGTH_SHORT).show();
                main.displayScreen(IdScreen.FRAGMENT_VOTE);
                break;
            case R.id.buttonTeamMember:
                Toast.makeText(getActivity(), "second team", Toast.LENGTH_SHORT).show();
                //main.displayScreen(IdScreen.FRAGMENT_TEAM_MEMBER_MENU);
                break;
            default:
                break;
        }

    }
*/
}