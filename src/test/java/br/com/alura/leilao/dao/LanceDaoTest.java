/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.UsuarioBuilder;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 99030499
 */
public class LanceDaoTest {
    
    private LanceDao dao;
    private EntityManager em;
    
    @Before
    public void setUp() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new LanceDao(em);
        em.getTransaction().begin();
    }
    
    @After
    public void tearDown() {
        em.getTransaction().rollback();
    }

    @Test
    public void testSalvar() {
        Usuario usuario = new UsuarioBuilder()
                .comNome("fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678")
                .criar();
        Lance lance = new Lance(usuario, new BigDecimal("70"));
    }

    @Test
    public void testBuscarMaiorLanceDoLeilao() {
    }
    
}
