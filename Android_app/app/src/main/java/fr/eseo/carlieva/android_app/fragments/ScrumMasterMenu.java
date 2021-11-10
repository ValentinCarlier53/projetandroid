package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.eseo.carlieva.android_app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScrumMasterMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScrumMasterMenu extends Fragment implements View.OnClickListener {
    public ScrumMasterMenu() {
    }

    private View root;
    private Button buttonCreerEquipe;
    private Button buttonChoisirUneEquipe;
    String noms[]=new String[]{"Valentin","Jean-Baptiste","Lave"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_scrum_master_menu, container, false);
        //ListView listView=(ListView) findViewById(R.id.ListView);
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.Layout.simple,noms);
        //listView.setAdapter(adapter);
        //listView.setOnClickListener(new AdapterView.onItemClickListener());
        buttonCreerEquipe = root.findViewById(R.id.buttonCréerEquipe);
        buttonCreerEquipe.setOnClickListener(this);
        buttonChoisirUneEquipe= root.findViewById(R.id.buttonChoisirUneEquipe);
        buttonChoisirUneEquipe.setOnClickListener(this);
        return root;
    }
    @Override
    public void onClick(View v) {
        MainActivity main = (MainActivity) getActivity();
        switch (v.getId()) {
            case R.id.buttonCréerEquipe:
                main.displayScreen(IdScreen.FRAGMENT_CHOISIR_EQUIPE);
                Log.d("TAG","SECONDE ENTREE");
                break;
            case R.id.buttonChoisirUneEquipe:
                main.displayScreen(IdScreen.FRAGMENT_CREATION_EQUIPE);
                break;
            default:
                break;
        }
    }

}