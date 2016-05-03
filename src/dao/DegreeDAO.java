package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import model.Degree;
import model.Template;

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
	
	public static Degree saveDegree(String codTitle){
		//configuring hibernate
		Configuration configuration = new Configuration().configure(); 
		//create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3. Get Session object
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction(); 
        Degree degree = new Degree();
        degree.setCodTitle(codTitle);
        degree.setEnable(true);
        Integer id = (Integer) session.save(degree);
        degree.setId(id);
        //degree.setTemplate(template);
        transaction.commit();
        session.close();
        return degree;        
	}
	
	//Renvoie le template actif (le dernier)
	public static Template getTemplate(){
		//configuring hibernate
		Configuration configuration = new Configuration().configure(); 
		//create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3. Get Session object
        Session session = sessionFactory.openSession();
        
        Criteria crit = session.createCriteria(Template.class);
        crit.addOrder(Order.desc("id"));
        crit.setMaxResults(1);
        return (Template) crit.uniqueResult();
	}
}
