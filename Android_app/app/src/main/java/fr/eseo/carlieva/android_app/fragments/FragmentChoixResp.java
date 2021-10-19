package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.eseo.carlieva.android_app.activity.MainActivity;
import fr.eseo.carlieva.android_app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class FragmentChoixResp extends Fragment implements View.OnClickListener {
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
                main.displayScreen(IdScreen.FRAGMENT_SCRUM_MASTER_MENU);
                break;
            case R.id.buttonTeamMember:
                main.displayScreen(IdScreen.FRAGMENT_TEAM_MEMBER_MENU);
                break;
            default:
                break;
        }
    }

}