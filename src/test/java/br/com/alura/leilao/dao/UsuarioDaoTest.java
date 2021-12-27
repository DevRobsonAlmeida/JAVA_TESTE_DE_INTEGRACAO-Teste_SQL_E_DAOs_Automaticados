package br.com.alura.leilao.dao;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import javax.persistence.NoResultException;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class UsuarioDaoTest {

	    private UsuarioDao dao;
    private EntityManager em;
    
    @BeforeEach
    public void beforeEach(){
        this.em = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(em);
        em.getTransaction().begin();
    }
    
    @AfterEach
    public void afterEach(){
        em.getTransaction().rollback();
    }
    
    
    @Test
    public void testBuscarUsuarioCadastrado() {    
        Usuario usuario = criarUsuario();
        
        Usuario encontrado = this.dao.buscarPorUsername(usuario.getNome());
        assertNotNull(encontrado);
    }
    
    @Test
    public void buscarUsuarioNaoCadastradado(){       
        criarUsuario();
        Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("beltrano"));
    }

    @Test
    public void testDeletar() {
    }

    private Usuario criarUsuario(){
        Usuario usuario = new Usuario("fulano", "fulano@gmail.com", "12345678");
        em.persist(usuario);
        return usuario;
    }

}
