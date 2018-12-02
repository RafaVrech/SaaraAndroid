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

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private AtividadeResumoAdapter mAdapter;
    private List<Atividade> mProductList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View thisView = inflater.inflate(R.layout.fragment_home, container, false);

        //getting the recyclerview from xml
        mRecyclerView = (RecyclerView) thisView.findViewById(R.id.idRecyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //Populate the products
        mProductList = new ArrayList<>();
        mProductList.add(new Atividade(R.drawable.ic_327116,"Mango","Rs. 150", "1 kg", "5"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        mProductList.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));

        //set adapter to recyclerview
        mAdapter = new AtividadeResumoAdapter(mProductList, this.getContext());
        mRecyclerView.setAdapter(mAdapter);

        return thisView;
    }
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}
