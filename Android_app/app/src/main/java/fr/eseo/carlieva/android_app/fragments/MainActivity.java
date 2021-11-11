package fr.eseo.carlieva.android_app.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import fr.eseo.carlieva.android_app.R;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    static MainActivity instance;
    /**
     * Used to return the instance of MainActivity
     *
     * @return instance
     */
    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        navController = Navigation.findNavController(this, R.id.fragment_nav_host);

        preferences = getApplicationContext().getSharedPreferences(getString(R.string.ParamètreVisio), 0);
        editor = preferences.edit();
    }

    public void displayScreen(IdScreen idScreen) {
        switch (idScreen) {
            case FRAGMENT_SCRUM_MASTER_MENU:
                Log.d("TAG",navController.getCurrentDestination().toString());

                navController.navigate(R.id.action_fragmentChoixResp_to_ScrumMasterMenu);
                Log.d("TAG",navController.getCurrentDestination().toString());

                break;
            case FRAGMENT_TEAM_MEMBER_MENU:
                navController.navigate(R.id.action_fragmentChoixResp_to_TeamMemberMenu);
                break;
            case FRAGMENT_CREATION_EQUIPE:
                Log.d("TAG",navController.getCurrentDestination().toString());
                navController.navigate(R.id.action_ScrumMasterMenu_to_fragment_creation_equipe);
                Log.d("TAG",navController.getCurrentDestination().toString());
                Log.d("TAG","entree dans le display ")  ;
                break;
            case FRAGMENT_CHOISIR_EQUIPE:
                navController.navigate(R.id.action_ScrumMasterMenu_to_fragment_choisir_equipe);
                break;
            case FRAGMENT_USER_STORIES:
                navController.navigate(R.id.action_fragmentTeamMemberMenu_to_userStories);
                break;
            case FRAGMENT_AJOUTER_EQUIPE:
                navController.navigate(R.id.action_fragmentCreationEquipe_to_fragmentAjouterEquipe);
                break;
            case FRAGMENT_AJOUTER_MEMBRE:
                navController.navigate(R.id.action_fragmentCreationEquipe_to_fragmentAjouterEquipe);
                break;

            case FRAGMENT_LANCER_VOTE:
                navController.navigate(R.id.action_fragmentCreationEquipe_to_fragmentLancerVote);
                break;
            case FRAGMENT_VOTE:
                navController.navigate(R.id.action_userStories_to_voteStories2);
                break;
            default:
                break;
        }
    }

    public void displayScreen2(IdScreen idScreen,  String parameterValue) {
        switch (idScreen) {
            case FRAGMENT_USER_STORIES:
                Bundle bundle = new Bundle();
                bundle.putString("arg",parameterValue);
                navController.navigate(R.id.action_fragmentTeamMemberMenu_to_userStories,bundle);


        }

    }


}