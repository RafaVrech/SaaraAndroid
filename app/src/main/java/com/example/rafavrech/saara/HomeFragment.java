package com.example.rafavrech.saara;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.rafavrech.saara.adapter.AtividadeResumoAdapter;
import com.example.rafavrech.saara.model.Atividade;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment {
    static HomeFragment homeFragment = null;

    private RecyclerView mRecyclerView;
    private AtividadeResumoAdapter mAdapter;
    private List<Atividade> listaItens;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        View thisView = getView() != null ? getView() :
                inflater.inflate(R.layout.fragment_home, container, false);

        //getting the recyclerview from xml
        mRecyclerView = (RecyclerView) thisView.findViewById(R.id.idRecyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //Populate the products
        listaItens = new ArrayList<>();

        final RequestQueue queue = Volley.newRequestQueue( this.getContext());
        String url ="http://10.0.2.2:8080/usuario/getMaterias";

        Map<String, String> parametrosReq = new HashMap<>();

        String idUsuario =  getActivity().getSharedPreferences("idUsuario", Context.MODE_PRIVATE)
                .getString("idUsuario", "");

        parametrosReq.put("usuarioId", idUsuario);



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
                                System.out.println(response);

                                JSONArray arrayMateriaUsuario = response.getJSONArray("body");
                                for(int i= 0; i < arrayMateriaUsuario.length(); i++)
                                {
                                    JSONObject materiaUsuario = ((JSONObject) arrayMateriaUsuario.get(i));

                                    String nomeMateria = materiaUsuario.getJSONObject("materiaDTO").getString("nome");
                                    String mediaNotas = materiaUsuario.getString("media");

                                    JSONArray notasMateria = materiaUsuario.getJSONArray("notaDTOList");

                                    listaItens.add(new Atividade(R.drawable.ic_327116, nomeMateria,"Media: " + mediaNotas, notasMateria.length() + " notas", " Ver notas", notasMateria));
                                }

                                System.out.println("*****************************************************");
                            }else
                            {
                                Toast.makeText(getActivity(), "Erro " + response.getInt("code") + ": " + response.getString("error"), Toast.LENGTH_LONG).show();
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

        //set adapter to recyclerview
        mAdapter = new AtividadeResumoAdapter(listaItens, this.getContext(), "titulo", "mensagem");
        mRecyclerView.setAdapter(mAdapter);

        homeFragment = this;

        return thisView;
    }
    public static HomeFragment newInstance() {
        return homeFragment == null ? new HomeFragment() : homeFragment;
    }
}
