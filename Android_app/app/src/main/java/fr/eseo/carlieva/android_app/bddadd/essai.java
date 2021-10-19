package fr.eseo.carlieva.android_app.bddadd;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;


import fr.eseo.carlieva.android_app.R;
import fr.eseo.carlieva.android_app.pojo.User;
import fr.eseo.carlieva.android_app.service.UserService;

public class essai extends AppCompatActivity {
    private static final String TAG = "DocSnippets";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scrum_master_menu);
        Log.d(TAG,"taille"+new UserService().getAllUser().size());

    }
}