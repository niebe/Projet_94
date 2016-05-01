package dao;

import model.Degree;
import model.Field;
import model.Value;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ValueDAO {
	public static void newValue(String text, Degree degree, Field field){
		//configuring hibernate
		Configuration configuration = new Configuration().configure(); 
		//create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3. Get Session object
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction(); 
        
        Value value = new Value();
        value.setText(text);
        value.setDegree(degree);
        value.setField(field);
        session.save(value);
        transaction.commit();
        session.close();
	}
}
