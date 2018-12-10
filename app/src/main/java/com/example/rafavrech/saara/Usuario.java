package com.example.rafavrech.saara;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class Usuario implements Serializable {

    private Long id;

    private String nome;

    private String email;

    private String senha;

    private Long curso;

    Usuario (Long id, String nome, String email)
    {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    /*private List<UsuarioMateria> materias;

    private List<Lembrete> lembretes;*/

}
