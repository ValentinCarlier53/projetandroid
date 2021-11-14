package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.eseo.carlieva.android_app.R;

public class FragmentScrumMasterMenu extends Fragment implements View.OnClickListener {
    public FragmentScrumMasterMenu() {
    }

    private View root;
    private Button buttonChoisirUneEquipe;
    private Button buttonVoirResultats;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_scrum_master_menu, container, false);
        buttonChoisirUneEquipe= root.findViewById(R.id.buttonVoirResultats);
        buttonChoisirUneEquipe.setOnClickListener(this);
        buttonVoirResultats= root.findViewById(R.id.buttonVoirResultats);
        buttonVoirResultats.setOnClickListener(this);

        return root;
    }
    @Override
    public void onClick(View v) {
        MainActivity main = (MainActivity) getActivity();
        if (v.getId() == R.id.buttonChoisirUneEquipe){
                main.displayScreen(IdScreen.FRAGMENT_CREATION_EQUIPE);
        }
        else if(v.getId() == R.id.buttonVoirResultats){
            main.displayScreen(IdScreen.FRAGMENT_VOIR_RESULTATS);
        }
    }

}