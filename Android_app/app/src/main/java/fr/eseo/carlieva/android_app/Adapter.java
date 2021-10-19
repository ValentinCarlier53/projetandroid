package fr.eseo.carlieva.android_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class Adapter<L> extends RecyclerView.Adapter<RecyclerViewHolder> {
    private Random random;
    List<ListName>names;

    public Adapter(List<ListName> names){
        this.names=names;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.list_of_names;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.getView().setText(names.get(position).getName()+names.get(position).getSurname());
    }

    @Override
    public int getItemCount() {
        return names.size();
    }



}
