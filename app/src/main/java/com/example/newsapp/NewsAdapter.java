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

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    Context context;
    List<CategoryResponse.Source> hlist;

    public NewsAdapter(Context context, List<CategoryResponse.Source> prolist){
        this.context = context;
        this.hlist = prolist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.newmodel, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {

        holder.htxt.setText(hlist.get(position).getName());
        holder.newstxt.setText(hlist.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        if (hlist != null) {
            return hlist.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView htxt,newstxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            htxt=itemView.findViewById(R.id.head);
            newstxt=itemView.findViewById(R.id.news);
        }
    }
}
