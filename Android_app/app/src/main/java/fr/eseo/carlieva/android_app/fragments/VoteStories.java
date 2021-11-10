package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import fr.eseo.carlieva.android_app.R;

public class VoteStories extends Fragment implements View.OnClickListener {
    public VoteStories() {
    }
    private View root;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button5;
    private Button button8;
    private Button button13;
    private Button button20;
    private Button button40;
    private Button button100;
    private Button buttonInterrogation;
    private Button buttonCoffee;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_vote_user_story, container, false);

        button1= root.findViewById(R.id.button1);
        //button1.setOnClickListener(this);
        button13 = root.findViewById(R.id.buttonTeamMember);
        //button13.setOnClickListener(this);

        // Inflate the layout for this fragment
        return root;
    }

    @Override
    public void onClick(View v) {
        //MainActivity main = (MainActivity) getActivity();
        switch (v.getId()) {
            case R.id.button1:
                Toast.makeText(getActivity(),"first team", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button13:
                Toast.makeText(getActivity(),"first team", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
