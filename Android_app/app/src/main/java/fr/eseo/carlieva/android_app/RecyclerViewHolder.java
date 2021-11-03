package fr.eseo.carlieva.android_app;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Random;


public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    private TextView nameView;
    private TextView surnameView;
    public Adapter.OnItemClickListener onItemClickListener;

    public RecyclerViewHolder(@NonNull View itemView, Adapter.OnItemClickListener onItemClickListener) {
        super(itemView);
        nameView=(TextView)itemView.findViewById(R.id.name);
        surnameView=(TextView)itemView.findViewById(R.id.surname);
        this.onItemClickListener=onItemClickListener;
        itemView.setOnClickListener(this);
    }

    public TextView getView(){
        return nameView;
    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick(getAdapterPosition());


    }
}




