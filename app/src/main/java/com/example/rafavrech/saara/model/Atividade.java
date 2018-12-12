package com.example.rafavrech.saara.model;


import org.json.JSONArray;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Atividade {
    public int imagem;
    public String titulo;
    public String subTitulo;
    public String subInfo;
    public String info;
    public JSONArray listaNotas;

}
