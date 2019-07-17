package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Ejercicio;
import hiberUtil.HibernateUtil;

public class EjercicioDao {
	
	public void insertarEjercicio(Ejercicio ejer) {
		
		Transaction transaccion = null;
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()){
			transaccion = sesion.beginTransaction();
			sesion.save(ejer);
			transaccion.commit();
			
		} catch (Exception e) {
			if(transaccion != null) {
				transaccion.rollback();
			}
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public List<Ejercicio> getEjericio(){
		
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			return sesion.createQuery("from Ejercicio", Ejercicio.class).list();
		}	
	}
	
//	public void eliminarEjercicio(Ejercicio ejer) {
//		
//	}
}
