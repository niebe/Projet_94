package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Degree;
import model.Template;
import dao.FieldDAO;
import dao.DegreeDAO;

public class DegreeServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String codTitle = request.getParameter("degreeCodTitle");
		//String[] labels = request.getParameterValues("fieldLabel");
		
		Enumeration en = request.getParameterNames();
		while(en.hasMoreElements()){
			Object objOri=en.nextElement();
			String name=(String)objOri;
			String value=request.getParameter(name);
			
		}
				
		if (request.getParameterMap().containsKey("degreeCodTitle")) {
			//Update of a degree
		}
		else{
			//New degree
			DegreeDAO.saveDegree(codTitle);
			Degree newDegree = DegreeDAO.getDegree();
			for(int i = 0;i<labels.length;i++){
				FieldDAO.createField(labels[i], types[i], newDegree);
			}
		}
		response.sendRedirect("dashboard");
	}
}
