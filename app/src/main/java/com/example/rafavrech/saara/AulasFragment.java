package com.example.rafavrech.saara;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rafavrech.saara.adapter.AtividadeResumoAdapter;
import com.example.rafavrech.saara.model.Atividade;

import java.util.ArrayList;
import java.util.List;

public class AulasFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private AtividadeResumoAdapter mAdapter;
    private List<Atividade> mProductList;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View thisView = inflater.inflate(R.layout.fragment_aulas, container, false);

        //getting the recyclerview from xml
        mRecyclerView = (RecyclerView) thisView.findViewById(R.id.idRecyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //Populate the products
        mProductList = new ArrayList<>();
        mProductList.add(new Atividade(R.drawable.ic_327116,"Sistemas Operacionais","Predio H8 Sala 16", "Segundas feiras", "Prova e trabalho marcados"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Predio H11 Sala 36", "Terças feiras", "Prova marcada"));

        //set adapter to recyclerview
        mAdapter = new AtividadeResumoAdapter(mProductList, this.getContext());
        mRecyclerView.setAdapter(mAdapter);

        return thisView;

    }
    public static AulasFragment newInstance() {
        return new AulasFragment();
    }
}
