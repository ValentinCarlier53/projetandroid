package fr.eseo.carlieva.android_app;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Random;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {


    private TextView nameView;
    private TextView surnameView;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView=(TextView)itemView.findViewById(R.id.name);
        surnameView=(TextView)itemView.findViewById(R.id.surname);
    }

    public TextView getView(){
        return nameView;
    }

}




