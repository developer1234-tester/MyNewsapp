package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newsapp.model.HeadlineResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HeadAdapter extends RecyclerView.Adapter<HeadAdapter.ViewHolder> {
    Context context;
    List<HeadlineResponse.Article> hdlist;

    public HeadAdapter(Context context, List<HeadlineResponse.Article> prolist) {
        this.context = context;
        this.hdlist = prolist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.headmodel, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            holder.htxt.setText(hdlist.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        if (hdlist != null) {
            return hdlist.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView htxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            htxt=itemView.findViewById(R.id.headline);
        }
    }
}
