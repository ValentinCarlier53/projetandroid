

package fr.eseo.carlieva.android_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.carlieva.android_app.R;


public class FragmentChoisirEquipe extends Fragment  {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "DocSnippets";
    // Add RecyclerView member
    private RecyclerView recyclerView;
    private List<ListName> listName;
    private Adapter<ListName> adapter;
    //private AdapterView.onItemClickListener myListClickListener=new AdapterView<>();

    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choisir_equipe, container, false);
        listName=new ArrayList<>();
        //Log.d(TAG,"taille"+new UserService().getAllUser());
        //
        /*

        ArrayList<User> users = new UserService().getAllUser();
        Log.d(TAG,"je me suis perdu"+users.size());
        for (int i=0;i<users.size();i++){

            listName.add(new ListName(users.get(i).getPrenom(),users.get(i).getNom()));
        }
        */

        db.collection("User").get()

                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                        if (!queryDocumentSnapshots.isEmpty()) {

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();



                            for (int i=0; i<list.size();i++) {

                                listName.add(new ListName(list.get(i).get("Prenom").toString(),list.get(i).get("Nom").toString()));
                                recyclerView = view.findViewById(R.id.recyclerview);
                                recyclerView.setHasFixedSize(true);
                                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                                recyclerView.setAdapter(new Adapter<ListName>(listName));

                            }



                        }
                    }


                });





        // Add the following lines to create RecyclerView

        //recyclerView.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {

            //}

        //});

        return view;
    }
}
