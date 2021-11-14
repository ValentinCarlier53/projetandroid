package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import fr.eseo.carlieva.android_app.R;

public class FragmentVoteStories extends Fragment implements View.OnClickListener {
    public FragmentVoteStories() {
    }
    private View root;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Button button0;
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
        button0= root.findViewById(R.id.button0);
        button0.setOnClickListener(this);
        button1= root.findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2= root.findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3= root.findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button5= root.findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button8= root.findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button13 = root.findViewById(R.id.button13);
        button13.setOnClickListener(this);
        button20= root.findViewById(R.id.button20);
        button20.setOnClickListener(this);
        button40= root.findViewById(R.id.button40);
        button40.setOnClickListener(this);
        button100= root.findViewById(R.id.button100);
        button100.setOnClickListener(this);
        buttonInterrogation= root.findViewById(R.id.buttonInterrogation);
        buttonInterrogation.setOnClickListener(this);
        buttonCoffee= root.findViewById(R.id.buttonCoffee);
        buttonCoffee.setOnClickListener(this);

        // Inflate the layout for this fragment
        return root;
    }

    public String getArgumentTeam(){
        Bundle b = getArguments();
        if(b==null){
            return "Application Android";
        }
        else{
            return b.getString("team");
        }
    }

    public String getArgumentUs(){
        Bundle b = getArguments();
        if(b==null){
            return "En tant qu'admin je dois faire la bdd";
        }
        else{
            return b.getString("us");
        }
    }

    public void addVote( int note){
        Map<String, Object> vote = new HashMap<>();
        vote.put("Nom",getArgumentTeam()+"-"+getArgumentUs());
        vote.put("User", FieldValue.arrayUnion(FirebaseAuth.getInstance().getCurrentUser().getEmail()));
        vote.put("Note", FieldValue.arrayUnion(note));
        db.collection("Vote").document(getArgumentTeam()+"-"+getArgumentUs()).set(vote);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "Your vote has been taken into account", Toast.LENGTH_SHORT).show();
        switch (v.getId()) {
            case R.id.button0:
                addVote(0);
                break;
            case R.id.button1:
                addVote(1);
                break;
            case R.id.button2:
                addVote(2);
                break;
            case R.id.button3:
                addVote(3);
                break;
            case R.id.button5:
                addVote(5);
                break;
            case R.id.button8:
                addVote(8);
                break;
            case R.id.button13:
                addVote(13);
                break;
            case R.id.button20:
                addVote(20);
                break;
            case R.id.button40:
                addVote(40);
                break;
            case R.id.button100:
                addVote(100);
                break;
            case R.id.buttonInterrogation:
                break;
            case R.id.buttonCoffee:
                break;
            default:
                break;

        }
    }
}
