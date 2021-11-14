package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import fr.eseo.carlieva.android_app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class FragmentChoixResp extends Fragment implements View.OnClickListener {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FragmentChoixResp() {
    }

    private View root;
    private Button buttonScrumMaster;
    private Button buttonTeamMember;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_choix_resp, container, false);


        buttonScrumMaster = root.findViewById(R.id.buttonScrumMaster);
        buttonScrumMaster.setOnClickListener(this);

        buttonTeamMember = root.findViewById(R.id.buttonTeamMember);
        buttonTeamMember.setOnClickListener(this);

        // Inflate the layout for this fragment
        return root;
    }

    @Override
    public void onClick(View v) {
        MainActivity main = (MainActivity) getActivity();
        switch (v.getId()) {
            case R.id.buttonScrumMaster:

                db.collection("User").document(FirebaseAuth.getInstance().getCurrentUser().getEmail()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot document = task.getResult();
                        String s = document.get("Role").toString();

                        if (s.equals("SM")) {
                            main.displayScreen(IdScreen.FRAGMENT_SCRUM_MASTER_MENU);
                        } else {
                            Toast.makeText(getActivity(), "You have to be ScrumMaster to access this page", Toast.LENGTH_SHORT).show();
                        }

                    }

                });

                break;
            case R.id.buttonTeamMember:
                main.displayScreen(IdScreen.FRAGMENT_TEAM_MEMBER_MENU);
                break;
            default:
                break;
        }
    }

}