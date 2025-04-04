package com.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import com.hibernate.model.Ciudad;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Transaction;

public class CiudadDAO {

	//Inserción
	public void insertCiudad(Ciudad c) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(c);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Error al insertar una nueva ciudad");
		}
	}
	
	//Borrado
	public void deleteCiudad(int codigo) {
		Transaction transaction = null;
		Ciudad cd = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			cd = session.get(Ciudad.class, codigo);
			session.remove(cd);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Error al borrar una ciudad");
		}
	}
	
	//Actualización
	public void updateCiudad(Ciudad c, int codigo) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(c);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Error al actualizar una ciudad");
		}
	}
	
	//Selección simple
	public Ciudad selectCiudadById(int codigo) {
		Transaction transaction = null;
		Ciudad c = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			c = session.get(Ciudad.class, codigo);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Error al seleccionar los datos de una ciudad");
		}
		return c;
	}
	
	//Selección múltiple
	public List<Ciudad> selectAllCiudades() {
		Transaction transaction = null;
		List<Ciudad> ciudades = null;
		Ciudad c = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			ciudades = session.createQuery("FROM Ciudad", Ciudad.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Error al seleccionar todas las ciudades");
		}
		return ciudades;
	}
}