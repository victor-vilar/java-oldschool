package br.com.victorvilar.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import javax.persistence.EntityManager;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
	public void closeEntitymanager(@Disposes EntityManager em) {
		if(em != null && em.isOpen()) {
			em.close();
		}
	}
}
