package com.company.a4kidz.a4kidz.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.company.a4kidz.a4kidz.R;
import com.company.a4kidz.a4kidz.dtos.Memories;

import java.util.List;

/**
 * Created by Fred Rueda on 1/10/2018
 * Developer Fred Rueda
 * Email fredjruedao@gmail.com
 */
public class AdapterListAlbum extends RecyclerView.Adapter<AdapterListAlbum.ItemViewHolder>{

    private List<Memories> memoriesList;
    private View v;
    private Context context;

    public AdapterListAlbum(List<Memories> memoriesList, Context context) {
        this.memoriesList = memoriesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_grid, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.numberPhotos.setText(memoriesList.size()+"");
        holder.textDate.setText(convertDateToString(memoriesList.get(position).getDate()));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView numberPhotos;
        TextView textDate;

        ItemViewHolder(View itemView) {
            super(itemView);
            numberPhotos = (TextView) itemView.findViewById(R.id.numberPhotos);
            textDate = (TextView) itemView.findViewById(R.id.textDate);
        }
    }

    private String convertDateToString(String date){
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String month[] = date.split("-");
        int pos = (Integer.parseInt(month[1])-1);
        return  meses[pos];
    }

}
