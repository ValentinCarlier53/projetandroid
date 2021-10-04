package fr.eseo.carlieva.android_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_scrum_master_menu, container, false);
        buttonCreerEquipe = root.findViewById(R.id.buttonCréerEquipe);
        buttonCreerEquipe.setOnClickListener(this);
        return root;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonCréerEquipe:
                MainActivity main = (MainActivity) getActivity();
                main.displayScreen(IdScreen.FRAGMENT_CREATION_EQUIPE);
                break;
            default:
                break;
        }
    }

}