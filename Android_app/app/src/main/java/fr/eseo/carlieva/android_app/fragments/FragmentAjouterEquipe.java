package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.eseo.carlieva.android_app.R;

public class FragmentAjouterEquipe extends Fragment implements View.OnClickListener{
    public FragmentAjouterEquipe() {
        // Required empty public constructor
    }
    private Button buttonCreerEquipe;
    private EditText equipe;
    private View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_ajouter_equipe, container, false);
        buttonCreerEquipe = root.findViewById(R.id.CreerMembre);
        buttonCreerEquipe.setOnClickListener((View.OnClickListener) this);
        return root;
    }
    @Override
    public void onClick(View v) {
        MainActivity main = (MainActivity) getActivity();
        equipe=root.findViewById(R.id.Membre);
        switch (v.getId()) {
            case R.id.CreerMembre:
                String equipeCreee=equipe.getText().toString();
                Toast.makeText(getActivity()," Nouvelle équipe créée : "+equipeCreee, Toast.LENGTH_SHORT).show();

                break;
            default:
                break;
        }
    }
}