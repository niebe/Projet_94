package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	User user = UserDAO.getById(1);
    	Template lastTemplate = TemplateDAO.getTemplate();
    	if(lastTemplate != null){    		
    		List<Field> fields = FieldDAO.getFieldOfTemplate(lastTemplate.getId());
    		request.setAttribute("template", lastTemplate);
    		request.setAttribute("fields", fields);
    	}  
    	if(user.getProfile().getId() == 1){
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
