package br.com.alura.leilao.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import java.util.logging.Logger;

@Repository
public class LanceDao {
    
    
    private EntityManager em;
    private static final Logger LOG = Logger.getLogger(LanceDao.class.getName());

    public LanceDao(EntityManager em) {
        this.em = em;
    }

    public Lance salvar(Lance lance) {
        return em.merge(lance);
    }

    public Lance buscarMaiorLanceDoLeilao(Leilao leilao) {
        return em.createQuery("SELECT l FROM Lance l WHERE l.valor = (SELECT MAX(lance.valor) FROM Lance lance)", Lance.class)
                .setParameter("leilao", leilao)
                .getSingleResult();
    }

}
