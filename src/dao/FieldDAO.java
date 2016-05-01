package dao;

import java.util.List;

import model.Field;
import model.Template;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class FieldDAO {
	public static void createField(String name, String type, Template template){
		//configuring hibernate
		Configuration configuration = new Configuration().configure(); 
		//create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3. Get Session object
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction(); 
        Field field = new Field();
        field.setAlterable(true);
        field.setName(name);
        field.setType(type);
        field.setTemplate(template);
        session.save(field);
        transaction.commit();
        session.close();
	}
	
	public static List<Field> getFieldOfTemplate(Integer id){
		//configuring hibernate
		Configuration configuration = new Configuration().configure(); 
		//create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3. Get Session object
        Session session = sessionFactory.openSession();
        
        Criteria crit = session.createCriteria(Field.class);
        crit.add(Restrictions.like("template.id", id));
        return crit.list();
	}
}
