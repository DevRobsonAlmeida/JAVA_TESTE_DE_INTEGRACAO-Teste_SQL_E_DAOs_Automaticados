/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.LeilaoBuilder;
import br.com.alura.leilao.util.builder.UsuarioBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 *
 * @author 99030499
 */
class LeilaoDaoTest {

    private LeilaoDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new LeilaoDao(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();
    }

    @Test
    public void testCadastrarLeicao() {
        Usuario usuario = new UsuarioBuilder()
                .comNome("fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678")
                .criar();
        em.persist(usuario);
        
        Leilao leilao = new LeilaoBuilder()
                .comNome("Mochila")
                .comValorInicial("500")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .criar();
        
        leilao = this.dao.salvar(leilao);
        
        Leilao salvo = this.dao.buscarPorId(leilao.getId());
        assertNotNull(salvo);
    }
    
    @Test
    public void testAtualizarLeicao() {
        Usuario usuario = new UsuarioBuilder()
                .comNome("fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678")
                .criar();
        em.persist(usuario);
        
        Leilao leilao = new LeilaoBuilder()
                .comNome("Mochila")
                .comValorInicial("500")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .criar();
        
        leilao = this.dao.salvar(leilao);
        
        leilao.setNome("Celular");
        leilao.setValorInicial(new BigDecimal("400"));
        leilao = dao.salvar(leilao);
        
        Leilao salvo = this.dao.buscarPorId(leilao.getId());
        assertEquals("Celular", salvo.getNome());
        assertEquals(new BigDecimal("400"), salvo.getValorInicial());
    }
    



    
}
