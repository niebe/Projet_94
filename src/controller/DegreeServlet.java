package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Degree;
import model.Field;
import model.Template;
import dao.FieldDAO;
import dao.ValueDAO;
import dao.DegreeDAO;

public class DegreeServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String codTitle = request.getParameter("degreeCodTitle");
		//String[] labels = request.getParameterValues("fieldLabel");
		
		Enumeration en = request.getParameterNames();
		while(en.hasMoreElements()){
			Object objOri=en.nextElement();
			//Recuperation du field par ID
			String name=(String)objOri;
			String[] id=name.split("_");
			String bddId = id[1];
			Field field = FieldDAO.getById(bddId);
			
			//Recuperation de sa valeur
			String value=request.getParameter(name);
			
			//Enregistrement en base
			//ValueDAO.newValue(value, degree, field);
		}
				
		/*if (request.getParameterMap().containsKey("degreeCodTitle")) {
			//Update of a degree
		}
		else{
			//New degree
			DegreeDAO.saveDegree(codTitle);
			Degree newDegree = DegreeDAO.getDegree();
			for(int i = 0;i<labels.length;i++){
				FieldDAO.createField(labels[i], types[i], newDegree);
			}
		}*/
		response.sendRedirect("dashboard");
	}
}
