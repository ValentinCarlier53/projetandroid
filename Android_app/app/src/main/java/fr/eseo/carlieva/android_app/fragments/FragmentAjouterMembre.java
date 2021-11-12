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

import fr.eseo.carlieva.android_app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAjouterMembre#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAjouterMembre extends Fragment implements View.OnClickListener{
    public FragmentAjouterMembre() {
        // Required empty public constructor
    }
    private Button buttonCreerMembre;
    private EditText membre;
    private View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_ajouter_membre, container, false);
        buttonCreerMembre = root.findViewById(R.id.CreerMembre);
        buttonCreerMembre.setOnClickListener((View.OnClickListener) this);
        return root;
    }

    @Override
    public void onClick(View v) {
        MainActivity main = (MainActivity) getActivity();
        membre = root.findViewById(R.id.Membre);
        switch (v.getId()) {
            case R.id.CreerMembre:
                Log.d("Tag","membre");
                String membreCree = membre.getText().toString();
                Toast.makeText(getActivity(), " Nouveau Membre créé : " + membreCree, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}