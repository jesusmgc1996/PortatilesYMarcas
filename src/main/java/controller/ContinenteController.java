package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Continente;

public class ContinenteController {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("portatilesymarcas");

	/** 
	 * Método para obtener todos los registros
	 * @return
	 */
	public static List<Continente> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("Continente.findAll");
		List<Continente> l = (List<Continente>) q.getResultList();
		em.close();
		return l;
	}

}
