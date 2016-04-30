package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;


public class LoginServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	//UserDAO userDAO = new UserDAO();    	
    	this.getServletContext().getRequestDispatcher( "/login.jsp" ).forward( request, response );
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        if(UserDAO.isRegistered(login,password)){
        	//this.getServletContext().getRequestDispatcher( "/dashboard.jsp" ).forward( request, response );
        	response.sendRedirect("dashboard");
        }
        else{
        	request.setAttribute("errorRedirect", "true");
        	this.getServletContext().getRequestDispatcher( "/login.jsp" ).forward( request, response );
        }
    }    
}
