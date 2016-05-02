package dao;

import java.util.List;

import model.User;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAO {
	public static User userConnect(HttpServletRequest request){
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        User user = new User();
        
        user.setLogin(login);
        user.setPassword(password);
        
        return user;
	}

	public static boolean isRegistered(User user){
		//configuring hibernate
		Configuration configuration = new Configuration().configure(); 
		//create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 3. Get Session object
		Session session = sessionFactory.openSession();

		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.like("login", user.getLogin()));
		crit.add(Restrictions.like("password", user.getPassword()));
		List<User> result = crit.list();
		if(result.size() == 0)
			return false;
		else
			return true;
	}

	public static User getByLogin(String login){
		//configuring hibernate
		Configuration configuration = new Configuration().configure(); 
		//create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 3. Get Session object
		Session session = sessionFactory.openSession();

		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.like("login", login));
		return (User) crit.uniqueResult();	
	}
	
}
