package com.example.rafavrech.saara.view;

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
    ImageView imageProductImage;
    TextView txtProductName;
    TextView txtProductPrice;
    TextView txtProductWeight;
    TextView txtProductQty;

    public AtividadeResumoViewHolder(View view) {
        super(view);
        imageProductImage=view.findViewById(R.id.idProductImage);
        txtProductName=view.findViewById(R.id.idNomeAtividade);
        txtProductPrice = view.findViewById(R.id.idProductPrice);
        txtProductWeight = view.findViewById(R.id.idProductWeight);
        txtProductQty = view.findViewById(R.id.idProductQty);
    }
}
