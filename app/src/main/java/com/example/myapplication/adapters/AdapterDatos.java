package com.example.myapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activities.SecondActivity;
import com.example.myapplication.models.PersonModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<PersonModel> listDatos;
    private Activity activity;
    private Context context;

    public AdapterDatos(ArrayList<PersonModel> listDatos, Activity activity, Context context){
        this.listDatos = listDatos;
        this.activity = activity;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_main, null, false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        PersonModel personModel = listDatos.get(position);
        holder.textView1.setText(personModel.getName());
        holder.textView2.setText(personModel.getBody());
        holder.imageView.setImageResource(personModel.getPaisajes());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, SecondActivity.class);
                intent.putExtra("image", personModel.getPaisajes());
                intent.putExtra("title", personModel.getName());
                intent.putExtra("body", personModel.getBody());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        TextView textView1;
        TextView textView2;
        ImageView imageView;
        CardView cardView;

        public ViewHolderDatos(View itemView){
            super(itemView);
            textView1 = itemView.findViewById(R.id.tv1);
            textView2 = itemView.findViewById(R.id.tv2);
            imageView = itemView.findViewById(R.id.imagePost);
            cardView = itemView.findViewById(R.id.cardViewPost);
        }
    }

}
