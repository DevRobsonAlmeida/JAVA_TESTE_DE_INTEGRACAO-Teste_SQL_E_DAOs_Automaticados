/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.leilao.util.builder;

import br.com.alura.leilao.model.Usuario;

/**
 *
 * @author 99030499
 */
public class LanceBuilder {

    private String nome;
    private String email;
    private String senha;

    public LanceBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LanceBuilder comEmail(String email) {
        this.email = email;
        return this;
    }

    public LanceBuilder comSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public Usuario criar() {
        return new Usuario(nome, email, nome);
    }
}
