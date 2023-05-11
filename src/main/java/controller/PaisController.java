package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Pais;

public class PaisController {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("portatilesymarcas");

	/** 
	 * Método para obtener un registro a partir de un continente
	 * @return
	 */
	public static List<Pais>findByContinente(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM pais where idContinente = ?", Pais.class);
		q.setParameter(1, id);
		List<Pais> l = (List<Pais>) q.getResultList();
		em.close();
		return l;
	}

}
