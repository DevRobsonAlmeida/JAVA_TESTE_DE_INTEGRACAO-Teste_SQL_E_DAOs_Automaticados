/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.leilao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 99030499
 */
public class JPAUtil {
    
	private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("tests");

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
    
}
