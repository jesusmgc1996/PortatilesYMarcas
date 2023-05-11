package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Marca;

public class MarcaController {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("portatilesymarcas");

	/** 
	 * Método para obtener todos los registros
	 * @return
	 */
	public static List<Marca> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("Marca.findAll");
		List<Marca> l = (List<Marca>) q.getResultList();
		em.close();
		return l;
	}
	
	/**
	 * Método para modificar un registro
	 */
	public static void modificar(Marca o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
		em.close();
	}

}
