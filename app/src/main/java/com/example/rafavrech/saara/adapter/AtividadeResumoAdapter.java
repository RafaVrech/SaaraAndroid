package com.example.rafavrech.saara.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rafavrech.saara.DialogAnotacao;
import com.example.rafavrech.saara.R;
import com.example.rafavrech.saara.model.Atividade;
import com.example.rafavrech.saara.view.AtividadeResumoViewHolder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AtividadeResumoAdapter extends RecyclerView.Adapter<AtividadeResumoViewHolder> {

    private List<Atividade> atividades;
    Context context;
    String titulo, mensagem;

    @Override
    public AtividadeResumoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View atividadeResumoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_atividade_card, parent, false);
        AtividadeResumoViewHolder gvh = new AtividadeResumoViewHolder(atividadeResumoView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(AtividadeResumoViewHolder holder, final int position) {
        holder.getImgImagem().setImageResource(atividades.get(position).getImagem());
        holder.getTxtTitulo().setText(atividades.get(position).getTitulo());
        holder.getTxtSubTitulo().setText(atividades.get(position).getSubTitulo());
        holder.getTxtSubInfo().setText(atividades.get(position).getSubInfo());
        holder.getTxtInfo().setText(atividades.get(position).getInfo());

        holder.getCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = atividades.get(position).getTitulo();

                Toast.makeText(context, "A disciplina " + titulo + " foi selecionada", Toast.LENGTH_SHORT).show();


                String mensagem = atividades.get(position).getSubTitulo() + "\n\n" +
                        "   " + atividades.get(position).getSubInfo() + ": \n";

                for(int i = 0; i < atividades.get(position).getListaNotas().length(); i++)
                {

                    try {
                        mensagem += "       Nota: " + atividades.get(position).getListaNotas().getJSONObject(i).getString("valor") + "\n";
                        mensagem += "       Peso: " + atividades.get(position).getListaNotas().getJSONObject(i).getString("pesoNota") + "\n";
                        mensagem += "       Tipo: " + atividades.get(position).getListaNotas().getJSONObject(i).getString("tipo") + "\n";

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if(i + 1 != atividades.get(position).getListaNotas().length())
                        mensagem += "\n";
                }

                DialogFragment dialog = new DialogAnotacao().newInstance( titulo, mensagem);

                dialog.show(((AppCompatActivity)context).getSupportFragmentManager(), "MyDialogFragmentTag");

            }
        });
    }

    @Override
    public int getItemCount() {
        return atividades.size();
    }
}
