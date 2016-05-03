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
import dao.TemplateDAO;
import dao.ValueDAO;
import dao.DegreeDAO;

public class DegreeServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer degreeId=null;
		if(request.getParameter("degreeId") != ""){
			degreeId=Integer.parseInt(request.getParameter("degreeId"));
		}
		 		
		//String[] labels = request.getParameterValues("fieldLabel");
		Degree degree = null;
		
		if(degreeId == null){
			//On crait un degree et on set l'id
			String degreeCodTitle = request.getParameter("degreeCodTitle");
			DegreeDAO.saveDegree(degreeCodTitle,TemplateDAO.getTemplate());
			degree = DegreeDAO.getLastDegree();			
		}
		else{
			degree = DegreeDAO.getDegree(degreeId);
		}
		
		Enumeration en = request.getParameterNames();
		while(en.hasMoreElements()){
			
			Object objOri=en.nextElement();
			//Recuperation du field par ID
			String name=(String)objOri;
			if(name.contains("value_")){
				String[] id=name.split("_");
				Integer bddId = Integer.parseInt(id[1]);
				Field field = FieldDAO.getById(bddId);
				
				//Recuperation de sa valeur
				String text=request.getParameter(name);
				
				//Enregistrement en base
				ValueDAO.newValue(text, degree, field);				
			}
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
