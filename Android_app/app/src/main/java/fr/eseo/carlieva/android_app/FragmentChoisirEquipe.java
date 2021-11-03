

package fr.eseo.carlieva.android_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.carlieva.android_app.pojo.User;
import fr.eseo.carlieva.android_app.service.UserService;



public class FragmentChoisirEquipe extends Fragment implements Adapter.OnItemClickListener {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "DocSnippets";
    // Add RecyclerView member
    private RecyclerView recyclerView;
    private List<ListName> listName;
    private Adapter onClickRecyclerAdapter;
    //private AdapterView.onItemClickListener myListClickListener=new AdapterView<>();

    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choisir_equipe, container, false);
        listName=new ArrayList<>();
        ListName firstName= new ListName("Valentin","Carlier");
        listName.add(firstName);
        listName.add(new ListName("Jean-Baptiste","Le Henaff"));
        listName.add(new ListName("Valentin","Carlier"));
        listName.add(new ListName("Jean-Baptiste","Le Henaff"));
        listName.add(new ListName("Valentin","Carlier"));
        listName.add(new ListName("Jean-Baptiste","Le Henaff"));

        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        onClickRecyclerAdapter= new Adapter<ListName>(listName,this);
        recyclerView.setAdapter(onClickRecyclerAdapter);

        //Log.d(TAG,"taille"+new UserService().getAllUser());
        //
        /*

        ArrayList<User> users = new UserService().getAllUser();
        Log.d(TAG,"je me suis perdu"+users.size());
        for (int i=0;i<users.size();i++){

            listName.add(new ListName(users.get(i).getPrenom(),users.get(i).getNom()));
        }
        */

        /*db.collection("User").get()

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


                });*/







        //recyclerView.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {

            //}

        //});

        return view;
    }

    @Override
    public void onItemClick(int position) {
        listName.get(position);
        Toast.makeText(getActivity(), "item clicked", Toast.LENGTH_LONG).show();
    }
}
