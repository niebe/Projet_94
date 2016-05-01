package dao;

import java.util.List;

import model.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAO {

	public static boolean isRegistered(String login, String pwd){
		//configuring hibernate
		Configuration configuration = new Configuration().configure(); 
		//create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 3. Get Session object
		Session session = sessionFactory.openSession();

		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.like("login", login));
		crit.add(Restrictions.like("password", pwd));
		List<User> result = crit.list();
		if(result.size() == 0)
			return false;
		else
			return true;
	}

	public static User getById(Integer id){
		//configuring hibernate
		Configuration configuration = new Configuration().configure(); 
		//create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 3. Get Session object
		Session session = sessionFactory.openSession();

		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.like("id", id));
		return (User) crit.uniqueResult();	
	}
}
