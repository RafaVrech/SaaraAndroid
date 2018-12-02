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

public class AnotacoesFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private AtividadeResumoAdapter mAdapter;
    private List<Atividade> mProductList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View thisView = inflater.inflate(R.layout.fragment_anotacoes, container, false);

        //getting the recyclerview from xml
        mRecyclerView = (RecyclerView) thisView.findViewById(R.id.idRecyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //Populate the products
        mProductList = new ArrayList<>();
        mProductList.add(new Atividade(R.drawable.ic_327116,"Sistemas operacionais","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Banco de dados","Pedaço de texto da anotação que est...", "01/12/18", "Pressione para ver a anotação"));

        //set adapter to recyclerview
        mAdapter = new AtividadeResumoAdapter(mProductList, this.getContext(), "", "");
        mRecyclerView.setAdapter(mAdapter);

        return thisView;
    }
    public static AnotacoesFragment newInstance() {
        return new AnotacoesFragment();
    }
}
