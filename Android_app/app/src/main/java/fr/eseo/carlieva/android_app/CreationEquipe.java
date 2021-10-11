package fr.eseo.carlieva.android_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CreationEquipe extends Fragment implements View.OnClickListener{
    private View root;
    private Button buttonCreerEquipe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("TAG","onCreateView CreationEquipe");
        root = inflater.inflate(R.layout.fragment_creation_equipe, container, false);
        buttonCreerEquipe = root.findViewById(R.id.buttonCréerEquipe1);
        buttonCreerEquipe.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        MainActivity main = (MainActivity) getActivity();
        switch (v.getId()) {
            case R.id.buttonCréerEquipe1:
                main.displayScreen(IdScreen.FRAGMENT_CREATION_EQUIPE);
                Log.d("TAG","SECONDE ENTREE");
                break;
            default:
                break;
        }
    }
}