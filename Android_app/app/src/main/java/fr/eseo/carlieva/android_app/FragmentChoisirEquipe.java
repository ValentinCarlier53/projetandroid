package fr.eseo.carlieva.android_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentChoisirEquipe#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentChoisirEquipe extends Fragment implements RecyclerView.OnItemClickListener {
    // Add RecyclerView member
    private RecyclerView recyclerView;
    private List<ListName> listName;
    private Adapter<ListName> adapter;
    private AdapterView.onItemClickListener myListClickListener=new AdapterView<>()

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
        recyclerView.setAdapter(new Adapter<L>(listName));
        //recyclerView.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {

            //}

        //});

        return view;
    }
}