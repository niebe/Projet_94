package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Degree;
import model.Field;
import model.Template;
import model.User;
import dao.DegreeDAO;
import dao.FieldDAO;
import dao.TemplateDAO;
import dao.UserDAO;

public class DashBoardServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	//Recuperation de la session en cours
    	HttpSession session = request.getSession();
    	//Recuperation du Bean user
    	User user = (User) session.getAttribute("sessionUtilisateur");
    	
    	User userComplete = UserDAO.getByLogin(user.getLogin());
    	
    	Template lastTemplate = TemplateDAO.getTemplate();
    	if(lastTemplate != null){    		
    		List<Field> fields = FieldDAO.getFieldOfTemplate(lastTemplate.getId());
    		request.setAttribute("template", lastTemplate);
    		request.setAttribute("fields", fields);
    	}  
    	if(userComplete.getProfile().getId() == 1){
    		request.setAttribute("profileId", 1);
    	}
    	else{
    		List<Degree> degrees = DegreeDAO.getDegrees();
    		request.setAttribute("profileId", 2);
    		request.setAttribute("degrees", degrees);
    	}

    	this.getServletContext().getRequestDispatcher( "/dashboard.jsp" ).forward( request, response );
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }   
}
