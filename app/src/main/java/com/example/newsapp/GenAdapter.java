package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class GenAdapter extends RecyclerView.Adapter<GenAdapter.ViewHolder> {
    FragmentActivity activity;
    List<GenResponse.Source> glist;
    public GenAdapter(FragmentActivity activity, List<GenResponse.Source> dlist) {
        this.activity=activity;
        this.glist=dlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.newmodel, parent, false);
        GenAdapter.ViewHolder holder = new GenAdapter.ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.gtxt.setText(glist.get(position).getName());
        holder.newtxt.setText(glist.get(position).getDescription());
    }


    @Override
    public int getItemCount() {
        if (glist != null) {
            return glist.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView gtxt,newtxt;
        public ViewHolder(View v) {
            super(v);
            gtxt=v.findViewById(R.id.head);
            newtxt=v.findViewById(R.id.news);
        }
    }
}
