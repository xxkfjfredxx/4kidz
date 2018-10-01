package com.company.a4kidz.a4kidz.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.a4kidz.a4kidz.R;
import com.company.a4kidz.a4kidz.dtos.Memories;

import java.util.List;

/**
 * Created by Fred Rueda on 1/10/2018
 * Developer Fred Rueda
 * Email fredjruedao@gmail.com
 */
public class AdapterPreviewAlbum extends RecyclerView.Adapter<AdapterPreviewAlbum.ItemViewHolder> {

    private List<Memories> memories;
    private Context context;
    private View v;

    public AdapterPreviewAlbum(List<Memories> memories, Context context) {
        this.memories = memories;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_album, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.date.setText(convertDate(memories.get(position).getDate()));
        holder.gridAlbum.setLayoutManager(new GridLayoutManager(context, 2));
        holder.gridAlbum.setAdapter(new AdapterListAlbum(memories,context));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        RecyclerView gridAlbum;
        TextView date;

        ItemViewHolder(View itemView) {
            super(itemView);
            gridAlbum = (RecyclerView) itemView.findViewById(R.id.recyclerAlbum);
            date = (TextView) itemView.findViewById(R.id.dateAlbum);
        }
    }

    private String convertDate(String date){
        String month[] = date.split("-");
        return  month[0];
    }

}
