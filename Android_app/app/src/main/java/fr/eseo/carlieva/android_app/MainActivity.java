package fr.eseo.carlieva.android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    private ProgressDialog progress;
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
        progress = new ProgressDialog(MainActivity.this);


        preferences = getApplicationContext().getSharedPreferences(getString(R.string.ParamètreVisio), 0);
        editor = preferences.edit();
    }

    public void displayScreen(IdScreen idScreen) {
        switch (idScreen) {
            case FRAGMENT_SCRUM_MASTER_MENU:
                //actionBar.setDisplayHomeAsUpEnabled(true);
                navController.navigate(R.id.action_fragmentChoixResp_to_ScrumMasterMenu);
                break;
            default:
                break;
        }
    }

}