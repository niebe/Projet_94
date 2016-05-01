package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Template;
import dao.FieldDAO;
import dao.TemplateDAO;

public class TemplateServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String title = request.getParameter("templateName");
		String[] labels = request.getParameterValues("fieldLabel");
		String[] types = request.getParameterValues("fieldType");
		if (request.getParameterMap().containsKey("templateId")) {
			//Update of a template
		}
		else{
			//New Template 
			TemplateDAO.saveTemplate(title);
			Template newTemplate = TemplateDAO.getTemplate();
			for(int i = 0;i<labels.length;i++){
				FieldDAO.createField(labels[i], types[i], newTemplate);
			}
		}
		response.sendRedirect("dashboard");
	}
}
