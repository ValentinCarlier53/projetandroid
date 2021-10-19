package fr.eseo.carlieva.android_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeamMemberMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamMemberMenu extends Fragment implements View.OnClickListener {
    public TeamMemberMenu() {
    }

    private View root;
    private Button joindreEquipe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_team_member_menu, container, false);
        joindreEquipe = root.findViewById(R.id.joindreEquipe);
        joindreEquipe.setOnClickListener(this);
        return root;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.joindreEquipe:
               /* MainActivity main = (MainActivity) getActivity();
                main.displayScreen(IdScreen.FRAGMENT_CREATION_EQUIPE);*/
                break;
            default:
                break;
        }
    }
}