package com.company.a4kidz.a4kidz.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.a4kidz.a4kidz.R;
import com.company.a4kidz.a4kidz.dtos.Memories;
import com.company.a4kidz.a4kidz.utils.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Fred Rueda on 1/10/2018
 * Developer Fred Rueda
 * Email fredjruedao@gmail.com
 */
public class AdapterListPhotos extends RecyclerView.Adapter<AdapterListPhotos.ItemViewHolder> {

    private List<Memories> memories;
    private Context context;
    private View v;

    public AdapterListPhotos(List<Memories> memories, Context context) {
        this.memories = memories;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_photos, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        if(!memories.get(position).getCaption().equals("")) {
            holder.description.setText(memories.get(position).getCaption());
        }else{
            holder.description.setText("No hay descripción");
        }
        holder.dateDescription.setText(memories.get(position).getDate());
        if (position == 0) {
            holder.date.setVisibility(View.VISIBLE);
            holder.date.setText(convertDateToString(memories.get(position).getDate()));
        }else{
            holder.date.setVisibility(View.GONE);
        }
        if(memories.get(position).getVideo_checked() != 1) {
            Picasso.get().load(memories.get(position).getPhotos().get(0).getPhoto()).into(holder.image);
        }else{
            Picasso.get().load(memories.get(position).getPhotos().get(0).getThumbnail()).into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return memories.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView dateDescription;
        TextView description;
        TextView date;
        ImageView image;

        ItemViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.textDate);
            description = (TextView) itemView.findViewById(R.id.description);
            dateDescription = (TextView) itemView.findViewById(R.id.datedescription);
            image = (ImageView) itemView.findViewById(R.id.imgrecycler);
        }
    }

    private String convertDateToString(String date){
        String dateFInal = "";
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String month[] = date.split("-");
        int pos = (Integer.parseInt(month[1])-1);
        dateFInal = meses[pos]+ " " +month[0];
        return  dateFInal;
    }

}
