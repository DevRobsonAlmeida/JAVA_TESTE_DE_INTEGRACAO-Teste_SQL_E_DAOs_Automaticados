package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Leilao;
import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
        Leilao leilao = criarLeilao();
        leilao = this.dao.salvar(leilao);
        
        Leilao salvo = this.dao.buscarPorId(leilao.getId());
        assertNotNull(salvo);
    }
    
    @Test
    public void testAtualizarLeicao() {
        Leilao leilao = criarLeilao();
        leilao = this.dao.salvar(leilao);
        
        leilao.setNome("Celular");
        leilao.setValorInicial(new BigDecimal("400"));
        leilao = dao.salvar(leilao);
        
        Leilao salvo = this.dao.buscarPorId(leilao.getId());
        assertEquals("Celular", salvo.getNome());
        assertEquals(new BigDecimal("400"), salvo.getValorInicial());
    }
    

    private Usuario criarUsuario() {
        Usuario usuario = new Usuario("fulano", "fulano@gmail.com", "12345678");
        em.persist(usuario);
        return usuario;
    }
    
    private Leilao criarLeilao(){
        Usuario usuario = criarUsuario();
        Leilao leilao = new Leilao("Mochila", new BigDecimal("70"), LocalDate.now(), usuario);
        return leilao;
    }

}
