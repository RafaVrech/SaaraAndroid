package com.example.rafavrech.saara.view;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rafavrech.saara.R;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AtividadeResumoViewHolder extends RecyclerView.ViewHolder  {
    ImageView imgImagem;
    TextView txtTitulo;
    TextView txtSubTitulo;
    TextView txtInfo;
    TextView txtSubInfo;
    ImageView iconeInfo;
    CardView card;

    public AtividadeResumoViewHolder(View view) {
        super(view);
        imgImagem=view.findViewById(R.id.idImagem);
        txtTitulo=view.findViewById(R.id.idTitulo);
        txtSubTitulo = view.findViewById(R.id.idSubTitulo);
        txtInfo = view.findViewById(R.id.idInfo);
        txtSubInfo = view.findViewById(R.id.idSubInfo);
        iconeInfo = view.findViewById(R.id.idIconeInfo);
        card = view.findViewById(R.id.idCardView);
    }
}
