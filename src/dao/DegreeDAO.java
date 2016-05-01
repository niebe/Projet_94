package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import model.Degree;

public class DegreeDAO {
	public static List<Degree> getDegrees(){
		//configuring hibernate
		Configuration configuration = new Configuration().configure(); 
		//create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 3. Get Session object
		Session session = sessionFactory.openSession();
		
		Criteria crit = session.createCriteria(Degree.class);
		crit.addOrder(Order.desc("id"));
		return crit.list();
	}
}
