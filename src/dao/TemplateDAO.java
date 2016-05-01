package dao;

import model.Template;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

public class TemplateDAO {
	public static Template saveTemplate(String title){
		//configuring hibernate
		Configuration configuration = new Configuration().configure(); 
		//create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3. Get Session object
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction(); 
        Template template = new Template();
        template.setTitle(title);
        template.setEnable(true);
        Integer id = (Integer) session.save(template);
        template.setId(id);
        transaction.commit();
        session.close();
        return template;        
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
