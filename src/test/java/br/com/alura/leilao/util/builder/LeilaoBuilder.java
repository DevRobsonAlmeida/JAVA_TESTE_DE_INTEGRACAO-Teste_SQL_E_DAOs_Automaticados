/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.leilao.util.builder;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author 99030499
 */
public class LeilaoBuilder {
    
    private String nome;
    private BigDecimal valorInicial;
    private LocalDate data;
    private Usuario usuario;

    public LeilaoBuilder comNome(String nome) {
         this.nome = nome;
         return this;
    }
    public LeilaoBuilder comValorInicial(String valorInicial) {
         this.valorInicial = new BigDecimal(valorInicial);
         return this;
    }
    public LeilaoBuilder comData(LocalDate data) {
         this.data = data;
         return this;
    }
    public LeilaoBuilder comUsuario(Usuario usuario) {
         this.usuario = usuario;
         return this;
    }
    
    public Leilao criar(){
        return new Leilao(nome, valorInicial, data, usuario);
    }
    
    
}
