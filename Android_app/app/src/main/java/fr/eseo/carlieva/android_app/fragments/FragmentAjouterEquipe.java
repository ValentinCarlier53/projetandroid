package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import fr.eseo.carlieva.android_app.R;

public class FragmentAjouterEquipe extends Fragment implements View.OnClickListener{
    public FragmentAjouterEquipe() {
        // Required empty public constructor
    }

    private Button buttonCreerEquipe;
    private EditText equipe;
    private View root;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_ajouter_equipe, container, false);
        buttonCreerEquipe = root.findViewById(R.id.CreerEquipe);
        buttonCreerEquipe.setOnClickListener((View.OnClickListener) this);
        return root;
    }
    @Override
    public void onClick(View v) {
        MainActivity main = (MainActivity) getActivity();
        equipe=root.findViewById(R.id.Equipe);
        switch (v.getId()) {
            case R.id.CreerMembre:
                Map<String, Object> team = new HashMap<>();

                team.put("Nom", equipe.getText().toString());
                team.put("Users", FieldValue.arrayUnion());
                team.put("us", FieldValue.arrayUnion());

                db.collection("Team").document(equipe.getText().toString()).set(team);
                Toast.makeText(getActivity()," Nouvelle équipe créée : ", Toast.LENGTH_SHORT).show();
            case R.id.CreerEquipe:

                Map<String, Object> team1 = new HashMap<>();

                team1.put("Nom", equipe.getText().toString());
                team1.put("Users", FieldValue.arrayUnion());
                team1.put("us", FieldValue.arrayUnion());

                db.collection("Team").document(equipe.getText().toString()).set(team1);
                Toast.makeText(getActivity()," Nouvelle équipe créée : ", Toast.LENGTH_SHORT).show();

                break;
            default:
                break;
        }
    }
}