package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Portatil;

public class PortatilController {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("portatilesymarcas");
	
	/**
	 * Método para obtener un registro
	 * @param str
	 * @return
	 */
	private static Portatil getRegistro(String str) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery(str, Portatil.class);
		Portatil o;
		try  {
			o = (Portatil) q.getSingleResult();
		}
		catch (NoResultException e) {
			o = null;
		}
		em.close();
		return o;
	}
	
	/**
	 * Método para cargar el primer registro
	 * @return
	 */
	public static Portatil getPrimero() {
		return getRegistro("SELECT * FROM portatil order by id limit 1");
	}
	
	/**
	 * Método para cargar el registro anterior
	 * @param id
	 * @return
	 */
	public static Portatil getAnterior(int id) {
		return getRegistro("SELECT * FROM portatil where id < " + id + " order by id desc limit 1");
	}
	
	/**
	 * Método para cargar el siguiente registro
	 * @param id
	 * @return
	 */
	public static Portatil getSiguiente(int id) {
		return getRegistro("SELECT * FROM portatil where id > " + id + " order by id limit 1");
	}
	
	/**
	 * Método para cargar el último registro
	 * @return
	 */
	public static Portatil getUltimo() {
		return getRegistro("SELECT * FROM portatil order by id desc limit 1");
	}
	
	/**
	 * Método para guardar un registro
	 */
	public static void guardar(Portatil o) {
		if (o.getId() == 0) {
			insertar(o);
		}
		else {
			modificar(o);
		}
	}
	
	/**
	 * Método para insertar un registro
	 */
	private static void insertar(Portatil o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Método para modificar un registro
	 */
	private static void modificar(Portatil o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Método para borrar un registro
	 */
	public static void eliminar(Portatil o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		o = em.merge(o);
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Método para contar la cantidad de registros
	 * @return
	 */
	public static int getTotal() {
		int num = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select count(*) from portatil");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}
