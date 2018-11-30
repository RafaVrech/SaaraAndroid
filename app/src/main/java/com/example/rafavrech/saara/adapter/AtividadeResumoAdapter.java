package com.example.rafavrech.saara.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rafavrech.saara.R;
import com.example.rafavrech.saara.model.Atividade;
import com.example.rafavrech.saara.view.AtividadeResumoViewHolder;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AtividadeResumoAdapter extends RecyclerView.Adapter<AtividadeResumoViewHolder> {

    private List<Atividade> atividades;
    Context context;


    @Override
    public AtividadeResumoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View atividadeResumoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_atividade_card, parent, false);
        AtividadeResumoViewHolder gvh = new AtividadeResumoViewHolder(atividadeResumoView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(AtividadeResumoViewHolder holder, final int position) {
        holder.getImageProductImage().setImageResource(atividades.get(position).getProductImage());
        holder.getTxtProductName().setText(atividades.get(position).getProductName());
        holder.getTxtProductPrice().setText(atividades.get(position).getProductPrice());
        holder.getTxtProductWeight().setText(atividades.get(position).getProductWeight());
        holder.getTxtProductQty().setText(atividades.get(position).getProductQty());

        holder.getImageProductImage().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = atividades.get(position).getProductName().toString();
                Toast.makeText(context, productName + " is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return atividades.size();
    }
}
