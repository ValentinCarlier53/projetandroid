package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import fr.eseo.carlieva.android_app.R;
public class UserStories extends Fragment implements View.OnClickListener {
    public UserStories() {
    }
    private Button buttonUs1;
    private Button buttonUs2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_user_stories, container, false);
        buttonUs1 = root.findViewById(R.id.buttonUs1);
        buttonUs1.setOnClickListener(this);
        buttonUs2 = root.findViewById(R.id.buttonUs2);
        buttonUs2.setOnClickListener(this);
        return root;
    }

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
}