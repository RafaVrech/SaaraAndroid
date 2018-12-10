package com.example.rafavrech.saara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.rafavrech.saara.adapter.AtividadeResumoAdapter;
import com.example.rafavrech.saara.model.Atividade;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private AtividadeResumoAdapter mAdapter;
    private List<Atividade> listaItens;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View thisView = inflater.inflate(R.layout.fragment_home, container, false);

        //getting the recyclerview from xml
        mRecyclerView = (RecyclerView) thisView.findViewById(R.id.idRecyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //Populate the products
        listaItens = new ArrayList<>();
/*        listaItens.add(new Atividade(R.drawable.ic_327116,"Mango","Rs. 150", "1 kg", "5"));
        listaItens.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        listaItens.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        listaItens.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        listaItens.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        listaItens.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        listaItens.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        listaItens.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        listaItens.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        listaItens.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        listaItens.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        listaItens.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));
        listaItens.add(new Atividade(R.drawable.ic_327116,"Pineapple","Rs. 250", "500 gm", "2"));*/

        //set adapter to recyclerview
        mAdapter = new AtividadeResumoAdapter(listaItens, this.getContext(), "titulo", "mensagem");
        mRecyclerView.setAdapter(mAdapter);




        RequestQueue queue = Volley.newRequestQueue( this.getContext());
        String url ="http://10.0.2.2:8080/usuario/getMaterias";

        Map<String, String> parametrosReq = new HashMap<>();

        parametrosReq.put("usuarioId", "1");

        CustomJsonObjectRequest request = new CustomJsonObjectRequest(
                Request.Method.POST,
                url,
                parametrosReq,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Script","SUCCESS: " + response);
                        System.out.println("*****************************************************");
                        System.out.println(response);

                        try {
                            if(response.getInt("code") == 0)
                            {
                                System.out.println("*****************************************************");
                                System.out.println(response);//TODO PAREI AQUi
                                System.out.println("*****************************************************");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("*************************ERRO DE CHAMADA****************************");
                System.out.println(error.getMessage());
                System.out.println("*****************************************************");
            }
        });
        queue.add(request);

        return thisView;
    }
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}
