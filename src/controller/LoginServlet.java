package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;


public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	//UserDAO userDAO = new UserDAO();    	
    	this.getServletContext().getRequestDispatcher( "/login.jsp" ).forward( request, response );
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User user = UserDAO.userConnect(request);
    	
    	boolean registeredUser = UserDAO.isRegistered(user);
  
    	// Récupération de la session depuis la requête
    	HttpSession session = request.getSession();
    	
        if(registeredUser){
        	//this.getServletContext().getRequestDispatcher( "/dashboard.jsp" ).forward( request, response );

        	//Ajout du Bean user a la session
        	session.setAttribute("sessionUtilisateur", user );
        	//Stockage du Bean dans l'objet Request
        	request.setAttribute("utilisateur", user );
        	//Redirection vers le dashboard
        	response.sendRedirect("dashboard");
        }
        else{
        	//Suppression du Bean de la session
        	session.setAttribute("sessionUtilisateur", null );
        	
        	request.setAttribute("errorRedirect", "true");
        	this.getServletContext().getRequestDispatcher( "/login.jsp" ).forward( request, response );
        }
    }    
}
